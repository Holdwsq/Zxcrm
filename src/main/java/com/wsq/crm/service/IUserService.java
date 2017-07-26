package com.wsq.crm.service;

import com.wsq.crm.model.User;
import com.wsq.crm.util.Pager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    List<User> list(Pager pager, String keyword, String searchFiled);

    int total(String keyword, String searchFiled);
}
