package com.wsq.crm.service;

import com.wsq.crm.model.Department;

import java.util.List;

/**
 * Created by admin on 2017/7/22.
 */
public interface IDepartmentService {
    /**
     * 向数据库中添加新的部门
     * @param department
     * @return
     */
    int addDepartment(Department department);

    /**
     * 查询所有的部门详情
     * @return 部门列表
     */
    List<Department> listDepartment();

    /**
     * 通过部门Id进行删除部门
     * @param departmentId
     * @return 受影响的行数
     */
    int remove(int departmentId);

    /**
     * 更新部门信息
     * @param department
     * @return
     */
    int update(Department department);

    Department get(int id);
}
