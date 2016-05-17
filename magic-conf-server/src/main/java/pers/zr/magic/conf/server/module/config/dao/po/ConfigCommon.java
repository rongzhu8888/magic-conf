package pers.zr.magic.conf.server.module.config.dao.po;

import pers.zr.magic.dao.annotation.Column;
import pers.zr.magic.dao.annotation.Key;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhurong on 2016-5-16.
 */
public class ConfigCommon implements Serializable {

    @Key(column = "config_id", autoIncrement = true)
    private Long configId;

    @Column(value = "app_id")
    private Long appId;

    @Column(value = "app_version")
    private String appVersion;

    @Column(value = "profile_id")
    private String profileId;

    @Column(value = "create_time")
    private Date createTime;

    @Column(value = "create_user")
    private String creator;

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
