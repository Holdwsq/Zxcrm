package com.wsq.crm.dao;


import com.wsq.crm.model.Role;

import java.util.List;

/**
 * Created by admin on 2017/7/24.
 */
public interface IRoleDao {
    /**
     * 添加角色
     * @param role
     * @return 数据库影响的行数
     */
    int add(Role role);

    /**
     * 通过角色Id删除角色信息
     * @param roleId
     * @return 数据库受影响的行数
     */
    int remove(int roleId);

    /**
     * 更新角色信息
     * @param role
     * @return 数据库受影响的行数
     */
    int update(Role role);

    /**
     * 通过角色的Id值获取部门信息
     * @param roleId
     * @return
     */
    Role get(int roleId);

    /**
     * 获取角色列表
     * @return 角色列表 list<Role>
     */
    List<Role> list();
}
