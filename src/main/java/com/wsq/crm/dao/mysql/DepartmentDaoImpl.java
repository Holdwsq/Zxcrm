package com.wsq.crm.dao.mysql;

import com.wsq.crm.dao.IDepartmentDao;
import com.wsq.crm.model.Department;
import com.wsq.crm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/7/21.
 */
public class DepartmentDaoImpl implements IDepartmentDao{
    public static final String culomns = "department_id,department_name,department_desc" +
            ",status,remark,creater,create_time,updater,update_time";
    @Override
    public int addDepartment(Department department) {
        String sql = "insert into department "
                + "(department_name,department_desc,creater,create_time) "
                + "values (?,?,?,?)";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement s = conn.prepareStatement(sql)){

            s.setString(1, department.getDepartmentName());
            s.setString(2, department.getDepartmentDesc());
            s.setInt(3, department.getCreater());
            s.setTimestamp(4, department.getCreateTime());

            return s.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int removeDepartment(int departmentId) {
        String sql = "delete from department where department_id = ?";

        try ( Connection conn = DBUtil.getConnection();
              PreparedStatement pstt = conn.prepareStatement(sql)){
            pstt.setInt(1,departmentId);
            return pstt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateDepartment(Department department) {
        String sql = "update department set department_name = ?" +
                ",department_desc = ?" +
                ",updater = ?" +
                ",update_time =?" +
                " where department_id = ?";

        try (  Connection conn = DBUtil.getConnection();
               PreparedStatement pstt = conn.prepareStatement(sql)){
            pstt.setString(1,department.getDepartmentName());
            pstt.setString(2,department.getDepartmentDesc());
            pstt.setInt(3,department.getUpdater());
            pstt.setTimestamp(4,department.getUpdateTime());
            pstt.setInt(5,department.getDepartmentId());
            return pstt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        String sql = "select * from department where department_id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstt = conn.prepareStatement(sql);){
            pstt.setInt(1,departmentId);
            ResultSet rs = pstt.executeQuery();
            if (rs.next()){
                return read(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Department> listDepartment() {
        String sql = "select * from department where status=2";
        List<Department> dList = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstt = conn.prepareStatement(sql)){
            ResultSet rs = pstt.executeQuery();
            while (rs.next()){
                Department de = new Department();
                de.setDepartmentId(rs.getInt("department_id"));
                de.setDepartmentName(rs.getString("department_name"));
                de.setDepartmentDesc(rs.getString("department_desc"));
                de.setStatus(rs.getByte("status"));
                de.setRemark(rs.getString("remark"));
                de.setCreater(rs.getInt("creater"));
                de.setCreateTime(rs.getTimestamp("create_time"));
                de.setUpdater(rs.getInt("updater"));
                de.setUpdateTime(rs.getTimestamp("update_time"));
                dList.add(de);//将对象添加到保存的列表中
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dList;
    }
    private Department read(ResultSet set) throws SQLException {
        Department d = new Department();

        d.setDepartmentId(set.getInt("department_id"));
        d.setDepartmentName(set.getString("department_name"));
        d.setDepartmentDesc(set.getString("department_desc"));
        d.setStatus(set.getByte("status"));
        d.setRemark(set.getString("remark"));
        d.setCreater(set.getInt("creater"));
        d.setCreateTime(set.getTimestamp("create_time"));
        d.setUpdater(set.getInt("updater"));
        d.setUpdateTime(set.getTimestamp("update_time"));
        return d;
    }
}
