package pers.zr.opensource.magic.conf.server.web.vo.req;

import org.hibernate.validator.constraints.NotEmpty;
import pers.zr.opensource.magic.conf.server.module.profile.dao.po.ProfilePo;
import pers.zr.opensource.magic.conf.server.web.vo.PoConverter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by zhurong on 2016-5-24.
 */
public class ProfileReqVo implements PoConverter<ProfilePo>, Serializable {

    @NotNull(message = "profileId can not be null")
    @NotEmpty(message = "profileId can not be empty")
    private String profileId;

    @NotNull(message = "profileName can not be null")
    @NotEmpty(message = "profileName cat not be empty")
    private String profileName;

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


    @Override
    public ProfilePo convert2Po() {
        ProfilePo profilePo = new ProfilePo();
        profilePo.setProfileId(this.profileId);
        profilePo.setProfileName(this.profileName);
        return profilePo;
    }
}
