package com.wsq.crm.service;

import com.wsq.crm.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2017/7/20.
 */
public interface IUserService {
    /**
     * 通过用户名和密码获取用户数据
     * @param name
     * @param password
     * @return 用户对象
     */
    User getByLogin(String name,String password);

    /**
     * 退出登录
     * @param request
     */
    void logout(HttpServletRequest request);
}
