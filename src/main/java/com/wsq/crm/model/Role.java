package com.wsq.crm.model;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by admin on 2017/7/24.
 */
public class Role {
    private int roleId;
    private String roleName;
    private String roleDesc;
    private byte status;
    private String remark;
    private int creater;
    private Timestamp createTime;
    private int updater;
    private Timestamp updateTime;

    public Role(){}

    @Override
    public String toString() {
        return "Role{" +
                "roleId:" + roleId +
                ", roleName:'" + roleName + '\'' +
                ", roleDesc:'" + roleDesc + '\'' +
                ", status:" + status +
                ", remark:'" + remark + '\'' +
                ", creater:" + creater +
                ", createTime:" + createTime +
                ", updater:" + updater +
                ", updateTime:" + updateTime +
                '}';
    }
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCreater() {
        return creater;
    }

    public void setCreater(int creater) {
        this.creater = creater;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
 /*   public static void main(String[] args){
        Role role = new Role();
        System.out.println(role.toString());
    }*/
}
