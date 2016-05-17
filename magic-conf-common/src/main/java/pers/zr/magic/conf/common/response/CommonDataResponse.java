package pers.zr.magic.conf.common.response;

/**
 * 包含对象的response
 */
public class CommonDataResponse<T> extends CommonResponse {

    private T data;

    public CommonDataResponse buildSuccessResponse(T data) {
        CommonDataResponse<T> response = new CommonDataResponse<T>();
        response.setCode(CommonResponseCode.SUCCESS);
        response.setMessage("ok");
        response.setData(data);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
