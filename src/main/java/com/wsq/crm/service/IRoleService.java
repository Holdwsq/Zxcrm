package com.wsq.crm.service;

import com.wsq.crm.model.Role;

import java.util.List;

/**
 * Created by admin on 2017/7/24.
 */
public interface IRoleService{
    /**
     * 添加role in service
     * @param role
     * @return 影响的行数
     */
    int add(Role role);

    /**
     * 删除role in service
     * @param roleId
     * @return 数据库受影响的行数
     */
    int removeRole(int roleId);

    /**
     * 更新role
     * @param role
     * @return 数据库受影响的行数
     */
    int updateRole(Role role);

    /**
     * 通过roleId 获取 对应的Role对象
     * @param roleId
     * @return Role对象
     */
    Role get(int roleId);

    /**
     * 获取Role 列表
     * @return Role列表
     */
    List<Role> list();
}
