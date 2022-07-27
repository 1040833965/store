package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
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
public class DistrictMapperTests {
    /**
     * 单元测试：
     * 必须被@Test修饰
     * 返回值必须是void
     * 方法的参数列表不能指定任何类型
     * 方法的访问修饰符必须是public
     */
    @Autowired
    DistrictMapper districtMapper;


    @Test
    public void findByParent(){
        String parent = "110100";
        List<District> byParent = districtMapper.findByParent(parent);
        for (District dist: byParent
             ) {
            System.out.println(dist);
        }
    }

    @Test
    public void findNameByCode(){
        String code = "110101";
        String name = districtMapper.findNameByCode(code);
        System.out.println(name);
    }


}
