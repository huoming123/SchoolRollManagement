package com.design.SchoolRollManagement.mapper;

import com.design.SchoolRollManagement.pojo.Classe;
import java.util.List;
import com.design.SchoolRollManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Classe)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-08 22:20:39
 */
public interface ClasseMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Classe queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Classe> getPageListByCondition(@Param("page") Page<Classe> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Classe> page);


    /**
     * 新增数据
     *
     * @param classe 实例对象
     * @return 影响行数
     */
    int insert(Classe classe);




    /**
     * 修改数据
     *
     * @param classe 实例对象
     * @return 影响行数
     */
    int update(Classe classe);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Classe> getByprofessionId(Integer professionId);

    List<Classe> getPageClassListByCondition(@Param("page") Page<Classe> page);

    Integer getPageClassListCount(@Param("page") Page<Classe> page);
}

