package com.cy.store.service.impl;

import com.cy.store.contant.UserContant;
import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import com.cy.store.utils.Md5Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/18 18:33
 * @Description:
 */
@SuppressWarnings({"all"})
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        //调用findByUsername(username)判断用户是否被注册过
        String username = user.getUsername();
        User result = userMapper.findByUsername(username);
        //判断结果集是否为null,不为null抛出用户名被占用的异常
        if (result != null){
            //抛出异常
           throw new UsernameDuplicatedException("用户名“"+username+"”被占用");

        }
        //密码的加密处理：md5算法的形式
        //(串 + password + 串)  ---》md5算法加密,连续加密三次
        //盐值 + password + 盐值  --盐值是一个随机字符串
        String oldPassword = user.getPassword();
        //获取盐值(随机生成一个盐值);
        String salt = UUID.randomUUID().toString().toUpperCase();
        //将密码和盐值作为一个整体加密处理
        String md5Password = Md5Password.getMd5Password(oldPassword,salt);
        //设置加密后的密码
        user.setPassword(md5Password);
        //盐值的记录
        user.setSalt(salt);
        //数据补全：is_Delete设置成0 未删除状态
        user.setIsDelete(UserContant.UN_DELETE);
        //四个日志字段信息
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        //没有异常执行注册业务功能
        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw  new InsertExcetion("在用户支持过程中产生了未知的异常");
        }

    }

    @Override
    public User login(String username, String password) {
        //查询该用户是否存在，不存在抛出异常
        User result = userMapper.findByUsername(username);
        if (result == null){
            throw new UserNotFoundException("该用户名没有注册");
        }
        //检测用户密码是否匹配
        //1.获取到数据库中加密的密码
        String oldPassword = result.getPassword();
        //2.和用户传递过来的密码进行比较
        //2.1获取该账号匹配的盐值
        String salt = result.getSalt();
        //2.2将用户密码按照相同的md5算法规则进行加密
        String newMd5Password = Md5Password.getMd5Password(password,salt);
        //3.将密码进行比较
        if (!oldPassword.equals(newMd5Password)){
            throw new PasswordNotMatchException("密码错误");
        }
        //判断is_delect字段是否为1表示被删除
        if (result.getIsDelete() == UserContant.IS_DELETE){
            throw new UserNotFoundException("该用户名没有注册");
        }
        //调用Mapper层的方法查询用户数据  返回的user对象是为了辅助其他页面做数据展示使用（uid,username,avatar）
        //提升了系统的性能
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == UserContant.IS_DELETE){
            throw new UserNotFoundException("用户数据不存在");
        }
        //原始密码和数据库中密码进行比较
        String oldMd5Password  =  Md5Password.getMd5Password(oldPassword,result.getSalt());
        if (!result.getPassword().equals(oldMd5Password)){
            throw new PasswordNotMatchException("原密码错误");
        }
        //将新密码进行加密 再更新
        String newMd5Pssword = Md5Password.getMd5Password(newPassword , result.getSalt());

        Integer rows = userMapper.updatePasswordByUid(uid,newMd5Pssword,username,new Date());
        if (rows != 1){
            throw new UpdateExcetion("修改密码时发送未知错误");
        }
    }

    /**
     *
     * @param uid 用户uid
     * @return
     */
    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result==null||result.getIsDelete()==UserContant.IS_DELETE){
            throw new UserNotFoundException("用户没被找到");
        }
        User user = new User();
        user.setPhone(result.getPhone());
        user.setUsername(result.getUsername());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    /**
     *
     * @param username 用户的名称
     * @param uid    用户uid
     * @param user 用户数据
     */
    @Override
    public void changeInfo(String username, Integer uid, User user) {
        User result = userMapper.findByUid(uid);
        if (result==null||result.getIsDelete()==UserContant.IS_DELETE){
            throw new UserNotFoundException("用户没被找到");
        }
        user.setUid(uid);
        user.setModifiedTime(new Date());
        user.setModifiedUser(username);

        Integer rows = userMapper.updateInfoByUid(user);
        if (rows!=1){
            throw new UpdateExcetion("更改信息时发送未知异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if (result==null || result.getIsDelete() == UserContant.IS_DELETE){
            throw new UserNotFoundException();
        }
        Integer rows = userMapper.upDateAvatarByUid(uid, avatar, username, new Date());
        if (rows != 1){
            throw new UpdateExcetion("修改时发生未知异常");
        }
    }
}
