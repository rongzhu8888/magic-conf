package pers.zr.magic.conf.common.httpclient;

import org.apache.http.Consts;

public class SimpleHttpResponse {

    private int statusCode;
    private byte[] responseBody;

    public SimpleHttpResponse(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public byte[] getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(byte[] responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseBodyAsString() {
        return new String(responseBody, Consts.UTF_8);
    }
}
