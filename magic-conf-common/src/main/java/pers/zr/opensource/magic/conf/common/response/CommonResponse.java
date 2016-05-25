package pers.zr.opensource.magic.conf.common.response;

import java.io.Serializable;

/**
 * 通用response
 * 用于跨服务|跨应用|跨端调用时响应信息
 */
public class CommonResponse implements Serializable {
    private static final long serialVersionUID = -2564445585181441109L;

    private int code;
    private String message;

    public static CommonResponse buildSuccessResponse() {
        CommonResponse response = new CommonResponse();
        response.setCode(CommonResponseCode.SUCCESS);
        response.setMessage("ok");
        return response;
    }

    public static CommonResponse buildErrorResponse(int code, String message) {
        CommonResponse response = new CommonResponse();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
