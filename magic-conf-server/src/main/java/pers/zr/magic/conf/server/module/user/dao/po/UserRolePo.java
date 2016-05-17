package pers.zr.magic.conf.server.module.user.dao.po;

import pers.zr.magic.dao.annotation.Column;
import pers.zr.magic.dao.annotation.Key;
import pers.zr.magic.dao.annotation.Table;

import java.io.Serializable;

/**
 * Created by zhurong on 2016-5-16.
 */
@Table(name = "mc_user_role")
public class UserRolePo implements Serializable {
    @Key(column = "id", autoIncrement = true)
    private Long id;

    @Column(value = "user_id")
    private Long userId;

    @Column(value = "app_id")
    private Long appId;

    @Column(value = "role_id")
    private String roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
