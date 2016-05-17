package pers.zr.magic.conf.server.module.app.service;

import pers.zr.magic.conf.server.module.app.dao.po.AppPo;

import java.util.List;

/**
 * Created by zhurong on 2016-4-27.
 */
public interface IAppMgrService {

    public List<AppPo> getAppList();

    public void createApp(AppPo appPo);



}
