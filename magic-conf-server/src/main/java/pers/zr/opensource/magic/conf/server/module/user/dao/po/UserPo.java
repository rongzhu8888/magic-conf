package pers.zr.opensource.magic.conf.server.module.user.dao.po;

import pers.zr.opensource.magic.dao.annotation.Column;
import pers.zr.opensource.magic.dao.annotation.Key;
import pers.zr.opensource.magic.dao.annotation.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhurong on 2016-4-28.
 */

@Table(name="mc_user")
public class UserPo implements Serializable {

    @Key(column = "user_id", autoIncrement = true)
    private Long userId;

    @Column(value = "user_name")
    private String userName;

    @Column(value = "telephone")
    private String telephone;

    @Column(value = "email")
    private String email;

    @Column(value = "password")
    private String password;

    @Column(value = "is_locked")
    private boolean locked;

    @Column(value = "is_admin")
    private boolean admin;

    @Column(value = "create_time")
    private Date createTime;

    @Column(value = "update_time")
    private Date updateTime;

    @Column(value = "token")
    private String token;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
