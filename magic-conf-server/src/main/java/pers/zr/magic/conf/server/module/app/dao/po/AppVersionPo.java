package pers.zr.magic.conf.server.module.app.dao.po;

import pers.zr.magic.dao.annotation.Column;
import pers.zr.magic.dao.annotation.Key;
import pers.zr.magic.dao.annotation.Table;

import java.io.Serializable;

/**
 * Created by zhurong on 2016-5-15.
 */
@Table(name = "mc_app_version")
public class AppVersionPo implements Serializable {

    @Key(column = "id", autoIncrement = true)
    private Long id;

    @Column(value = "app_id")
    private Long appId;

    @Column(value = "version_no")
    private String versionNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }
}
