package pers.zr.opensource.magic.conf.server.module.profile;

import pers.zr.opensource.magic.conf.server.constants.ErrorCodeConstants;
import pers.zr.opensource.magic.conf.server.exception.BaseException;

/**
 * Created by zhurong on 2016-5-25.
 */
public class ProfileNotExistException extends BaseException {

    public ProfileNotExistException() {
        super("profile not exist");
    }

    @Override
    public int getCode() {
        return ErrorCodeConstants.PROFILE_NOT_EXIST_CODE;
    }
}
