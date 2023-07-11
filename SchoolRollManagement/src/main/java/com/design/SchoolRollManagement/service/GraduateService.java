package com.design.SchoolRollManagement.service;

import com.design.SchoolRollManagement.pojo.Graduate;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import com.design.SchoolRollManagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
/**
 * (Graduate)表服务接口
 *
 * @author makejava
 * @since 2023-04-12 09:54:53
 */
public interface GraduateService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Graduate> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Graduate> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param graduate 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Graduate graduate);

    /**
     * 修改数据
     *
     * @param graduate 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Graduate graduate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);




    RestFulBean<Graduate> getByUserId(Graduate graduate);

    RestFulBean<String> certificateUpload(Integer userId, Integer professionId, Integer classeId, Integer index, MultipartFile coverFile) throws Exception;

    RestFulBean<String> graduateService(Integer userId, MultipartFile coverFile);
}
