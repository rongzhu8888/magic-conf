package pers.zr.magic.conf.server.model;

import java.util.Date;

/**
 * Created by zhurong on 2016-4-27.
 */
public class Group {

    private Long groupId;

    private String groupName;

    private Long parentGroupId;

    private Date createTime;

    private Date updateTime;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(Long parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "GroupPo{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", parentGroupId=" + parentGroupId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
