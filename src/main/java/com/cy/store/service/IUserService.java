package com.cy.store.service;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/18 18:27
 * @Description:用户模块业务接口
 */
@SuppressWarnings({"all"})
public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    /**
     * 用户登入功能
     * @param username 用户名
     * @param password 用户密码
     * @return 当去匹配的用户数据
     */
    User login( String username , String password);

    /**
     * 修改用户密码的方法
     * @param uid 用户uid
     * @param username 用户名
     * @param oldPassword 用户老密码
     * @param password 用户新密码
     */
    void changePassword(Integer uid ,String username,String oldPassword,String newpassword);


    /**
     * 根据用户的uid查询用户数据
     * @param uid 用户uid
     * @return 用户的数据
     */
    User getByUid(Integer uid);

    /**
     * 修改用户数据操作
     * @param username 用户的名称
     * @param uid    用户uid
     * @param user 用户数据
     */
    void changeInfo(String username,Integer uid ,User user);

    /**
     * 修改用户头像的操作
     * @param uid 用户uid
     * @param avatar 用户头像地址
     * @param username 修改者名称
     */
    void changeAvatar(Integer uid,String avatar,String username);
}
