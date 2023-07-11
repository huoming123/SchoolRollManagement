package com.design.SchoolRollManagement.controller;

import com.design.SchoolRollManagement.pojo.Graduate;
import com.design.SchoolRollManagement.service.GraduateService;
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
 * (Graduate)表控制层
 *
 * @author makejava
 * @since 2023-04-12 09:54:53
 */
@RestController
@RequestMapping("/graduate")
public class GraduateController {
    /**
     * 服务对象
     */
    @Autowired
    private GraduateService graduateService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Graduate>page) throws Exception{
        return this.graduateService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Graduate> queryById(@RequestBody Graduate graduate) {
        return this.graduateService.queryById(graduate.getId());
    }

    /**
     * 新增数据
     *
     * @param graduate 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Graduate graduate) {
        return this.graduateService.insert(graduate);
    }

    /**
     * 编辑数据
     *
     * @param graduate 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Graduate graduate) {
        return this.graduateService.update(graduate);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Graduate graduate) {
        return this.graduateService.deleteById(graduate.getId());
    }
    //上传证书照片
    @PostMapping("/certificateUpload")
    public RestFulBean<String> certificateUpload(@RequestParam(value = "userId",required = false) Integer userId,@RequestParam(value = "classeId",required = false) Integer classeId,@RequestParam(value = "professionId",required = false) Integer professionId,@RequestParam(value = "index",required = false) Integer index,@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return graduateService.certificateUpload(userId,professionId,classeId,index,coverFile);
    }

    /**
     * 根据用户ID获取证书
     *
     * @param graduate 实体
     * @return 新增结果
     */
    @PostMapping("/get/by/userId")
    public RestFulBean<Graduate> getByUserId(@RequestBody Graduate graduate) {
        return this.graduateService.getByUserId(graduate);
    }
    //上传照片
    @PostMapping("/imgUpload")
    public RestFulBean<String> imgUpload(@RequestParam(value = "userId",required = false) Integer userId,@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return graduateService.graduateService(userId,coverFile);
    }
}

