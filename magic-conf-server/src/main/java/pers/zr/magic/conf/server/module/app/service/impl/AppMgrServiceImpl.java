package pers.zr.magic.conf.server.module.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zr.magic.conf.server.module.app.dao.AppDao;
import pers.zr.magic.conf.server.module.app.dao.po.AppPo;
import pers.zr.magic.conf.server.module.app.service.IAppMgrService;
import pers.zr.magic.dao.matcher.Matcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhurong on 2016-4-27.
 */
@Service
public class AppMgrServiceImpl implements IAppMgrService {

    @Autowired
    private AppDao appDao;

    @Override
    public List<AppPo> getAppList() {
        return appDao.query(new ArrayList<Matcher>(0));
    }

    @Override
    public void createApp(AppPo appPo) {
        Long appId = appDao.insertForId(appPo);
        System.out.println(appId);
    }
}
