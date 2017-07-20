package com.wsq.crm.dao.mysql;

import com.wsq.crm.dao.IUserDao;
import com.wsq.crm.model.User;
import com.wsq.crm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 2017/7/20.
 */
/*
* 用户数据的Mysql访问对象
*
* */
public class UserDaoImpl implements IUserDao{
    @Override
    public User getByLogin(String username, String password) {
        User user = null;
        Connection conn = DBUtil.getConnection();
        String sql = "select * from user where username = ? and password =?";
        try {
            PreparedStatement pstt = conn.prepareStatement(sql);
            pstt.setString(1,username);
            pstt.setString(2,password);
            ResultSet rs = pstt.executeQuery();
            while (rs.next()){
                user.setUserId(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
