package pers.zr.magic.conf.server.model;

import java.util.Date;

/**
 * Created by zhurong on 2016-4-27.
 */
public class User {

    private String userId;

    private String userName;

    private String userPhone;

    private String userEmail;

    private String userEncryptedPasswd;

    private boolean isAdmin;

    private boolean isLocked;

    private String token;

    private Date createTime;

    private Date updateTIme;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEncryptedPasswd() {
        return userEncryptedPasswd;
    }

    public void setUserEncryptedPasswd(String userEncryptedPasswd) {
        this.userEncryptedPasswd = userEncryptedPasswd;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTIme() {
        return updateTIme;
    }

    public void setUpdateTIme(Date updateTIme) {
        this.updateTIme = updateTIme;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userEncryptedPasswd='" + userEncryptedPasswd + '\'' +
                ", isAdmin=" + isAdmin +
                ", isLocked=" + isLocked +
                ", token='" + token + '\'' +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}
