package com.design.SchoolRollManagement.service;

import com.design.SchoolRollManagement.pojo.Profession;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import com.design.SchoolRollManagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Profession)表服务接口
 *
 * @author makejava
 * @since 2023-03-27 10:53:25
 */
public interface ProfessionService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Profession> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Profession> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param profession 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Profession profession);

    /**
     * 修改数据
     *
     * @param profession 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Profession profession);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Profession>> getProfessionList();
}
