package com.design.SchoolRollManagement.controller;

import com.design.SchoolRollManagement.pojo.Users;
import com.design.SchoolRollManagement.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.SchoolRollManagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2023-04-08 08:45:58
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    /**
     * 服务对象
     */
    @Autowired
    private UsersService usersService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Users>page) throws Exception{
        return this.usersService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Users> queryById(@RequestBody Users users) {
        return this.usersService.queryById(users.getId());
    }

    /**
     * 学生注册
     *
     * @param users 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Users users) {
        return this.usersService.insert(users);
    }

    /**
     * 编辑数据
     *
     * @param users 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Users users) {
        return this.usersService.update(users);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Users users) {
        return this.usersService.deleteById(users.getId());
    }
    /**
     * 修改学籍状态
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/updateRecord")
    public RestFulBean<String> updateRecord(@RequestBody Users users) {
        return this.usersService.updateRecord(users);
    }

    /**
     *  登录
     * @param Users 需要teachNo和password
     * @return data token
     */
    @PostMapping("/login")
    public RestFulBean<Map<String,Object>> login(@RequestBody Users Users) throws Exception {
        return usersService.login(Users);
    }
    //上传照片
    @PostMapping("/upload/image")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return usersService.upload(coverFile);
    }
    //获取班主任列表
    @PostMapping("/get/teachList")
    public RestFulBean<List<Users>> getTeachList() throws Exception {
        return usersService.getTeachList();
    }
    /**
     * 各专业学生统计分析
     *
     * @param
     * @return
     */
    @PostMapping("/get/total/by/profession")
    public RestFulBean<Map> getAnalyseList(@RequestBody Users Users) throws Exception {
        return usersService.getAnalyseList(Users);
    }
    /**
     * 根据年份获取每年入学学生数量
     *
     * @param
     * @return
     */
    @PostMapping("/get/total/by/year")
    public RestFulBean<Map> getTotalByYear() throws Exception{
        return this.usersService.getTotalByYear();
    }
}

