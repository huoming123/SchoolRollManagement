package com.design.SchoolRollManagement.controller;

import com.design.SchoolRollManagement.pojo.Classe;
import com.design.SchoolRollManagement.service.ClasseService;
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
 * (Classe)表控制层
 *
 * @author makejava
 * @since 2022-08-08 22:20:39
 */
@RestController
@RequestMapping("/classe")
public class ClasseController {
    /**
     * 服务对象
     */
    @Autowired
    private ClasseService classeService;
    
     /**
     * 分页查询
     *
     * @param //班主任列表
     * @return
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Classe>page) throws Exception{
        return this.classeService.getList(page);
    }
    /**
     * 分页查询
     *
     * @param //班级列表
     * @return
     */
    @PostMapping("/get/class/list")
    public RestFulBean<Map> getClassList(@RequestBody Page<Classe>page) throws Exception{
        return this.classeService.getClassList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Classe> queryById(@RequestBody Classe classe) {
        return this.classeService.queryById(classe.getId());
    }

    /**
     * 新增数据
     *
     * @param classe 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Classe classe) {
        return this.classeService.insert(classe);
    }

    /**
     * 编辑数据
     *
     * @param classe 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Classe classe) {
        return this.classeService.update(classe);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Classe classe) {
        return this.classeService.deleteById(classe.getId());
    }
    /**
     * 根据专业id获取班级
     *
     * @param
     * @return
     */
    @PostMapping("/get/by/professionId")
    public RestFulBean<List<Classe>> getByprofessionId(@RequestBody Classe classe) {
        return this.classeService.getByprofessionId(classe.getProfessionId());
    }
}

