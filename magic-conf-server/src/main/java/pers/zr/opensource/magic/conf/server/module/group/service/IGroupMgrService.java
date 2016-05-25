package pers.zr.opensource.magic.conf.server.module.group.service;

import pers.zr.opensource.magic.conf.server.module.group.dao.po.GroupPo;

import java.util.List;

/**
 * Created by zhurong on 2016-4-27.
 */
public interface IGroupMgrService {

//    void createGroup(String groupName);
//
//    void deleteGroup(Long groupId);

    List<GroupPo> getGroupList();






}
