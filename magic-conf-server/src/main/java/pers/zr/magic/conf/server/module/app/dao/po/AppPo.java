package pers.zr.magic.conf.server.module.app.dao.po;

import pers.zr.magic.dao.annotation.Column;
import pers.zr.magic.dao.annotation.Key;
import pers.zr.magic.dao.annotation.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhurong on 2016-5-15.
 */

@Table(name = "mc_app")
public class AppPo implements Serializable {

    @Key(column = "app_id", autoIncrement = true)
    private Long appId;

    @Column(value = "app_code")
    private String appCode;

    @Column(value = "app_name")
    private String appName;

    @Column(value = "group_id")
    private Long groupId;

    @Column(value = "create_time")
    private Date createTime;

    @Column(value = "update_time")
    private Date updateTime;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
