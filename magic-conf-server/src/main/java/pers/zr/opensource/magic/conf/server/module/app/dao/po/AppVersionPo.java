package pers.zr.opensource.magic.conf.server.module.app.dao.po;

import pers.zr.opensource.magic.dao.annotation.Column;
import pers.zr.opensource.magic.dao.annotation.Key;
import pers.zr.opensource.magic.dao.annotation.Table;

import java.io.Serializable;

/**
 * Created by zhurong on 2016-5-15.
 */
@Table(name = "mc_app_version")
public class AppVersionPo implements Serializable {

    @Key(column = "id", autoIncrement = true)
    private Long id;

    @Column(value = "app_id")
    private String appId;

    @Column(value = "app_version")
    private String appVersion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
