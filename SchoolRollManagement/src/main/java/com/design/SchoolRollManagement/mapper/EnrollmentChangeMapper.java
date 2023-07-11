package com.design.SchoolRollManagement.mapper;

import com.design.SchoolRollManagement.pojo.EnrollmentChange;
import java.util.List;
import com.design.SchoolRollManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (EnrollmentChange)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-08 08:35:33
 */
public interface EnrollmentChangeMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EnrollmentChange queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<EnrollmentChange> getPageListByCondition(@Param("page") Page<EnrollmentChange> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<EnrollmentChange> page);


    /**
     * 新增数据
     *
     * @param enrollmentChange 实例对象
     * @return 影响行数
     */
    int insert(EnrollmentChange enrollmentChange);




    /**
     * 修改数据
     *
     * @param enrollmentChange 实例对象
     * @return 影响行数
     */
    int update(EnrollmentChange enrollmentChange);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

