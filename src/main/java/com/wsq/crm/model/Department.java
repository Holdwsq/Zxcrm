package com.wsq.crm.model;

/**
 * Created by admin on 2017/7/21.
 */

import java.sql.Timestamp;

/**
 *部门实体类。属性的命名严格的采用驼峰方式的形式就行命名
 */
public class Department {
    private int departmentId;
    private String departmentName;
    private String departmentDesc;
    private boolean status;
    private String remark;
    private int creater;
    private Timestamp createTime;
    private int updater;
    private Timestamp updateTime;

    public Department() {}

    @Override
    public String toString() {
        return "Department{"+
                "departmentId:" + departmentId +
                ", departmentName:" + departmentName +
                ", departmentDesc:" + departmentDesc +
                ", status:" + status +
                ", remark:" + remark +
                ", creater:" + creater +
                ", createrTime:" + createTime +
                ", updater:" + updater +
                ", updateTime:" + updateTime +
                '}';
    }


    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getCreater() {
        return creater;
    }

    public void setCreater(int creater) {
        this.creater = creater;
    }


    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    /*    public  static void main(String[] args){
        Department de = new Department();
        System.out.println(de.toString());
    }*/
}
