package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import com.cy.store.service.impl.AddressServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
public class DistrictServiceTests {
    /**
     * 单元测试：
     * 必须被@Test修饰
     * 返回值必须是void
     * 方法的参数列表不能指定任何类型
     * 方法的访问修饰符必须是public
     */
    //idea有检测的功能，接口不能是直接创建Bean的（动态代理技术来解决）
   @Autowired
   private IDistrictService iDistrictService;


   @Test
   public void getByParent(){
       //拿取所有省份的
       List<District> byParent = iDistrictService.getByParent("86");
       for (District dist: byParent
            ) {
           System.out.println(dist);
       }
       iDistrictService.getByParent("");
   }

   @Test
    public void getNameByCoed(){
       String code = "110101";
       System.out.println( iDistrictService.getNameByCode(code));
   }
}
