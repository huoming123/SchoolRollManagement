package com.design.SchoolRollManagement.controller;

import com.design.SchoolRollManagement.pojo.Profession;
import com.design.SchoolRollManagement.service.ProfessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.SchoolRollManagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Profession)表控制层
 *
 * @author makejava
 * @since 2023-03-27 10:53:23
 */
@RestController
@RequestMapping("/profession")
public class ProfessionController {
    /**
     * 服务对象
     */
    @Autowired
    private ProfessionService professionService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Profession>page) throws Exception{
        return this.professionService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Profession> queryById(@RequestBody Profession profession) {
        return this.professionService.queryById(profession.getId());
    }

    /**
     * 新增数据
     *
     * @param profession 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Profession profession) {
        return this.professionService.insert(profession);
    }

    /**
     * 编辑数据
     *
     * @param profession 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Profession profession) {
        return this.professionService.update(profession);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Profession profession) {
        return this.professionService.deleteById(profession.getId());
    }


    /**
     * 获取专业下拉
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/profession/list")
    public RestFulBean<List<Profession>> getProfessionList() {
        return this.professionService.getProfessionList();
    }
}

