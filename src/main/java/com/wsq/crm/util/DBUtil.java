package com.wsq.crm.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by admin on 2017/7/20.
 */
public class DBUtil {
    /*
    * 获取JNDI上下文
    * @return JNDI
    * */
    static Context getContext(){

        try {
            return new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
    * 获取数据库连接
    *
    * */
    public static Connection getConnection(){
        Connection conn = null;
        Context cxt = getContext();

        try {
            DataSource ds = (DataSource) cxt.lookup("java:comp/env/jdbc/zycrm");
            try {
                conn = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
