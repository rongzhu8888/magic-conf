package pers.zr.opensource.magic.conf.server.module.app;

import pers.zr.opensource.magic.conf.server.constants.ErrorCodeConstants;
import pers.zr.opensource.magic.conf.server.exception.BaseException;

/**
 * Created by zhurong on 2016-5-25.
 */
public class AppDuplicateException extends BaseException {

    public AppDuplicateException() {
        super("app has existed");
    }

    @Override
    public int getCode() {
        return ErrorCodeConstants.APP_DUPLICATE_CODE;
    }
}
