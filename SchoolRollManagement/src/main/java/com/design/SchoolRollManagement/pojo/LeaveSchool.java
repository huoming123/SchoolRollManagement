package com.design.SchoolRollManagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (LeaveSchool)实体类
 *
 * @author makejava
 * @since 2023-04-13 14:19:54
 */
public class LeaveSchool implements Serializable {
    private static final long serialVersionUID = 430573102553735489L;
     
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
     * 专业
     */
    private Integer professionId;
     /**
     * 班级 
     */
    private Integer classeId;
     /**
     * 教师审核  1为审核通过 0 待审核 -1 审核不通过
     */
    private Integer checked;
     /**
     * 管理员审核  1为审核通过 0 待审核 -1 审核不通过
     */
    private Integer status;
     /**
     * 毕业证领取状态
     */
    private String diploma;
     /**
     * 毕业证照片
     */
    private String diplomaImages;
    private String diplomaImagesUrl;
     /**
     * 报到证领取状态
     */
    private String registrationCard;
     /**
     * 报到证照片
     */
    private String registrationCardImages;
    private String registrationCardImagesUrl;
     /**
     * 年级
     */
    private Integer year;
     /**
     * 班主任
     */
    private String classTeacher;
     /**
     * 离校证明
     */
    private String leavingCertificate;
    private String leavingCertificateUrl;
    private String professionName;
    private String  className;

    public String getLeavingCertificateUrl() {
        return leavingCertificateUrl;
    }

    public void setLeavingCertificateUrl(String leavingCertificateUrl) {
        this.leavingCertificateUrl = leavingCertificateUrl;
    }

    public String getDiplomaImagesUrl() {
        return diplomaImagesUrl;
    }

    public void setDiplomaImagesUrl(String diplomaImagesUrl) {
        this.diplomaImagesUrl = diplomaImagesUrl;
    }

    public String getRegistrationCardImagesUrl() {
        return registrationCardImagesUrl;
    }

    public void setRegistrationCardImagesUrl(String registrationCardImagesUrl) {
        this.registrationCardImagesUrl = registrationCardImagesUrl;
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

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getDiplomaImages() {
        return diplomaImages;
    }

    public void setDiplomaImages(String diplomaImages) {
        this.diplomaImages = diplomaImages;
    }

    public String getRegistrationCard() {
        return registrationCard;
    }

    public void setRegistrationCard(String registrationCard) {
        this.registrationCard = registrationCard;
    }

    public String getRegistrationCardImages() {
        return registrationCardImages;
    }

    public void setRegistrationCardImages(String registrationCardImages) {
        this.registrationCardImages = registrationCardImages;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getLeavingCertificate() {
        return leavingCertificate;
    }

    public void setLeavingCertificate(String leavingCertificate) {
        this.leavingCertificate = leavingCertificate;
    }

}

