package pers.zr.opensource.magic.conf.common.httpclient;

public class SimpleHttpException extends Exception {

    public SimpleHttpException(String msg) {
        super(msg);
    }


    public SimpleHttpException(Throwable cause) {
        super(cause);
    }

}
