package com.wsq.crm.dao.mysql;

import com.wsq.crm.dao.IRoleDao;
import com.wsq.crm.model.Role;
import com.wsq.crm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/7/24.
 */
public class RoleDaoImpl implements IRoleDao{

    @Override
    public int add(Role role) {
        String sql = "insert into role(role_name,role_desc,creater,create_time) values (?,?,?,?)";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstt = conn.prepareStatement(sql)){
            pstt.setString(1,role.getRoleName());
            pstt.setString(2,role.getRoleDesc());
            pstt.setInt(3,role.getCreater());
            pstt.setTimestamp(4,role.getCreateTime());

            return pstt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {}
        return 0;
    }

    @Override
    public int remove(int roleId) {
        String sql = "update role set status = -2 where role_id = ?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstt = conn.prepareStatement(sql)){
            pstt.setInt(1,roleId);

            return pstt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Role role) {
        String sql = "update role set role_name = ?" +
                ",role_desc = ? " +
                ",updater = ? " +
                ",update_time = ? " +
                "where role_id = ?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstt = conn.prepareStatement(sql)){
            pstt.setString(1,role.getRoleName());
            pstt.setString(2,role.getRoleDesc());
            pstt.setInt(3,role.getUpdater());
            pstt.setTimestamp(4,role.getUpdateTime());

            return pstt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Role get(int roleId) {
        String sql = "select * form role where role_id = ?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstt = conn.prepareStatement(sql)){
            pstt.setInt(1,roleId);

            ResultSet rs = pstt.executeQuery();
            if (rs.next()){
                return this.read(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Role> list() {
        List<Role> list = new ArrayList<>();
        String sql = "select * from role where status = 2";
        try (Connection conn = DBUtil.getConnection();
            PreparedStatement pstt = conn.prepareStatement(sql)){
            ResultSet rs = pstt.executeQuery();
            while (rs.next()){
                Role r = read(rs);
                list.add(r);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 自动提取的方法
    private Role read(ResultSet rs) throws SQLException {
        Role r = new Role();
        r.setRoleId(rs.getInt("role_id"));
        r.setRoleName(rs.getString("role_name"));
        r.setRoleDesc(rs.getString("role_desc"));
        r.setStatus(rs.getByte("status"));
        r.setRemark(rs.getString("remark"));
        r.setCreater(rs.getInt("creater"));
        r.setCreateTime(rs.getTimestamp("create_time"));
        r.setUpdater(rs.getInt("updater"));
        r.setUpdateTime(rs.getTimestamp("update_time"));
        return r;
    }
}
