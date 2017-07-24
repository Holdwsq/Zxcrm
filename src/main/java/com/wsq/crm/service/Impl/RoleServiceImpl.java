package com.wsq.crm.service.Impl;

import com.wsq.crm.dao.IRoleDao;
import com.wsq.crm.dao.mysql.RoleDaoImpl;
import com.wsq.crm.model.Role;
import com.wsq.crm.service.IRoleService;

import java.util.List;

/**
 * Created by admin on 2017/7/24.
 */
public class RoleServiceImpl implements IRoleService{
    IRoleDao roleDao = new RoleDaoImpl();
    @Override
    public int add(Role role) {
        return this.roleDao.add(role);
    }

    @Override
    public int removeRole(int roleId) {
        return this.roleDao.remove(roleId);
    }

    @Override
    public int updateRole(Role role) {
        return this.roleDao.update(role);
    }

    @Override
    public Role get(int roleId) {
        return this.roleDao.get(roleId);
    }

    @Override
    public List<Role> list() {
        return this.roleDao.list();
    }
}
