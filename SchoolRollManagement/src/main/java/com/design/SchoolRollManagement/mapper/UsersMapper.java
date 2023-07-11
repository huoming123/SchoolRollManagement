package com.design.SchoolRollManagement.mapper;

import com.design.SchoolRollManagement.pojo.Users;
import java.util.List;
import com.design.SchoolRollManagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-08 08:46:00
 */
public interface UsersMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Users queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Users> getPageListByCondition(@Param("page") Page<Users> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Users> page);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);




    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Users getByCardId(String trim);

    Users getByUserNoAndRole(String userNo, String role);

    List<Users> getTeachList();

    List<Users> getAnalyseList(Users users);

    List<Users> getUserByYear();
}

