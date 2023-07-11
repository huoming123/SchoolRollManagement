package com.design.SchoolRollManagement.service;

import com.design.SchoolRollManagement.pojo.Users;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import com.design.SchoolRollManagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2023-04-08 08:45:59
 */
public interface UsersService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Users> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Users> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map<String, Object>> login(Users users);

    RestFulBean<Map> upload(MultipartFile coverFile)throws Exception;

    RestFulBean<List<Users>> getTeachList();


    RestFulBean<String> updateRecord(Users users);

    RestFulBean<Map> getAnalyseList(Users users);

    RestFulBean<Map> getTotalByYear();
}
