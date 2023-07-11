package com.design.SchoolRollManagement.controller;

import com.design.SchoolRollManagement.pojo.EnrollmentChange;
import com.design.SchoolRollManagement.service.EnrollmentChangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.SchoolRollManagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (EnrollmentChange)表控制层
 *
 * @author makejava
 * @since 2023-04-08 08:35:30
 */
@RestController
@RequestMapping("/enrollmentChange")
public class EnrollmentChangeController {
    /**
     * 服务对象
     */
    @Autowired
    private EnrollmentChangeService enrollmentChangeService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<EnrollmentChange>page) throws Exception{
        return this.enrollmentChangeService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<EnrollmentChange> queryById(@RequestBody EnrollmentChange enrollmentChange) {
        return this.enrollmentChangeService.queryById(enrollmentChange.getId());
    }

    /**
     * 新增数据
     *
     * @param enrollmentChange 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody EnrollmentChange enrollmentChange) {
        return this.enrollmentChangeService.insert(enrollmentChange);
    }

    /**
     * 编辑数据
     *
     * @param enrollmentChange 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody EnrollmentChange enrollmentChange) {
        return this.enrollmentChangeService.update(enrollmentChange);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody EnrollmentChange enrollmentChange) {
        return this.enrollmentChangeService.deleteById(enrollmentChange.getId());
    }

}

