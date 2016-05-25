package pers.zr.opensource.magic.conf.server.module.group.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zr.opensource.magic.conf.server.constants.ColumnConstants;
import pers.zr.opensource.magic.conf.server.module.group.dao.GroupDao;
import pers.zr.opensource.magic.conf.server.module.group.dao.po.GroupPo;
import pers.zr.opensource.magic.conf.server.module.group.service.IGroupMgrService;
import pers.zr.opensource.magic.dao.constants.OrderType;
import pers.zr.opensource.magic.dao.order.Order;

import java.util.List;

/**
 * Created by zhurong on 2016-5-25.
 */
@Service
public class GroupMgrServiceImpl implements IGroupMgrService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<GroupPo> getGroupList() {
        Order order = new Order(ColumnConstants.SORT_VALUE, OrderType.ASC);
        return groupDao.query(Lists.newArrayList(order));
    }
}
