package pers.zr.opensource.magic.conf.server.module;

import pers.zr.opensource.magic.conf.server.constants.ErrorCodeConstants;
import pers.zr.opensource.magic.conf.server.exception.BaseException;

/**
 * Created by zhurong on 2016-5-25.
 */
public class AppVersionDuplicateException extends BaseException {

    public AppVersionDuplicateException() {
        super("app version has existed");
    }

    @Override
    public int getCode() {
        return ErrorCodeConstants.APP_VERSION_DUPLICATE_CODE;
    }
}
