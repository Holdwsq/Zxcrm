package com.wsq.crm.service.Impl;

import com.wsq.crm.dao.IDepartmentDao;
import com.wsq.crm.dao.mysql.DepartmentDaoImpl;
import com.wsq.crm.model.Department;
import com.wsq.crm.service.IDepartmentService;

import java.util.List;

/**
 * Created by admin on 2017/7/22.
 */
public class DepartmentServiceImpl implements IDepartmentService{
// 这里直接通过new的形式进行创建dao的实现，后期可以换为Spring来装配
    IDepartmentDao departmentDao = new DepartmentDaoImpl();
    /**
     * 向数据库中添加新的部门
     *
     * @param department
     * @return
     */
    @Override
    public int addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    /**
     * 查询所有的部门详情
     *
     * @return 部门列表
     */
    @Override
    public List<Department> listDepartment() {
        return departmentDao.listDepartment();
    }

    /**
     * 通过部门Id进行删除部门
     *
     * @param departmentId
     * @return 受影响的行数
     */
    @Override
    public int remove(int departmentId) {
        return this.departmentDao.removeDepartment(departmentId);
    }

    @Override
    public Department get(int id) {
        return this.departmentDao.getDepartmentById(id);
    }

    /**
     * 更新部门信息
     *
     * @param department
     * @return
     */
    @Override
    public int update(Department department) {
        return this.departmentDao.updateDepartment(department);
    }
}
