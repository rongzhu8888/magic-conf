package pers.zr.opensource.magic.conf.server.web.vo.res;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhurong on 2016-5-24.
 */
public class ProfileResVo implements Serializable {

    private String profileId;
    private String profileName;
    private Date createTime;
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
