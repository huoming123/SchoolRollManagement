package com.design.SchoolRollManagement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Profession)实体类
 *
 * @author makejava
 * @since 2023-03-27 10:53:26
 */
public class Profession implements Serializable {
    private static final long serialVersionUID = -77735779017145484L;
     
    private Integer id;
     /**
     * 专业名称
     */
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd  HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     
    private String createdBy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}

