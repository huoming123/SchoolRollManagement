package com.design.SchoolRollManagement.pojo;

import java.io.Serializable;

/**
 * (Graduate)实体类
 *
 * @author makejava
 * @since 2023-04-12 13:52:21
 */
public class Graduate implements Serializable {
    private static final long serialVersionUID = -29607826485201033L;
     /**
     * 主键 自增id
     */
    private Integer id;
     /**
     * 学生ID
     */
    private Integer userId;
     /**
     * 中级专业证书
     */
    private String intermediate;
     /**
     * 高级专业证书
     */
    private String advanced;
     /**
     * 四级英语证书
     */
    private String levelFour;
     /**
     * 六级英语证书
     */
    private String levelSix;
     /**
     * 是否结业 1为是 0 为否
     */
    private Integer status;
     /**
     * 班级
     */
    private Integer classeId;
     /**
     * 专业
     */
    private Integer professionId;
     /**
     * 实习证明
     */
    private String certificate;
    private Integer creditTotal;
    private Double  gradePointTotal;
    private Integer failTotal;
    private String advancedUrl;
    private String levelFourUrl;
    private String levelSixUrl;
    private String intermediateUrl;
    private String certificateUrl;
    private String  year;
    private String  userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(Integer creditTotal) {
        this.creditTotal = creditTotal;
    }

    public Double getGradePointTotal() {
        return gradePointTotal;
    }

    public void setGradePointTotal(Double gradePointTotal) {
        this.gradePointTotal = gradePointTotal;
    }

    public Integer getFailTotal() {
        return failTotal;
    }

    public void setFailTotal(Integer failTotal) {
        this.failTotal = failTotal;
    }

    public String getAdvancedUrl() {
        return advancedUrl;
    }

    public void setAdvancedUrl(String advancedUrl) {
        this.advancedUrl = advancedUrl;
    }

    public String getLevelFourUrl() {
        return levelFourUrl;
    }

    public void setLevelFourUrl(String levelFourUrl) {
        this.levelFourUrl = levelFourUrl;
    }

    public String getLevelSixUrl() {
        return levelSixUrl;
    }

    public void setLevelSixUrl(String levelSixUrl) {
        this.levelSixUrl = levelSixUrl;
    }

    public String getIntermediateUrl() {
        return intermediateUrl;
    }

    public void setIntermediateUrl(String intermediateUrl) {
        this.intermediateUrl = intermediateUrl;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
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

    public String getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(String intermediate) {
        this.intermediate = intermediate;
    }

    public String getAdvanced() {
        return advanced;
    }

    public void setAdvanced(String advanced) {
        this.advanced = advanced;
    }

    public String getLevelFour() {
        return levelFour;
    }

    public void setLevelFour(String levelFour) {
        this.levelFour = levelFour;
    }

    public String getLevelSix() {
        return levelSix;
    }

    public void setLevelSix(String levelSix) {
        this.levelSix = levelSix;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

}

