package com.cy.store.controller;

import com.cy.store.contant.UserContant;
import com.cy.store.controller.ex.*;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertExcetion;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.service.impl.UserServiceImpl;
import com.cy.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/18 20:57
 * @Description: 用户操作控制层
 */
@SuppressWarnings({"all"})
//@Controller
@RestController //@Controller + RequestBody
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    /**
     * 跳转到选择页页面
     * @return
     */
    @RequestMapping("/")
    public String toMain(){
        return "index";
    }

    /**
     * SpringBoot 约定大于配置，省略掉了大量配置和注解的编写
     * 1.请求处理方法的参数列表设置未pojo类型来接受前端的数据
     * SpringBoot会将前端的url地址中的参数名和pojo中的属性名进行比较
     * 如果两个名称相同，则会将值注入到pojo类中对应的属性上
     * @param user
     * @return
     */
    @RequestMapping("reg")
    private JsonResult<Void> reg(User user){
        //创建响应结果对象
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    /**
     * 2.请求处理方法：请求处理方法的参数列表设置未非pojo类型，
     * SpringBoot直接将请求的参数名和方法名参数进行比较，如果名称相同则自动完成值的输入
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    private JsonResult<User> login(String username, String password , HttpSession session){

        User data = userService.login(username,password);
        //向session对象中完成数据的绑定（session全局的）
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());

        return new JsonResult<User>(OK,data);
    }

    @RequestMapping("change_password")
    private JsonResult<Void> changePassword(@RequestParam("oldPassword")String oldPassword,
                                            @RequestParam("newPassword") String newPassword,
                                            HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);

        return new JsonResult<>(OK);
    }


    @RequestMapping("get_by_uid")
    private JsonResult<User> getByUid(HttpSession session){
        User data = userService.getByUid(getUidFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("change_info")
    private JsonResult<Void> changeInfo(User user,
                                        HttpSession session){
        //user对象中有四部分数据：username\phone\email\gender
        //uid数据需要再次封装到user对象中
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(username,uid,user);
        return new JsonResult<>(OK);
    }


    /**
     * MultipartFile接口是SpingMVC提供的接口，这个接口为我们包装了获取
     * 文件类型的数据（任何类型的file都可以），SpringBoot整合了SpringMVC
     * 只需要在处理请求的方法参数列表上声明一个参数类型为 MultipartFile
     * 的参数，然后SpringBoot自动将传递给服务的文件数据赋值给这个参数
     *
     * @RequestParam表示请求中的参数。将请求中的参数注入请求处理方法的某个
     * 参数上，如果名称不一致可以使用@RequestParam注解进行标记和映射
     * @param session
     * @param file
     * @return
     */
    @RequestMapping("change_avatar")
    private JsonResult<String> changeAvatar(HttpSession session,
                                            @RequestParam("file") MultipartFile multipartFile){
            //判断文件是否为空
        if (multipartFile.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        if (multipartFile.getSize() > UserContant.AVATAR_MAX_SIZE){
            throw new FileSizeException("文件超出范围限制");
        }
        //如果集合包含某个文件类型返回true
        if (!UserContant.AVATAR_TYPE.contains(multipartFile.getContentType())){
            throw new FileTypeException("文件类型不支持");
        }
        //文件夹上传的文件目录结构 .../upload/文件.png
        String parent = session.getServletContext().getRealPath("upload");
        //file对象指向这给路径
        File dir = new File(parent);
        if (!dir.exists()){//检测目录是否存在
            dir.mkdirs();//创建目录
        }
        // 1、设置文件名   uuid + _ +源文件名
        String fileName = UUID.randomUUID()+"_"+multipartFile.getOriginalFilename();
        //设置文件完整存储路径
        File filePath = new File(dir, fileName);
        System.out.println(dir);
        //存储文件
        try {
            multipartFile.transferTo(filePath);
        }catch (FileStateException e){
            throw new FileStateException("文件状态异常");
        }catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        }
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        //返回头像的路径/upload/filename  该路径是相对于static路径下的
        String avatar = "/upload/"+fileName;
        userService.changeAvatar(uid,avatar,username);
        //返回头像路径，将来用来头像的展示
        return new JsonResult<>(OK,avatar);
    }


//    @RequestMapping("reg")
//    private JsonResult<Void> reg(User user){
//        //创建响应结果对象
//        JsonResult<Void> result = new JsonResult<>();
//        try {
//            userService.reg(user);
//            result.setState(200);
//            result.setMessage("注册成功");
//        } catch (UsernameDuplicatedException e) {
//            result.setState(4000);
//            result.setMessage("用户名被占用");
//        }catch (InsertExcetion e){
//            result.setState(5000);
//            result.setMessage("注册时发生位置异常");
//        }
//        return result;
//    }




}
