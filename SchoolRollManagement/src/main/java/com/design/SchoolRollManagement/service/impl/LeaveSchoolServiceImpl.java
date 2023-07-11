package com.design.SchoolRollManagement.service.impl;

import com.design.SchoolRollManagement.pojo.LeaveSchool;
import com.design.SchoolRollManagement.mapper.LeaveSchoolMapper;
import com.design.SchoolRollManagement.pojo.Users;
import com.design.SchoolRollManagement.service.LeaveSchoolService;
import com.design.SchoolRollManagement.util.FileUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.SchoolRollManagement.util.PageUtil;
import com.design.SchoolRollManagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * (LeaveSchool)表服务实现类
 *
 * @author makejava
 * @since 2023-04-13 14:19:54
 */
@Service("leaveSchoolService")
public class LeaveSchoolServiceImpl implements LeaveSchoolService {
    @Autowired
    private LeaveSchoolMapper leaveSchoolMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<LeaveSchool> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<LeaveSchool> list= leaveSchoolMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(LeaveSchool leaveSchool: list){
                leaveSchool.setDiplomaImagesUrl("http://localhost:8087/file/"+leaveSchool.getDiplomaImages()); //毕业证书
                leaveSchool.setRegistrationCardImagesUrl("http://localhost:8087/file/"+leaveSchool.getRegistrationCardImages()); //报到证书
                if(leaveSchool.getLeavingCertificate()!=null){ //学校上传了离校证明那么放回一个下载路劲
                    leaveSchool.setLeavingCertificateUrl("http://localhost:8087/file/"+leaveSchool.getLeavingCertificate()); //离校证明
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = leaveSchoolMapper.getPageListCount(page);
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
    public RestFulBean<LeaveSchool> queryById(Integer id) {
       LeaveSchool leaveSchool=this.leaveSchoolMapper.queryById(id);
         return RestFulBean.succ(leaveSchool);
    }

    /**
     * 新增数据
     *
     * @param leaveSchool 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(LeaveSchool leaveSchool) {
        this.leaveSchoolMapper.insert(leaveSchool);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param leaveSchool 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(LeaveSchool leaveSchool) {
        this.leaveSchoolMapper.update(leaveSchool);//执行数据库的修改语句 根据id 修改
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
        this.leaveSchoolMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<String> upload(Integer id, MultipartFile coverFile) {
        String destPath ="D:\\design\\images\\";//自定义一个路径
        // 存图片
        try{//用一个file文件上传的方法上传照片
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());//上传图片的方法
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }

        LeaveSchool leaveSchool =new LeaveSchool();
        leaveSchool.setId(id);
        leaveSchool.setLeavingCertificate(coverFile.getOriginalFilename());  //离校证明
        this.leaveSchoolMapper.update(leaveSchool);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("上传成功");
    }
}
