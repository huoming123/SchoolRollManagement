package com.design.SchoolRollManagement.service.impl;

import com.design.SchoolRollManagement.pojo.Users;
import com.design.SchoolRollManagement.mapper.UsersMapper;
import com.design.SchoolRollManagement.service.UsersService;
import com.design.SchoolRollManagement.util.FileUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.SchoolRollManagement.pojo.res.RestFulBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.design.SchoolRollManagement.util.PageUtil;
import com.design.SchoolRollManagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2023-04-08 08:46:00
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Users> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Users users: list){
                users.setImageUrl("http://localhost:8087/file/"+users.getImage());
            }
        }
        //根据条件查询数据的条数
        Integer count = usersMapper.getPageListCount(page);
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
    public RestFulBean<Users> queryById(Integer id) {
       Users users=this.usersMapper.queryById(id);
        users.setImageUrl("http://localhost:8087/file/"+users.getImage());
         return RestFulBean.succ(users);
    }
    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Users users) {

        if(users.getCardId()==null){
            return RestFulBean.error("身份证号码不能为空");
        }
        if(users.getUserName()==null){
            return RestFulBean.error("姓名不能为空");
        }
        if(users.getProfessionId()==null){
            return RestFulBean.error("专业不能为空");
        }
        if(users.getClasseId()==null){
            return RestFulBean.error("班级不能为空");
        }
        if(users.getImage()==null){
            return RestFulBean.error("图片不能为空");
        }
        if(users.getAge()==null){
            return RestFulBean.error("年龄不能为空");
        }
        if(users.getBirthday()==null){
            return RestFulBean.error("出生日期不能为空");
        }
        if(users.getNation()==null){
            return RestFulBean.error("民族不能为空");
        }
        if(users.getNativePlace()==null){
            return RestFulBean.error("籍贯不能为空");
        }
        if(users.getPolitical()==null){
            return RestFulBean.error("政治面貌不能为空");
        }
        if(users.getTelephone()==null){
            return RestFulBean.error("手机号码不能为空");
        }

        if(users.getCardId().trim().length()!=18){
            return RestFulBean.error("请输入18位身份证号码");
        }
        if(users.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(users.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        //13位时间戳作为学号 不可能重复
        long timeMillis=System.currentTimeMillis(); //当前系统时间戳
        //取前八位作为一个学号
        String userNo=String.valueOf(timeMillis).substring(0,8);
        users.setUserNo(String.valueOf(userNo));
        try{
            //users.getCardId().trim()拿字符串去空
            Users user = usersMapper.getByCardId(users.getCardId().trim());//根据身份证cardId查询用户
            if(user!=null){ //身份证唯一
                return RestFulBean.error("该身份证已经录入,请不要重复录入");
            }
            users.setPassword(String.valueOf(userNo));//将密码设为学号 初始密码 后面学生可自行修改
            usersMapper.insert(users);
        }
        catch (Exception e){
            return RestFulBean.error("请求异常");
        }
        if(users.getRole().equals("student")){
            return RestFulBean.succ("注册成功,学号密码为"+userNo+"请登录自行修改密码");
        }
        return RestFulBean.succ("录入成功,教师编号和密码为"+userNo+"请登录自行修改密码");
    }


    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Users users) {
        this.usersMapper.update(users);//执行数据库的修改语句 根据id 修改
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
        this.usersMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    /**
     * 登录接口
     *
     * @param
     * @return 是否成功
     */
    @Override
    public RestFulBean<Map<String, Object>> login(Users users) {//RestFulBean<Map<String, Object>> 这样写就是返回map的对象给前端
        if(users.getUserNo()==null)
        {
            return RestFulBean.error("学号或教师编号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }
        if(users.getRole()==null)
        {
            return RestFulBean.error("角色不能为空");
        }
        String role =users.getRole();//获取角色
        String userNo=users.getUserNo().trim();//获取教师编号或学号  users.getUserNo().trim()去空格
        //new 一个map对象 用于返回数据给前端
        Map<String,Object> result =new HashMap<>();
        Users user =usersMapper.getByUserNoAndRole(userNo,role);//根据教师编号或学号跟角色获取用户数据
        //用户不为空
        if (user!=null){
            if(user.getChecked()==0){
                return RestFulBean.error("你的账号还未审核，待班主任审核通过之后才可登录");
            }
            //密码跟数据库一样
            if(users.getPassword().equals(user.getPassword()))
            {
                //返回userName 把这个值在前端存起来 后面录入信息需要用到
                result.put("userName",user.getUserName());
                //返回userId 在前端存起来 获取菜单的接口需要传用户id
                result.put("userId",user.getId());
                result.put("classeId",user.getClasseId()); //班级
                result.put("professionId",user.getProfessionId()); //专业
                result.put("role",user.getRole());
                result.put("images",user.getImage());
                return RestFulBean.succ(result);
            }
            else{
                return RestFulBean.error("密码错误");
            }

        }
        return RestFulBean.error("用户不存在");
    }
    @Override
    public RestFulBean<Map> upload(MultipartFile coverFile) {
        String destPath ="D:\\design\\images\\";//自定义一个路径
        // 存图片
        try{//用一个file文件上传的方法上传照片
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());//上传图片的方法
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        Map map =new HashMap();//定义一个map对象
        //返回一个完整的本地照片路径用于前端显示
        map.put("url","http://localhost:8087/file/"+coverFile.getOriginalFilename());
        //把照片的名字重新返回给前端用于保存到数据库users表的images字段中
        map.put("imageName",coverFile.getOriginalFilename());
        return RestFulBean.succ(map);
    }
    @Override
    public RestFulBean<List<Users>> getTeachList() {
        List<Users> list =usersMapper.getTeachList();
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<String> updateRecord(Users users) {
        this.usersMapper.update(users);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功");
    }

    @Override
    public RestFulBean<Map> getAnalyseList(Users users) {
        Map result =new HashMap();
        List typeList = new ArrayList<>();
        List<Users> list  =usersMapper.getAnalyseList(users); //获取专业人数
        for(Users analysed:list){
            Map type =new HashMap();
            type.put("value",analysed.getCount()); //人数
            type.put("name",analysed.getProfessionName()); //专业
            typeList.add(type);
        }
        result.put("typeList",typeList);
        return RestFulBean.succ(result);
    }

    @Override
    public RestFulBean<Map> getTotalByYear() {
        Map result =new HashMap(); //定义一个对象
        List countList=new ArrayList(); //定义一个数量的数组
        List yearList =new ArrayList();//定义一个年份的数组
        List<Users> lsit = usersMapper.getUserByYear(); //根据年份获取入学学生数量
        for(Users user :lsit)
        {
            countList.add(user.getCount()); //把每年的学生数量加到数组里面去
            yearList.add(user.getYear());//把年份加到数组里面去
        }
        result.put("countList",countList);  //将处理好的数据返回前端
        result.put("yearList",yearList);
        return RestFulBean.succ(result);
    }



}
