package pers.zr.opensource.magic.conf.server.module.menu.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import pers.zr.opensource.magic.conf.server.constants.ApplicationConstants;
import pers.zr.opensource.magic.conf.server.module.app.dao.po.AppPo;
import pers.zr.opensource.magic.conf.server.module.app.service.IAppMgrService;
import pers.zr.opensource.magic.conf.server.module.group.dao.po.GroupPo;
import pers.zr.opensource.magic.conf.server.module.group.service.IGroupMgrService;
import pers.zr.opensource.magic.conf.server.module.menu.service.IMenuService;
import pers.zr.opensource.magic.conf.server.module.menu.service.MenuItem;
import pers.zr.opensource.magic.conf.server.constants.MenuItemType;

import java.util.List;

/**
 * Created by zhurong on 2016-5-25.
 */

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IAppMgrService appMgrService;

    @Autowired
    private IGroupMgrService groupMgrService;

    @Override
    public List<MenuItem> getMenus() {

        //TODO 首先从redis缓存里查

        //获取group列表
        List<GroupPo> groupList = groupMgrService.getGroupList();
        return getChildrenForGroup(ApplicationConstants.ROOT_GROUP_ID, groupList);
    }


    public List<MenuItem> getChildrenForGroup(Long groupId, List<GroupPo> groupList) {
        List<MenuItem> menuItemList = Lists.newArrayList();

        //GROUP
        if(!CollectionUtils.isEmpty(groupList)) {
            groupList.stream().filter(group -> group.getParentGroupId() == groupId).forEach(group -> {
                MenuItem menuItem = new MenuItem();
                menuItem.setId(String.valueOf(group.getGroupId()));
                menuItem.setLabel(group.getGroupName());
                menuItem.setType(MenuItemType.GROUP);
                menuItem.setChildren(getChildrenForGroup(group.getGroupId(), groupList));
                menuItemList.add(menuItem);
            });
        }

        //APP
        List<AppPo> appList = appMgrService.getAppListByGroup(groupId);
        if(!CollectionUtils.isEmpty(appList)) {
            for(AppPo app : appList) {
                MenuItem menuItem = new MenuItem();
                menuItem.setId(app.getAppId());
                menuItem.setLabel(app.getAppName());
                menuItem.setType(MenuItemType.APP);
                menuItemList.add(menuItem);
            }

        }

        return menuItemList;

    }
}
