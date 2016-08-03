package pers.zr.opensource.magic.conf.server.module.profile.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.zr.opensource.magic.conf.server.constants.ColumnConstants;
import pers.zr.opensource.magic.conf.server.module.profile.ProfileDuplicateException;
import pers.zr.opensource.magic.conf.server.module.profile.ProfileNotExistException;
import pers.zr.opensource.magic.conf.server.module.profile.dao.ProfileDao;
import pers.zr.opensource.magic.conf.server.module.profile.dao.po.ProfilePo;
import pers.zr.opensource.magic.conf.server.module.profile.service.IProfileMgrService;
import pers.zr.opensource.magic.dao.annotation.QueryDataSource;
import pers.zr.opensource.magic.dao.constants.DataSourceType;
import pers.zr.opensource.magic.dao.constants.OrderType;
import pers.zr.opensource.magic.dao.order.Order;

import java.util.List;

/**
 * Created by zhurong on 2016-5-24.
 */
@QueryDataSource(alias = "slave01", type = DataSourceType.MASTER)
@Component
public class ProfileMgrServiceImpl implements IProfileMgrService {

    @Autowired
    private ProfileDao profileDao;

    @Override
    public void createProfile(ProfilePo profile) throws ProfileDuplicateException {

        String profileId = profile.getProfileId();
        if(null != (profileDao.get(profileId))) {
            throw new ProfileDuplicateException();
        }
        profileDao.insert(profile);
    }

    @Override
    public void editProfile(ProfilePo profile) throws ProfileNotExistException {

        if(null == (profileDao.get(profile.getProfileId()))){
            throw new ProfileNotExistException();
        }
        profileDao.update(profile);
    }

    @Override
    public void deleteProfile(String profileId) throws ProfileNotExistException {

        if(null == (profileDao.get(profileId))){
            throw new ProfileNotExistException();
        }
        profileDao.delete(profileId);
    }

    @Override
//    @QueryDataSource(alias = "slave02", type = DataSourceType.MASTER)
    public ProfilePo getProfile(String profileId) {
        return profileDao.get(profileId);
    }

//    @QueryDataSource(alias = "slave02", type = DataSourceType.MASTER)
    @Override
    public List<ProfilePo> getProfileList() {

        Order order = new Order(ColumnConstants.UPDATE_TIME, OrderType.DESC);
        return profileDao.query(Lists.newArrayList(order));
    }
}
