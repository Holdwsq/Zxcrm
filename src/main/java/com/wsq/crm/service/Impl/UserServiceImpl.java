package com.wsq.crm.service.Impl;

import com.wsq.crm.dao.IUserDao;
import com.wsq.crm.dao.mysql.UserDaoImpl;
import com.wsq.crm.model.User;
import com.wsq.crm.service.IUserService;
import com.wsq.crm.util.Pager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;

/**
 * Created by admin on 2017/7/20.
 */
public class UserServiceImpl implements IUserService{
    private IUserDao userDao = new UserDaoImpl();
    @Override
    public User getByLogin(String name, String password) {
        return userDao.getByLogin(name,password);
    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }

    @Override
    public int total(String keyword, String searchFiled) {
        return userDao.total(keyword,searchFiled);
    }

    @Override
    public List<User> list(Pager pager, String keyword, String searchFiled) {
        return userDao.list(pager,keyword,searchFiled);
    }
}
