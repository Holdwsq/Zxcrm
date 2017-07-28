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

    /**
     * 返回用户列表
     * @param pager
     * @param keyword
     * @param searchFiled
     * @return
     */
    List<User> list(Pager pager, String keyword, String searchFiled);

    /**
     * 返回符合条件的用户总数
     * @param keyword
     * @param searchFiled
     * @return 用户数量
     */
    int total(String keyword, String searchFiled);

    /**
     * 删除用户 根据参数的用户Id
     * @param userId
     * @return
     */
    int remove(int userId);

    /**
     * 通过用户的id 查找对应的用户
     * @param userId
     * @return
     */
    User get(int userId);

    /**
     * 增加用户
     * @param user
     * @return
     */
    int add(User user);
}
