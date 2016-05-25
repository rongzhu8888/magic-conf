package pers.zr.opensource.magic.conf.common.response;

/**
 * 包含分页数据的response
 */
public class CommonPageResponse<T> extends CommonResponse {

    private Page<T> page;

    public static <T> CommonPageResponse<T> buildSuccessResponse(Page<T> page) {
        CommonPageResponse<T> response = new CommonPageResponse<T>();
        response.setCode(CommonResponseCode.SUCCESS);
        response.setMessage("ok");
        response.setPage(page);
        return response;
    }

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }
}
