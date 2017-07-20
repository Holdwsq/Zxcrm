package com.wsq.crm.service.Impl;

import com.wsq.crm.dao.IUserDao;
import com.wsq.crm.dao.mysql.UserDaoImpl;
import com.wsq.crm.model.User;
import com.wsq.crm.service.IUserService;

/**
 * Created by admin on 2017/7/20.
 */
public class UserServiceImpl implements IUserService{
    private IUserDao userDao = new UserDaoImpl();
    @Override
    public User getByLogin(String name, String password) {
        return userDao.getByLogin(name,password);
    }
}
