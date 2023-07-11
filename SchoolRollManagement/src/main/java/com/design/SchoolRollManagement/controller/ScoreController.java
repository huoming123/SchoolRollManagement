package com.design.SchoolRollManagement.controller;

import com.design.SchoolRollManagement.pojo.Score;
import com.design.SchoolRollManagement.service.ScoreService;
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
 * (Score)表控制层
 *
 * @author makejava
 * @since 2023-04-08 13:45:43
 */
@RestController
@RequestMapping("/score")
public class ScoreController {
    /**
     * 服务对象
     */
    @Autowired
    private ScoreService scoreService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Score>page) throws Exception{
        return this.scoreService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Score> queryById(@RequestBody Score score) {
        return this.scoreService.queryById(score.getId());
    }

    /**
     * 新增数据
     *
     * @param score 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Score score) {
        return this.scoreService.insert(score);
    }

    /**
     * 编辑数据
     *
     * @param score 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Score score) {
        return this.scoreService.update(score);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Score score) {
        return this.scoreService.deleteById(score.getId());
    }
    /**
     * 获取成绩数据
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/grade/list")
    public RestFulBean<List<Score>> getGradeList(@RequestBody Score score) throws Exception{
        return this.scoreService.getGradeList(score);
    }
    /**
     * 获取学生首页统计
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/getTotal")
    public RestFulBean<Map> getTotal(@RequestBody Score score) throws Exception{
        return this.scoreService.getTotal(score);
    }
}

