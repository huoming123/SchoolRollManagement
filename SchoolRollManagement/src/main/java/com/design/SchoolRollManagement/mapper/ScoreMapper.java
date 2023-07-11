package com.design.SchoolRollManagement.mapper;

import com.design.SchoolRollManagement.pojo.Score;
import java.util.List;
import com.design.SchoolRollManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Score)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-08 13:45:43
 */
public interface ScoreMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Score queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Score> getPageListByCondition(@Param("page") Page<Score> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Score> page);


    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    int insert(Score score);




    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 影响行数
     */
    int update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Score getByUserID(Score score);

    List<Score> getGradeList(Score score);

    List<Score> getScoreList(Integer userId);

    List<Score> getScoreList1(Integer userId);
}

