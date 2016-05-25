package pers.zr.opensource.magic.conf.common.response;

/**
 * 包含对象的response
 */
public class CommonDataResponse<T> extends CommonResponse {

    private T data;

    public static <T> CommonDataResponse buildSuccessResponse(T data) {
        CommonDataResponse<T> response = new CommonDataResponse<T>();
        response.setCode(CommonResponseCode.SUCCESS);
        response.setMessage("ok");
        response.setData(data);
        return response;
    }

    public static CommonDataResponse buildErrorResponse(int code, String message) {
        CommonDataResponse response = new CommonDataResponse();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
