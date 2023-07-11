package com.design.SchoolRollManagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Score)实体类
 *
 * @author makejava
 * @since 2023-04-08 13:45:43
 */
public class Score implements Serializable {
    private static final long serialVersionUID = -90143363700080065L;
     
    private Integer id;
     /**
     * 用户id 记录是哪个学生的成绩
     */
    private Integer userId;
     /**
     * 分数
     */
    private Double score;
     /**
     * 年份
     */
    private Integer year;
     /**
     * 记录一个成绩是上学期还是下学期
     */
    private String term;
     /**
     * 课程
     */
    private String courseName;
     /**
     * 录入时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd  HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 录入人
     */
    private String createdBy;
     /**
     * 选修为1 必修为0
     */
    private Integer elective;
     /**
     * 学分
     */
    private Integer credit;
     /**
     * 绩点
     */
    private Double gradePoint;
     /**
     * 挂科  1为挂科 0 为否
     */
    private Integer fail;
     /**
     * 重修   1为是  0 为否
     */
    private Integer rerepair;
     /**
     * 是否通过  1为重修通过 0 为不需要重新 -1 为重修不通过
     */
    private Integer pass;
    private Integer noPass;
    private String  userName;
    private Double  rerepairScore;

    public Integer getNoPass() {
        return noPass;
    }

    public void setNoPass(Integer noPass) {
        this.noPass = noPass;
    }

    public Double getRerepairScore() {
        return rerepairScore;
    }

    public void setRerepairScore(Double rerepairScore) {
        this.rerepairScore = rerepairScore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getElective() {
        return elective;
    }

    public void setElective(Integer elective) {
        this.elective = elective;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(Double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }

    public Integer getRerepair() {
        return rerepair;
    }

    public void setRerepair(Integer rerepair) {
        this.rerepair = rerepair;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

}

