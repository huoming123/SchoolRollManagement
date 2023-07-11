package com.design.SchoolRollManagement.service;

import com.design.SchoolRollManagement.pojo.LeaveSchool;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import com.design.SchoolRollManagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
/**
 * (LeaveSchool)表服务接口
 *
 * @author makejava
 * @since 2023-04-13 14:19:54
 */
public interface LeaveSchoolService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<LeaveSchool> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<LeaveSchool> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param leaveSchool 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(LeaveSchool leaveSchool);

    /**
     * 修改数据
     *
     * @param leaveSchool 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(LeaveSchool leaveSchool);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<String> upload(Integer id, MultipartFile coverFile);
}
