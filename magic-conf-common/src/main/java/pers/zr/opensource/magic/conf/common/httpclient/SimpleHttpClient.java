package pers.zr.opensource.magic.conf.common.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/**
 * HTTP请求
 */
public class SimpleHttpClient extends SimpleHttpCore {
    private static SimpleHttpClient simpleHttpClient = new SimpleHttpClient();
    private SimpleHttpClient() {}

    public static SimpleHttpClient getInstance() {
        return simpleHttpClient;
    }

    @Override
    protected CloseableHttpClient createHttpClient() throws SimpleHttpException {
        return HttpClients.createDefault();
    }
}
