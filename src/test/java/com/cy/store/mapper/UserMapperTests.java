package com.cy.store.mapper;

import com.cy.store.contant.UserContant;
import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/17 20:54
 * @Description:
 */

// 表示启动这个单元测试类（单元测试类是不能运行的），需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
////SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest

public class UserMapperTests {
    /**
     * 单元测试：
     * 必须被@Test修饰
     * 返回值必须是void
     * 方法的参数列表不能指定任何类型
     * 方法的访问修饰符必须是public
     */
    //idea有检测的功能，接口不能是直接创建Bean的（动态代理技术来解决）
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("user03");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUsername() {
        String username = "user02";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }

    @Test
    public void updatePasswordByUid(){
        Integer uid = 8;
        String Password = "123456";
        String modifiedUser = "管理员01";
        Date date = new Date();
        Integer rows =
        userMapper.updatePasswordByUid(uid,Password,modifiedUser,date);
        System.out.println(rows);
    }

    @Test
    public void findByUid(){
        //User findByUid(Integer uid);
        Integer uid = 8;
        User user = userMapper.findByUid(uid);
        System.out.println(user);
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(11);
        user.setPhone("123456789");
        user.setEmail("1040833965@qq.com");
        user.setGender(0);
        userMapper.updateInfoByUid(user);
        System.out.println("ok");
    }

    @Test
    public void UpDateAvatarByUidTest(){
        String path = "D:/hello";
        String modifiedUser = "测试01";
        Date modifiedDate = new Date();
        Integer uid = 11;
        Integer rows = userMapper.upDateAvatarByUid(uid,path,modifiedUser,modifiedDate);
        System.out.println(rows);
    }
}
