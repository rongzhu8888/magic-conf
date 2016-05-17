package pers.zr.magic.conf.server.module.group.service;

import pers.zr.magic.conf.server.model.Group;

import java.util.List;

/**
 * Created by zhurong on 2016-4-27.
 */
public interface IGroupMgrService {

    void createGroup(String groupName);

    void deleteGroup(Long groupId);

    List<Group> getGroupsByParent(Long parentGroupId);






}
