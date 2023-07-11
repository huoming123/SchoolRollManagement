package com.design.SchoolRollManagement.service;

import com.design.SchoolRollManagement.pojo.EnrollmentChange;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import com.design.SchoolRollManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (EnrollmentChange)表服务接口
 *
 * @author makejava
 * @since 2023-04-08 08:35:32
 */
public interface EnrollmentChangeService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<EnrollmentChange> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<EnrollmentChange> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param enrollmentChange 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(EnrollmentChange enrollmentChange);

    /**
     * 修改数据
     *
     * @param enrollmentChange 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(EnrollmentChange enrollmentChange);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
