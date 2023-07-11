package com.design.SchoolRollManagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2023-04-08 09:23:14
 */
public class Users implements Serializable {
    private static final long serialVersionUID = -72244701399609938L;
     
    private Integer id;
     /**
     * 密码
     */
    private String password;
     /**
     * 手机号存个字符串11位
     */
    private String telephone;
     /**
     * 注册时间
     */

    private Date createdAt;
     /**
     * 修改时间
     */
    private Date updatedAt;
     /**
     * 用户名
     */
    private String userName;
     /**
     * 身份证
     */
    private String cardId;
     /**
     * 年龄
     */
    private Integer age;
     /**
     * 性别
     */
    private String sex;
     /**
     * 住址
     */
    private String address;
     /**
     * 照片 
     */
    private String image;
    private String imageUrl;
     /**
     * 民族
     */
    private String nation;
     /**
     * 出生年月 时间戳
     */

    private Date birthday;
     /**
     * 籍贯
     */
    private String nativePlace;
     /**
     * 婚姻状况
     */
    private String maritalStatus;
     /**
     * 政治面貌
     */
    private String political;
     /**
     * 录入人
     */
    private String createdBy;
     /**
     * 修改人
     */
    private String updatedBy;
     /**
     * 8位数字作为学号 教师编号
     */
    private String userNo;
     /**
     * 角色
     */
    private String role;
     /**
     * 入学时间 (教师为入职时间)
     */
    private Date startAt;
     /**
     * 毕业时间 (教师为辞职时间)
     */
    private Date leaveAt;
     /**
     * 部门 (教师用)
     */
    private String depart;
     /**
     * 职称(教师用)
     */
    private String rank;
     /**
     * 专业id
     */
    private Integer professionId;
     /**
     * 是否结业  1 为结业 0为否
     */
    private Integer isGraduate;
     /**
     * 班级id 
     */
    private Integer classeId;
     /**
     * 班主任审核
     */
    private Integer checked;
    /**
     * 专业名字
     */
    private String professionName;
    /**
     * 班级名称
     */
    private String className;
    /**
     *  年份 额外字段 接收前端参数
     */
    private Integer year;
    /**
     *  是否离职 额外字段 接收前端参数
     */
    private Integer isLeave;
    private  String  classTeacher;
    private  String schoolRecord;
    private Integer  count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSchoolRecord() {
        return schoolRecord;
    }

    public void setSchoolRecord(String schoolRecord) {
        this.schoolRecord = schoolRecord;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(Integer isLeave) {
        this.isLeave = isLeave;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getLeaveAt() {
        return leaveAt;
    }

    public void setLeaveAt(Date leaveAt) {
        this.leaveAt = leaveAt;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public Integer getIsGraduate() {
        return isGraduate;
    }

    public void setIsGraduate(Integer isGraduate) {
        this.isGraduate = isGraduate;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

}

