package com.design.SchoolRollManagement.service;

import com.design.SchoolRollManagement.pojo.Classe;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import com.design.SchoolRollManagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Classe)表服务接口
 *
 * @author makejava
 * @since 2022-08-08 22:20:39
 */
public interface ClasseService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Classe> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Classe> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param classe 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Classe classe);

    /**
     * 修改数据
     *
     * @param classe 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Classe classe);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Classe>> getByprofessionId(Integer professionId);

    RestFulBean<Map> getClassList(Page<Classe> page)throws Exception;
}
