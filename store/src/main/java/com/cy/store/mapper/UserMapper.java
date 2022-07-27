package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/** 处理用户数据操作的持久层接口 */
public interface UserMapper {
    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    User findByUsername(String username);

    /**
     *
     ** 根据用户的Uid来修改用户的密码
     * @param uid 用户uid
     * @param newPassword 用户输入的新密码
     * @param modifiedUser 修改的执行者
     * @param modifiedTime 修改数据的时间
     * @return 受印象的函数
     */
    Integer updatePasswordByUid(@Param("uid") Integer uid,
                                @Param("password") String newPassword,
                                @Param("modifiedUser") String modifiedUser,
                                @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据uid查询用户数据
     * @param uid 用户uid
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    User findByUid(Integer uid);

    /**
     * 更新用户的信息
     * @param user  用户数据
     * @return  返回值为受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * 根据uid修改用户的头像
     * @Param("sql映射文件中#{}占位符的变量名")：解决了sql语句的占位符和映射的接口方法参数名不一致时，
     * 需要将某个参数强行注入到某个占位符变量上时，可以使用@Param来标注映射的关系
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer upDateAvatarByUid(@Param("uid") Integer uid,
                      @Param("avatar") String avatar,
                      @Param("modifiedUser") String modifiedUser,
                      @Param("modifiedTime") Date modifiedTime);
}
