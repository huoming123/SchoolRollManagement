package com.design.SchoolRollManagement.service.impl;

import com.design.SchoolRollManagement.mapper.GraduateMapper;
import com.design.SchoolRollManagement.pojo.Graduate;
import com.design.SchoolRollManagement.pojo.Score;
import com.design.SchoolRollManagement.mapper.ScoreMapper;
import com.design.SchoolRollManagement.service.ScoreService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.SchoolRollManagement.util.PageUtil;
import com.design.SchoolRollManagement.dto.Page;
/**
 * (Score)表服务实现类
 *
 * @author makejava
 * @since 2023-04-08 13:45:43
 */
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private GraduateMapper graduateMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Score> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Score> list= scoreMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = scoreMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Score> queryById(Integer id) {
       Score score=this.scoreMapper.queryById(id);
         return RestFulBean.succ(score);
    }

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Score score) {
        if(score.getYear()==null){
            return RestFulBean.error("年份不能为空");
        }
        if(score.getScore()==null){
            return RestFulBean.error("成绩不能为空");
        }
        if(score.getCourseName()==null){
            return RestFulBean.error("课程不能为空");
        }
        if(score.getTerm()==null){
            return RestFulBean.error("学期不能为空");
        }
        Score scored=scoreMapper.getByUserID(score); //判断成绩是否会重复录入
        if(scored!=null){
            return RestFulBean.error("该学期你已录入该门成绩，请不要重复录入");
        }
        this.scoreMapper.insert(score);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Score score) {
        this.scoreMapper.update(score);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功"); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.scoreMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Score>> getGradeList(Score score) {
        List<Score> list =scoreMapper.getGradeList(score);
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<Map> getTotal(Score score) {
        Integer certificateTotal =0;//定义已获证书
        Integer creditTotal=0; //定义总学分
        Double gradePointTotal=0.00; //定义总绩点
        Map result = new HashMap();
        List<Score> list=  scoreMapper.getScoreList(score.getUserId()); //获取学生登陆人学分数据
        //计算学分绩点
        for(Score scored:list){ //用for把学分绩点的加起来
            creditTotal=creditTotal+scored.getCredit(); //计算学分
            gradePointTotal=gradePointTotal+scored.getGradePoint(); //计算绩点
        }
        List<Score> list1=  scoreMapper.getScoreList1(score.getUserId()); //获取学生登陆人已挂科目
        Graduate graduate=  graduateMapper.getByUserId(score.getUserId()); //获取证书数据
        if(graduate!=null){
            if(graduate.getLevelSix()!=null){   //六级证书不空+1本
                certificateTotal=certificateTotal+1;
            }
            if(graduate.getLevelFour()!=null){   //四级证书不空+1本
                certificateTotal=certificateTotal+1;
            }
            if(graduate.getAdvanced()!=null){   //不空+1本
                certificateTotal=certificateTotal+1;
            }
            if(graduate.getIntermediate()!=null){   //不空+1本
                certificateTotal=certificateTotal+1;
            }
        }
        result.put("creditTotal",creditTotal);//已修学分
        result.put("gradePointTotal",gradePointTotal);//已获绩点
        result.put("failTotal",list1.size());//已挂科目
        result.put("certificateTotal",certificateTotal);//已获证书
        return RestFulBean.succ(result);
    }
}
