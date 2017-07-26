package com.wsq.crm.dao;

import com.wsq.crm.model.User;
import com.wsq.crm.util.Pager;

import java.util.List;

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

    /**
     * 添加用户
     * @param user 用户对象
     * @return 数据库影响行数
     */
    int add(User user);

    /**
     * 删除用户
     * @param userId 删除用户的id值
     * @return 数据库受影响的行数
     */
    int remove(int userId);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 查找用户
     * @param userId 通过用户的id进行查询
     * @return User对象
     */
    User get(int userId);

    /**
     * 通过添加条件获取用户的分页数据
     * @param pager 分页对象
     * @param keyword 搜索关键字
     * @param searchField 搜索字段
     * @return
     */
    List<User> list(Pager pager, String keyword, String searchField);

    /**
     * 获取数据条数
     * @param keyword  搜索的关键字
     * @param searchField  搜索字段
     * @return
     */
    int total(String keyword, String searchField);
}















