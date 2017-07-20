package com.wsq.crm.model;

import java.io.Serializable;

/**
 * Created by admin on 2017/7/20.
 */
public class User implements Serializable{
    /*
    * 实现Serializable 接口目的是为了让 User 对象
    * 保存在Session中 或 其他的位置时更加的稳定
    * */
    private static final long serialVersionUID = 1L;
    private long userId;
    private String username;
    private String password;

    /*toString方法一般将对象转化为Json数据格式，
    * 以方便以后的操作
    * */
    @Override
    public String toString() {
        return "User{" +
                "userId:" + userId +
                ", username:" + username +
                ", password:" + password +
                "}";
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
