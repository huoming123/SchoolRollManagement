package com.design.SchoolRollManagement.service.impl;

import com.design.SchoolRollManagement.mapper.ScoreMapper;
import com.design.SchoolRollManagement.mapper.UsersMapper;
import com.design.SchoolRollManagement.pojo.Graduate;
import com.design.SchoolRollManagement.mapper.GraduateMapper;
import com.design.SchoolRollManagement.pojo.LeaveSchool;
import com.design.SchoolRollManagement.pojo.Score;
import com.design.SchoolRollManagement.pojo.Users;
import com.design.SchoolRollManagement.service.GraduateService;
import com.design.SchoolRollManagement.util.FileUtil;
import org.apache.catalina.User;
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
import org.springframework.web.multipart.MultipartFile;

/**
 * (Graduate)表服务实现类
 *
 * @author makejava
 * @since 2023-04-12 09:54:54
 */
@Service("graduateService")
public class GraduateServiceImpl implements GraduateService {
    @Autowired
    private GraduateMapper graduateMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private UsersMapper usersMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Graduate> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Graduate> list= graduateMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Graduate graduate: list){
                Integer creditTotal=0; //定义总学分
                Double gradePointTotal=0.00; //定义总绩点
                List<Score> listed=  scoreMapper.getScoreList(graduate.getUserId()); //获取学生ID获取学分数据
                //计算学分绩点
                for(Score scored:listed){ //用for把学分绩点的加起来
                    creditTotal=creditTotal+scored.getCredit(); //计算学分
                    gradePointTotal=gradePointTotal+scored.getGradePoint(); //计算绩点
                }
                List<Score> list1=  scoreMapper.getScoreList1(graduate.getUserId()); //获取学生已挂科目
                graduate.setGradePointTotal(gradePointTotal); //总绩点
                graduate.setCreditTotal(creditTotal);//总学分
                graduate.setFailTotal(list1.size());//未通过科目
                if(graduate.getAdvanced()!=null){
                    graduate.setAdvancedUrl("http://localhost:8087/file/"+graduate.getAdvanced()); //高级证书
                }
                if (graduate.getIntermediate()!=null){
                    graduate.setIntermediateUrl("http://localhost:8087/file/"+graduate.getIntermediate()); //中级证书
                }
                if (graduate.getLevelFour()!=null){
                    graduate.setLevelFourUrl("http://localhost:8087/file/"+graduate.getLevelFour()); //四级证书
                }
                if (graduate.getLevelSix()!=null) {
                    graduate.setLevelSixUrl("http://localhost:8087/file/"+graduate.getLevelSix()); //六级证书
                }
                if (graduate.getCertificate()!=null) {
                    graduate.setCertificateUrl("http://localhost:8087/file/"+graduate.getCertificate()); //实习证明
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = graduateMapper.getPageListCount(page);
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
    public RestFulBean<Graduate> queryById(Integer id) {
       Graduate graduate=this.graduateMapper.queryById(id);
         return RestFulBean.succ(graduate);
    }

    /**
     * 新增数据
     *
     * @param graduate 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Graduate graduate) {
        this.graduateMapper.insert(graduate);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param graduate 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Graduate graduate) {
        this.graduateMapper.update(graduate);//执行数据库的修改语句 根据id 修改
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
        this.graduateMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<String> certificateUpload(Integer userId,Integer professionId, Integer classeId, Integer index, MultipartFile coverFile) throws Exception {
        String destPath ="D:\\design\\images\\";//自定义一个路径
        // 存图片
        try{//用一个file文件上传的方法上传照片
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());//上传图片的方法
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        Map map =new HashMap();//定义一个map对象
        Users user =usersMapper.queryById(userId); //获取学生信息
        //获取入学年份
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
        String year = fmt.format(user.getStartAt()); //字符串日期赋值

        Graduate graduate =graduateMapper.getByUserId(userId); //判断是否上传了证书
        Graduate graduated = new Graduate();
         if(graduate==null){
             if(index==1){ //等于1 说明是第一张照片
                 graduated.setYear(year);
                 graduated.setUserId(userId);  //学生ID
                 graduated.setClasseId(classeId);  //班级ID
                 graduated.setProfessionId(professionId);//专业ID
                 graduated.setIntermediate(coverFile.getOriginalFilename());  //中及证书
                 this.graduateMapper.insert(graduated);//执行数据库的新增语句
             }
             if(index==2){ //等于2 说明是第二张照片
                 graduated.setYear(year);
                 graduated.setUserId(userId);  //学生ID
                 graduated.setClasseId(classeId);  //班级ID
                 graduated.setProfessionId(professionId);//专业ID
                 graduated.setAdvanced(coverFile.getOriginalFilename());  //高级证书
                 this.graduateMapper.insert(graduated);//执行数据库的新增语句
             }
             if(index==3){ //等于3 说明是第三张照片
                 graduated.setYear(year);
                 graduated.setUserId(userId);  //学生ID
                 graduated.setClasseId(classeId);  //班级ID
                 graduated.setProfessionId(professionId);//专业ID
                 graduated.setLevelFour(coverFile.getOriginalFilename());  //四级英语证书
                 this.graduateMapper.insert(graduated);//执行数据库的新增语句
             }
             if(index==4){ //等于4 说明是第四张照片
                 graduated.setYear(year);
                 graduated.setUserId(userId);  //学生ID
                 graduated.setClasseId(classeId);  //班级ID
                 graduated.setProfessionId(professionId);//专业ID
                 graduated.setLevelSix(coverFile.getOriginalFilename());  //六级英语证书
                 this.graduateMapper.insert(graduated);//执行数据库的新增语句
             }
         }
        if(graduate!=null) {
            if (index == 1) { //等于1 说明是第一张照片
                graduated.setUserId(userId);  //学生ID
                graduated.setIntermediate(coverFile.getOriginalFilename());  //中及证书
                this.graduateMapper.updateByUserId(graduated);//执行数据库的修改语句 根据useriId 修改
            }
            if (index == 2) { //等于2 说明是第二张照片
                graduated.setUserId(userId);  //学生ID
                graduated.setAdvanced(coverFile.getOriginalFilename());  //高级证书
                this.graduateMapper.updateByUserId(graduated);//执行数据库的修改语句 根据useriId 修改
            }
            if (index == 3) { //等于3 说明是第三张照片
                graduated.setUserId(userId);  //学生ID
                graduated.setLevelFour(coverFile.getOriginalFilename());  //四级英语证书
                this.graduateMapper.updateByUserId(graduated);//执行数据库的修改语句 根据useriId 修改
            }
            if (index == 4) { //等于4 说明是第四张照片
                graduated.setUserId(userId);  //学生ID
                graduated.setLevelSix(coverFile.getOriginalFilename());  //六级英语证书
                this.graduateMapper.updateByUserId(graduated);//执行数据库的修改语句 根据useriId 修改
            }
        }
        return RestFulBean.succ("上传成功");
    }

    @Override
    public RestFulBean<String> graduateService(Integer userId, MultipartFile coverFile) {
        String destPath ="D:\\design\\images\\";//自定义一个路径
        // 存图片
        try{//用一个file文件上传的方法上传照片
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());//上传图片的方法
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }

        Graduate graduate =new Graduate();
        graduate.setUserId(userId);
        graduate.setCertificate(coverFile.getOriginalFilename());  //实习证明
        this.graduateMapper.updateByUserId(graduate);//执行数据库的修改语句 根据useriId 修改
        return RestFulBean.succ("上传成功");
    }

    @Override
    public RestFulBean<Graduate> getByUserId(Graduate graduate) {
        Graduate graduated =graduateMapper.getByUserId(graduate.getUserId()); //根据id获取证书
        if(graduated!=null){
            if(graduated.getAdvanced()!=null){
                graduated.setAdvancedUrl("http://localhost:8087/file/"+graduated.getAdvanced()); //高级证书
            }
            if (graduated.getIntermediate()!=null){
                graduated.setIntermediateUrl("http://localhost:8087/file/"+graduated.getIntermediate()); //中级证书
            }
            if (graduated.getLevelFour()!=null){
                graduated.setLevelFourUrl("http://localhost:8087/file/"+graduated.getLevelFour()); //四级证书
            }
            if (graduated.getLevelSix()!=null) {
                graduated.setLevelSixUrl("http://localhost:8087/file/"+graduated.getLevelSix()); //六级证书
            }
            if (graduated.getCertificate()!=null) {
                graduated.setCertificateUrl("http://localhost:8087/file/"+graduated.getCertificate()); //实习证明
            }
        }

        return RestFulBean.succ(graduated);
    }
}
