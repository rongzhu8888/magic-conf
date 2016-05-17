package pers.zr.magic.conf.server.module.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.zr.magic.conf.server.module.app.dao.AppDao;
import pers.zr.magic.conf.server.module.app.dao.po.AppPo;
import pers.zr.magic.dao.MagicDataSource;
import pers.zr.magic.dao.MagicGenericDao;

/**
 * Created by zhurong on 2016-5-15.
 */
//@Component
public class AppDaoImpl extends MagicGenericDao<Long, AppPo> implements AppDao {
/*
    @Autowired
    private MagicDataSource magicDataSource;*/
}
