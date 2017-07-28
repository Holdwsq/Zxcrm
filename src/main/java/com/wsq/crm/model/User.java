package com.wsq.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by admin on 2017/7/20.
 */
public class User implements Serializable{
    /*
    * 实现Serializable 接口目的是为了让 User 对象
    * 保存在Session中 或 其他的位置时更加的稳定
    * */
    private static final long serialVersionUID = 1L;
    private int userId;
    private String username;
    private String password;
    private boolean admin;
    private boolean system;
    private int departmentId;
    private int roleId;
    private boolean sex; //true代表男的 false 代表女的
    private String mobile;
    private String address;
    private Timestamp birthdate;
    private String tel;
    private String idNum;
    private String email;
    private String qq;
    private String hobby;
    private byte education;
    private String cardNum;
    private String nation;
    private byte marry;
    private byte status;
    private String remark;
    private int creater;
    private Timestamp createTime;
    private int updater;
    private Timestamp updateTime;
    /*toString方法一般将对象转化为Json数据格式，
    * 以方便以后的操作
    * */

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", system=" + system +
                ", departmentId=" + departmentId +
                ", roleId=" + roleId +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", birthdate=" + birthdate +
                ", tel='" + tel + '\'' +
                ", idNum='" + idNum + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", hobby='" + hobby + '\'' +
                ", education=" + education +
                ", cardNum='" + cardNum + '\'' +
                ", nation='" + nation + '\'' +
                ", marry=" + marry +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", creater=" + creater +
                ", createTime=" + createTime +
                ", updater=" + updater +
                ", updateTime=" + updateTime +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public byte getEducation() {
        return education;
    }

    public void setEducation(byte education) {
        this.education = education;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public byte getMarry() {
        return marry;
    }

    public void setMarry(byte marry) {
        this.marry = marry;
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

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
