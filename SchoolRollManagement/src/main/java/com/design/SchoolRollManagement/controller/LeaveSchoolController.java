package com.design.SchoolRollManagement.controller;

import com.design.SchoolRollManagement.pojo.LeaveSchool;
import com.design.SchoolRollManagement.service.LeaveSchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.SchoolRollManagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
/**
 * (LeaveSchool)表控制层
 *
 * @author makejava
 * @since 2023-04-13 14:19:54
 */
@RestController
@RequestMapping("/leaveSchool")
public class LeaveSchoolController {
    /**
     * 服务对象
     */
    @Autowired
    private LeaveSchoolService leaveSchoolService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<LeaveSchool>page) throws Exception{
        return this.leaveSchoolService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<LeaveSchool> queryById(@RequestBody LeaveSchool leaveSchool) {
        return this.leaveSchoolService.queryById(leaveSchool.getId());
    }

    /**
     * 新增数据
     *
     * @param leaveSchool 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody LeaveSchool leaveSchool) {
        return this.leaveSchoolService.insert(leaveSchool);
    }

    /**
     * 编辑数据
     *
     * @param leaveSchool 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody LeaveSchool leaveSchool) {
        return this.leaveSchoolService.update(leaveSchool);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody LeaveSchool leaveSchool) {
        return this.leaveSchoolService.deleteById(leaveSchool.getId());
    }
    //上传照片
    @PostMapping("/upload/image")
    public RestFulBean<String> upload(@RequestParam(value = "id",required = false) Integer id,@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return leaveSchoolService.upload(id,coverFile);
    }
}

