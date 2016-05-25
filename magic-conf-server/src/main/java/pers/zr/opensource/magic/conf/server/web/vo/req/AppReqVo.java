package pers.zr.opensource.magic.conf.server.web.vo.req;

import org.hibernate.validator.constraints.NotEmpty;
import pers.zr.opensource.magic.conf.server.module.app.dao.po.AppPo;
import pers.zr.opensource.magic.conf.server.web.vo.PoConverter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by zhurong on 2016-5-25.
 */
public class AppReqVo implements PoConverter<AppPo>, Serializable {

    @NotNull(message = "appId can not be null")
    @NotEmpty(message = "appId can not be empty")
    private String appId;

    @NotNull(message = "appName can not be null")
    @NotEmpty(message = "appName can not be empty")
    private String appName;

    @NotNull(message = "groupId can not be null")
    @Min(value = 0, message = "groupId can not less than 0")
    private Long groupId;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Long getGroupId() {
        return groupId;
    }


    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public AppPo convert2Po() {
        AppPo appPo = new AppPo();
        appPo.setAppId(this.appId);
        appPo.setAppName(this.appName);
        appPo.setGroupId(this.groupId);
        return appPo;
    }
}
