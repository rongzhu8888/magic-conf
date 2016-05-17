package pers.zr.magic.conf.server.module.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.zr.magic.conf.server.module.user.dao.UserDao;
import pers.zr.magic.conf.server.module.user.dao.po.UserPo;
import pers.zr.magic.dao.MagicDataSource;
import pers.zr.magic.dao.MagicGenericDao;

/**
 * Created by zhurong on 2016-5-15.
 */
@Component
public class UserDaoImpl extends MagicGenericDao<Long, UserPo> implements UserDao {

    @Autowired
    private MagicDataSource magicDataSource;
}
