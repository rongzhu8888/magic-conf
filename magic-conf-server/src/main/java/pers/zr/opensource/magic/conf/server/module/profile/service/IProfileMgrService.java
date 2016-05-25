package pers.zr.opensource.magic.conf.server.module.profile.service;

import pers.zr.opensource.magic.conf.server.module.profile.ProfileDuplicateException;
import pers.zr.opensource.magic.conf.server.module.profile.ProfileNotExistException;
import pers.zr.opensource.magic.conf.server.module.profile.dao.po.ProfilePo;

import java.util.List;

/**
 * Created by zhurong on 2016-4-27.
 */
public interface IProfileMgrService {

    public void createProfile(ProfilePo profile) throws ProfileDuplicateException;

    public void editProfile(ProfilePo profile) throws ProfileNotExistException;

    public void deleteProfile(String profileId) throws ProfileNotExistException;

    public List<ProfilePo> getProfileList();


}
