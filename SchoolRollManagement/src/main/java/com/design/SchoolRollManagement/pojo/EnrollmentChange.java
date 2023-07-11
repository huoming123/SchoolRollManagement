package com.design.SchoolRollManagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (EnrollmentChange)实体类
 *
 * @author makejava
 * @since 2023-04-12 16:51:36
 */
public class EnrollmentChange implements Serializable {
    private static final long serialVersionUID = -82717547221673718L;
     
    private Integer id;
     /**
     * 学生id
     */
    private Integer userId;
     /**
     * 申请人
     */
    private String createdBy;
     /**
     * 申请时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
     /**
     * 异动类型
     */
    private String type;
     /**
     * 教师审核  1为审核通过 0 待审核 -1 审核不通过
     */
    private Integer checked;
     /**
     * 管理员审核  1为审核通过 0 待审核 -1 审核不通过
     */
    private Integer status;
     /**
     * 理由
     */
    private String reason;
     /**
     * 专业
     */
    private Integer professionId;
     /**
     * 班级 
     */
    private Integer classeId;

    private Integer year;
    private String professionName;
    private String  className;
    private String  classTeacher;

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

}

