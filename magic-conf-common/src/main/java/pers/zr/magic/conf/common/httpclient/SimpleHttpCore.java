package pers.zr.magic.conf.common.httpclient;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class SimpleHttpCore {

    private final Logger log = LoggerFactory.getLogger(SimpleHttpCore.class);

    protected abstract CloseableHttpClient createHttpClient() throws SimpleHttpException;


    public SimpleHttpResponse sendRequest(SimpleHttpRequest simpleHttpRequest) throws SimpleHttpException {
        if(simpleHttpRequest == null) {
            throw new SimpleHttpException("parameter invalid, SimpleHttpRequest can not be null");
        }
        if(RequestMethodType.GET.equals(simpleHttpRequest.getMethod())) {
            return sendGet(simpleHttpRequest);
        }else if(RequestMethodType.POST.equals(simpleHttpRequest.getMethod())){
            return sendPost(simpleHttpRequest);
        }else {
            // TODO 其它类型的RequestType实现

            throw new SimpleHttpException("parameter invalid, simpleHttpRequest method [" + simpleHttpRequest.getContentType() + "] is not support");
        }
    }

    private SimpleHttpResponse sendGet(SimpleHttpRequest simpleHttpRequest) throws SimpleHttpException {
        //设置请求body
        StringBuilder finalUrl = new StringBuilder(simpleHttpRequest.getUri());
        String encodedRequestString = getEncodedUrlString(simpleHttpRequest.getParams());
        if(encodedRequestString != null) {
            finalUrl.append("?").append(encodedRequestString);
        }
        HttpGet httpGet = new HttpGet(finalUrl.toString());

        //设置请求headers
        Map<String, String> headers = simpleHttpRequest.getHeaders();
        if(headers != null && !headers.isEmpty()) {
            for(String key : headers.keySet()) {
                httpGet.setHeader(key, headers.get(key));
            }
        }

        //设置请求超时时间
        RequestTimeout timeout = simpleHttpRequest.getTimeout();
        if(timeout != null) {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(timeout.getConnectionTimeout())
                    .setSocketTimeout(timeout.getSocketTimeout()).build();
            httpGet.setConfig(requestConfig);
        }
        return executeForBytes(httpGet);
    }


    private SimpleHttpResponse sendPost(SimpleHttpRequest simpleHttpRequest) throws SimpleHttpException {
        //设置请求body
        HttpEntity requestEntity;
        if(RequestContentType.APPLICATION_FORM_URLENCODED.equals(simpleHttpRequest.getContentType())) {
            requestEntity = getEncodedFormEntity(simpleHttpRequest.getParams());
        }else if(RequestContentType.APPLICATION_JSON.equals(simpleHttpRequest.getContentType())) {
            requestEntity = getEncodedJsonEntity(simpleHttpRequest.getParams());
        }else {
            throw new SimpleHttpException("parameter invalid, SimpleHttpRequest content type[" +
                    simpleHttpRequest.getContentType() + "] is not support!");
        }
        if(requestEntity == null) {
            throw new SimpleHttpException("parameter invalid, SimpleHttpRequest body can not be null");
        }
        HttpPost httpPost = new HttpPost(simpleHttpRequest.getUri());
        httpPost.setEntity(requestEntity);

        //设置请求headers
        Map<String, String> headers = simpleHttpRequest.getHeaders();
        if(headers != null && !headers.isEmpty()) {
            for(String key : headers.keySet()) {
                httpPost.setHeader(key, headers.get(key));
            }
        }

        //设置请求超时时间
        RequestTimeout timeout = simpleHttpRequest.getTimeout();
        if(timeout != null) {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(timeout.getConnectionTimeout())
                    .setSocketTimeout(timeout.getSocketTimeout()).build();
            httpPost.setConfig(requestConfig);
        }
        return executeForBytes(httpPost);

    }


    private String getEncodedUrlString(Map<?,?> params) {
        String encodedRequestString = null;
        if(params != null && !params.isEmpty()) {
            List<NameValuePair> nvpList = params.entrySet()
                    .stream().filter(entry -> entry.getKey() != null && entry.getValue() != null)
                    .map(entry -> new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()))
                    .collect(Collectors.toList());
            encodedRequestString = URLEncodedUtils.format(nvpList, Charset.defaultCharset());
        }
        return encodedRequestString;
    }

    private UrlEncodedFormEntity getEncodedFormEntity(Map<?,?> params) {
        UrlEncodedFormEntity encodedFormEntity = null;
        if(params != null && !params.isEmpty()) {
            List<NameValuePair> nvpList = params.entrySet().stream()
                    .filter(entry -> entry.getKey() != null && entry.getValue() != null)
                    .map(entry -> new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()))
                    .collect(Collectors.toList());
            encodedFormEntity = new UrlEncodedFormEntity(nvpList, Consts.UTF_8);
        }
        return encodedFormEntity;
    }

    private StringEntity getEncodedJsonEntity(Map<?,?> params) {
        return new StringEntity(JSON.toJSONString(params), ContentType.APPLICATION_JSON);

    }


    private SimpleHttpResponse executeForBytes(HttpUriRequest request) throws SimpleHttpException {
        SimpleHttpResponse simpleHttpResponse;
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpclient = createHttpClient();
            httpResponse = httpclient.execute(request);

            StatusLine statusLine = httpResponse.getStatusLine();
            simpleHttpResponse = new SimpleHttpResponse(statusLine.getStatusCode());

            HttpEntity entity = httpResponse.getEntity();
            if(entity != null) {
                InputStream inputStream = entity.getContent();
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int count;
                try {
                    while((count = inputStream.read(data,0,1024)) != -1) {
                        outStream.write(data, 0, count);
                    }
                } catch (IOException e) {
                    log.error(e.getMessage());
                }finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        log.error(e.getMessage());
                    }
                }
                simpleHttpResponse.setResponseBody(outStream.toByteArray());
            }

            if(log.isDebugEnabled()) {
                log.debug("HTTP RESPONSE: " + JSON.toJSONString(simpleHttpResponse));
            }
            return simpleHttpResponse;

        } catch (IOException e) {
            throw new SimpleHttpException(e);

        }finally {
            closeResponse(httpResponse);
            closeClient(httpclient);
        }
    }


    private void closeResponse(CloseableHttpResponse httpResponse) {
        if(httpResponse != null) {
            try {
                httpResponse.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    private void closeClient(CloseableHttpClient httpClient) {
        if(httpClient != null) {
            try {
                httpClient.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

}
