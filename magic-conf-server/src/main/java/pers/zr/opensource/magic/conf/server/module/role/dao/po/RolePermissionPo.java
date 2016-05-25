package pers.zr.opensource.magic.conf.server.module.role.dao.po;

import pers.zr.opensource.magic.dao.annotation.Column;
import pers.zr.opensource.magic.dao.annotation.Key;
import pers.zr.opensource.magic.dao.annotation.Table;

import java.io.Serializable;

/**
 * Created by zhurong on 2016-5-15.
 */

@Table(name = "mc_role_permission")
public class RolePermissionPo implements Serializable {

    @Key(column = "id", autoIncrement = true)
    private Long id;

    @Column(value = "role_id")
    private String roleId;

    @Column(value = "profile_id")
    private String profileId;

    @Column(value = "read_flag")
    private Boolean enableRead;

    @Column(value = "write_flag")
    private Boolean enableWrite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Boolean getEnableRead() {
        return enableRead;
    }

    public void setEnableRead(Boolean enableRead) {
        this.enableRead = enableRead;
    }

    public Boolean getEnableWrite() {
        return enableWrite;
    }

    public void setEnableWrite(Boolean enableWrite) {
        this.enableWrite = enableWrite;
    }
}
