package com.wsq.crm.dao.mysql;

import com.wsq.crm.dao.IDepartmentDao;
import com.wsq.crm.model.Department;
import com.wsq.crm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return 0;
    }

    @Override
    public int updateDepartment(Department department) {
        return 0;
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return null;
    }

    @Override
    public List<Department> listDepartment() {
        String sql = "select * from department where status=2";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstt = conn.prepareStatement(sql)){

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
