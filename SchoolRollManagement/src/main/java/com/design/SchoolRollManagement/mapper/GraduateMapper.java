package com.design.SchoolRollManagement.mapper;

import com.design.SchoolRollManagement.pojo.Graduate;
import java.util.List;
import com.design.SchoolRollManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Graduate)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-12 09:54:54
 */
public interface GraduateMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Graduate queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Graduate> getPageListByCondition(@Param("page") Page<Graduate> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Graduate> page);


    /**
     * 新增数据
     *
     * @param graduate 实例对象
     * @return 影响行数
     */
    int insert(Graduate graduate);




    /**
     * 修改数据
     *
     * @param graduate 实例对象
     * @return 影响行数
     */
    int update(Graduate graduate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Graduate getByUserId(Integer userId);

    void updateByUserId(Graduate graduate);


}

