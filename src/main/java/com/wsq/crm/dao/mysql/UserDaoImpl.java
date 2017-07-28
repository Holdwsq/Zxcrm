package com.wsq.crm.dao.mysql;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import com.wsq.crm.dao.IUserDao;
import com.wsq.crm.model.User;
import com.wsq.crm.util.DBUtil;
import com.wsq.crm.util.Pager;
import org.apache.catalina.realm.UserDatabaseRealm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        String sql = "select * from user where user_name = ? and password =?";
        try ( Connection conn = DBUtil.getConnection();
              PreparedStatement pstt = conn.prepareStatement(sql);
            ){
            pstt.setString(1,username);
            pstt.setString(2,password);
            ResultSet rs = pstt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_name"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return 数据库影响行数
     */
    @Override
    public int add(User user) {
        String sql = "INSERT INTO `user` (`create_time`, `user_name`, `password`, `admin`, `system`,"
                + " `department_id`, `role_id`, `sex`, `mobile`, `address`, "
                + "`birthdate`, `tel`, `id_num`, `email`, `qq`, "
                + "`hobby`, `education`, `card_num`, `nation`, `marry`, " + "`remark`, `creater` "
                + ") VALUES (?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stat = conn.prepareStatement(sql)) {
            stat.setTimestamp(1, user.getCreateTime());
            stat.setString(2, user.getUsername());
            stat.setString(3, user.getPassword());
            stat.setBoolean(4, user.isAdmin());
            stat.setBoolean(5, user.isSystem());

            stat.setInt(6, user.getDepartmentId());
            stat.setInt(7, user.getRoleId());
            stat.setBoolean(8, user.isSex());
            stat.setString(9, user.getMobile());
            stat.setString(10, user.getAddress());

            stat.setTimestamp(11, user.getBirthdate());
            stat.setString(12, user.getTel());
            stat.setString(13, user.getIdNum());
            stat.setString(14, user.getEmail());
            stat.setString(15, user.getQq());

            stat.setString(16, user.getHobby());
            stat.setByte(17, user.getEducation());
            stat.setString(18, user.getCardNum());
            stat.setString(19, user.getNation());
            stat.setByte(20, user.getMarry());

            stat.setString(21, user.getRemark());
            stat.setInt(22, user.getCreater());

            return stat.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 删除用户
     *
     * @param userId 删除用户的id值
     * @return 数据库受影响的行数
     */
    @Override
    public int remove(int userId) {
        String sql = "update user set status = -2 where user_id = ?";
        try (Connection conn = DBUtil.getConnection();
            PreparedStatement pstt = conn.prepareStatement(sql)){
            pstt.setInt(1,userId);

            return pstt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return 0;
    }

    /**
     * 查找用户
     *
     * @param userId 通过用户的id进行查询
     * @return User对象
     */
    @Override
    public User get(int userId) {
        return null;
    }

    /**
     * 通过添加条件获取用户的分页数据
     *
     * @param pager       分页对象
     * @param keyword     搜索关键字
     * @param searchField 搜索字段
     * @return
     */
    @Override
    public List<User> list(Pager pager, String keyword, String searchField) {
        List<User> list = new ArrayList<>();
        String sql = "select * from user where status = 2";

//       对关键字和字段判空
        if (keyword != null && !"".equals(keyword.trim())
                && searchField != null && !"".equals(searchField.trim())){
            sql += " and " + searchField + " like '%" + keyword +"%' ";
        }
        sql += " limit ?,?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstt = conn.prepareStatement(sql)){
            pstt.setInt(1,(pager.getPageNo()-1)*pager.getPageSize());
            pstt.setInt(2,pager.getPageSize());
            ResultSet rs = pstt.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("admin"));
                user.setSystem(rs.getBoolean("system"));
                user.setDepartmentId(rs.getInt("department_id"));
                user.setRoleId(rs.getInt("role_id"));
                user.setSex(rs.getBoolean("sex"));
                user.setMobile(rs.getString("mobile"));
                user.setAddress(rs.getString("address"));
                user.setBirthdate(rs.getTimestamp("birthdate"));
                user.setTel(rs.getString("tel"));
                user.setIdNum(rs.getString("id_num"));
                user.setEmail(rs.getString("email"));
                user.setQq(rs.getString("qq"));
                user.setHobby(rs.getString("hobby"));
                user.setEducation(rs.getByte("education"));
                user.setCardNum(rs.getString("card_num"));
                user.setNation(rs.getString("nation"));
                user.setMarry(rs.getByte("marry"));
                user.setStatus(rs.getByte("status"));
                user.setRemark(rs.getString("remark"));
                user.setCreater(rs.getInt("creater"));
                user.setCreateTime(rs.getTimestamp("create_time"));
                user.setUpdater(rs.getInt("updater"));
                user.setUpdateTime(rs.getTimestamp("update_time"));
                list.add(user);
            }
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取数据条数
     *
     * @param keyword     搜索的关键字
     * @param searchField 搜索字段
     * @return
     */
    @Override
    public int total(String keyword, String searchField) {
        String sql = "select count(*) from user where status = 2";
//        这种写法有风险！ 会造成SQL注入
        if (keyword != null && !"".equals(keyword.trim())&&
                searchField != null && !"".equals(keyword.trim())){
            sql += "and " + searchField +"like '%" + keyword + "%' ";
        }
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstt = conn.prepareStatement(sql)){
            ResultSet rs = pstt.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
