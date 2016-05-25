package pers.zr.opensource.magic.conf.server.module.app.service;

import pers.zr.opensource.magic.conf.server.module.AppVersionDuplicateException;
import pers.zr.opensource.magic.conf.server.module.app.AppDuplicateException;
import pers.zr.opensource.magic.conf.server.module.app.AppNotExistException;
import pers.zr.opensource.magic.conf.server.module.app.dao.po.AppPo;
import pers.zr.opensource.magic.conf.server.module.app.dao.po.AppVersionPo;

import java.util.List;

/**
 * Created by zhurong on 2016-4-27.
 */
public interface IAppMgrService {

    public List<AppPo> getAppList();

    public void createApp(AppPo appPo) throws AppDuplicateException;

    public void editApp(AppPo appPo) throws AppNotExistException;

    public void deleteApp(String appId) throws AppNotExistException;

    public List<String> getAppVersions(String appId) throws AppNotExistException;

    public void createAppVersion(AppVersionPo appVersionPo) throws AppVersionDuplicateException;

    public List<AppPo> getAppListByGroup(Long groupId);





}
