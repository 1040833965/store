package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class UserServiceTests {
    /**
     * 单元测试：
     * 必须被@Test修饰
     * 返回值必须是void
     * 方法的参数列表不能指定任何类型
     * 方法的访问修饰符必须是public
     */
    //idea有检测的功能，接口不能是直接创建Bean的（动态代理技术来解决）
    @Autowired
    private IUserService iUserService;

    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("傻狗02");
            user.setPassword("123456");
            iUserService.reg(user);
            System.out.println("ok");
        } catch (ServiceException e) {
            //获取异常的具体信息
            System.out.println(e.getMessage());
            //获取异常类的名称
            System.out.println(e.getStackTrace());
        }
    }


    @Test
    public void login(){
        User user = iUserService.login("test01","123");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        iUserService.changePassword(11,"我","123456","123456");
        System.out.println();
    }

    @Test
    public void getByUid(){
        User user = iUserService.getByUid(11);
        System.out.println(user);
    }

    @Test
    public void changeInfo(){
        User user = iUserService.getByUid(11);
        iUserService.changeInfo("测试01",11,user);
    }

    @Test
    public void changeAvatar(){
        Integer uid = 11;
        String path = "/imgs2416324641";
        String username = "测试01";
        iUserService.changeAvatar(uid,path,username);
    }
}
