package pers.zr.opensource.magic.conf.server.utils;

import org.springframework.util.CollectionUtils;
import pers.zr.opensource.magic.conf.common.response.CommonResponse;
import pers.zr.opensource.magic.conf.common.response.CommonResponseCode;

import javax.validation.*;
import java.util.Set;

/**
 * JSR 303校验解析
 * Created by zhurong on 2016-5-25.
 */
public class ParamValidator {

    public static <T> CommonResponse validate(T paramObj) {
        CommonResponse response = null;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(paramObj);
        if(!CollectionUtils.isEmpty(violations)) {
            ConstraintViolation<T> firstViolation = null;
            int i = 0;
            for(ConstraintViolation<T> violation : violations) {
                if(i == 0) {
                    firstViolation = violation;
                    break;
                }
            }
            response = CommonResponse.buildErrorResponse(CommonResponseCode.PARAMS_ERROR, firstViolation.getMessage());
        }
        return response;
    }
}
