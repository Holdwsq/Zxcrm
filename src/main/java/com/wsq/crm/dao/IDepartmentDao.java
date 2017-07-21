package com.wsq.crm.dao;

import com.wsq.crm.model.Department;

import java.util.List;

/**
 * Created by admin on 2017/7/21.
 */
public interface IDepartmentDao {
    /**
     * @Description 用来添加部门
     * @param department
     * @return 数据库影响行数
     */
    int addDepartment(Department department);

    /**
     * 通过部门的Id进行单个删除
     * @param departmentId
     * @return 受影响的行数
     */
    int removeDepartment(int departmentId);

    /**
     * 通过update方法对传进来的department进行对应的更新操作
     * @param department
     * @return
     */
    int updateDepartment(Department department);

    /**
     * 通过department查询具体部门的详情
     * @param departmentId
     * @return
     */
    Department getDepartmentById(int departmentId);

    /**
     * 查询部门列表
     * @return 部门的列表
     */
    List<Department> listDepartment();
}
