package com.design.SchoolRollManagement.mapper;

import com.design.SchoolRollManagement.pojo.LeaveSchool;
import java.util.List;
import com.design.SchoolRollManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (LeaveSchool)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-13 14:19:54
 */
public interface LeaveSchoolMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LeaveSchool queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<LeaveSchool> getPageListByCondition(@Param("page") Page<LeaveSchool> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<LeaveSchool> page);


    /**
     * 新增数据
     *
     * @param leaveSchool 实例对象
     * @return 影响行数
     */
    int insert(LeaveSchool leaveSchool);




    /**
     * 修改数据
     *
     * @param leaveSchool 实例对象
     * @return 影响行数
     */
    int update(LeaveSchool leaveSchool);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

