package pers.zr.opensource.magic.conf.server.exception;

/**
 * Created by zhurong on 2016-5-25.
 */
public abstract class BaseException extends Exception {

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public abstract int getCode();
}
