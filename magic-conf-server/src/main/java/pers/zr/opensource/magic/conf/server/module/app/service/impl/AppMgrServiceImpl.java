package pers.zr.opensource.magic.conf.server.module.app.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import pers.zr.opensource.magic.conf.server.constants.ColumnConstants;
import pers.zr.opensource.magic.conf.server.module.AppVersionDuplicateException;
import pers.zr.opensource.magic.conf.server.module.app.AppDuplicateException;
import pers.zr.opensource.magic.conf.server.module.app.AppNotExistException;
import pers.zr.opensource.magic.conf.server.module.app.dao.AppDao;
import pers.zr.opensource.magic.conf.server.module.app.dao.AppVersionDao;
import pers.zr.opensource.magic.conf.server.module.app.dao.po.AppPo;
import pers.zr.opensource.magic.conf.server.module.app.dao.po.AppVersionPo;
import pers.zr.opensource.magic.conf.server.module.app.service.IAppMgrService;
import pers.zr.opensource.magic.dao.constants.OrderType;
import pers.zr.opensource.magic.dao.matcher.EqualsMatcher;
import pers.zr.opensource.magic.dao.matcher.Matcher;
import pers.zr.opensource.magic.dao.order.Order;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhurong on 2016-4-27.
 */
@Service
public class AppMgrServiceImpl implements IAppMgrService {

    @Autowired
    private AppDao appDao;

    @Autowired
    private AppVersionDao appVersionDao;


    @Override
    public List<AppPo> getAppList() {

        Order order = new Order(ColumnConstants.UPDATE_TIME, OrderType.DESC);
        return appDao.query(Lists.newArrayList(order));

    }

    @Override
    public void createApp(AppPo appPo) throws AppDuplicateException {

        String appId = appPo.getAppId();
        if(null != (appDao.get(appId))) {
            throw new AppDuplicateException();
        }
        appDao.insert(appPo);

    }

    @Override
    public void editApp(AppPo appPo) throws AppNotExistException {

        String appId = appPo.getAppId();
        if(null == (appDao.get(appId))) {
            throw new AppNotExistException();
        }
        appDao.update(appPo);
    }

    @Override
    public void deleteApp(String appId) throws AppNotExistException {
        if(null == (appDao.get(appId))) {
            throw new AppNotExistException();
        }
        appDao.delete(appId);
    }

    @Override
    public List<String> getAppVersions(String appId) throws AppNotExistException {
        if(null == (appDao.get(appId))) {
            throw new AppNotExistException();
        }

        List<String> versionNoList = Lists.newArrayList();
        List<AppVersionPo> appVersionPoList = appVersionDao.query();
        if(!CollectionUtils.isEmpty(appVersionPoList)) {
            versionNoList.addAll(appVersionPoList.stream().map(AppVersionPo::getAppVersion).collect(Collectors.toList()));
        }
        return versionNoList;
    }

    @Override
    public void createAppVersion(AppVersionPo appVersionPo) throws AppVersionDuplicateException {

        Matcher appIdMatcher = new EqualsMatcher(ColumnConstants.APP_ID, appVersionPo.getAppId());
        Matcher versionMatcher = new EqualsMatcher(ColumnConstants.APP_VERSION, appVersionPo.getAppVersion());

        if(!CollectionUtils.isEmpty(appVersionDao.query(appIdMatcher, versionMatcher))) {
            throw new AppVersionDuplicateException();
        }

        appVersionDao.insert(appVersionPo);

    }

    @Override
    public List<AppPo> getAppListByGroup(Long groupId) {

        Matcher groupMatcher = new EqualsMatcher(ColumnConstants.GROUP_ID, groupId);
        return appDao.query(groupMatcher);

    }
}
