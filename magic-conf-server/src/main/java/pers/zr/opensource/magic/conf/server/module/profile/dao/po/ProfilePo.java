package pers.zr.opensource.magic.conf.server.module.profile.dao.po;

import pers.zr.opensource.magic.dao.annotation.Column;
import pers.zr.opensource.magic.dao.annotation.Key;
import pers.zr.opensource.magic.dao.annotation.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhurong on 2016-5-15.
 */

@Table(name = "mc_profile")
public class ProfilePo implements Serializable {

    @Key(column = "profile_id")
    private String profileId;

    @Column(value = "profile_name")
    private String profileName;

    @Column(value = "create_time")
    private Date createTime;

    @Column(value = "update_time")
    private Date updateTime;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
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
