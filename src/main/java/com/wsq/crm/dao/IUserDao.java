package com.wsq.crm.dao;

import com.wsq.crm.model.User;

/**
 * Created by admin on 2017/7/20.
 */
public interface IUserDao {
    /**
     * 通过用户名和密码获取用户数据
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User getByLogin(String username,String password);
}















