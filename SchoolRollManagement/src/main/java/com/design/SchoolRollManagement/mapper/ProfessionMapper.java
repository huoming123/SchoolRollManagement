package com.design.SchoolRollManagement.mapper;

import com.design.SchoolRollManagement.pojo.Profession;
import java.util.List;
import com.design.SchoolRollManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Profession)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-27 10:53:27
 */
public interface ProfessionMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Profession queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Profession> getPageListByCondition(@Param("page") Page<Profession> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Profession> page);


    /**
     * 新增数据
     *
     * @param profession 实例对象
     * @return 影响行数
     */
    int insert(Profession profession);




    /**
     * 修改数据
     *
     * @param profession 实例对象
     * @return 影响行数
     */
    int update(Profession profession);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Profession> getProfessionList();
}

