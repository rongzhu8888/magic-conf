package pers.zr.opensource.magic.conf.server.web.vo.req;

import org.hibernate.validator.constraints.NotEmpty;
import pers.zr.opensource.magic.conf.server.module.app.dao.po.AppVersionPo;
import pers.zr.opensource.magic.conf.server.web.vo.PoConverter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by zhurong on 2016-5-25.
 */
public class AppVersionReqVo implements PoConverter<AppVersionPo>,Serializable {

    @NotNull(message = "appId can not be null")
    @NotEmpty(message = "appId can not be empty")
    private String appId;

    @NotNull(message = "appVersion can not be null")
    @NotEmpty(message = "appVersion can not be empty")
    private String appVersion;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public AppVersionPo convert2Po() {
        AppVersionPo po = new AppVersionPo();
        po.setAppId(this.appId);
        po.setAppVersion(this.appVersion);
        return po;
    }
}
