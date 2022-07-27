package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
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

public class AddressMapperTests {
    /**
     * 单元测试：
     * 必须被@Test修饰
     * 返回值必须是void
     * 方法的参数列表不能指定任何类型
     * 方法的访问修饰符必须是public
     */
    @Autowired
    AddressMapper mapper;


    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(11);
        address.setPhone("17762956390");
        address.setName("man");

        Integer rows = mapper.insert(address);
        System.out.println(rows);
    }

    @Test
    public void countByUid(){
        Integer rows = mapper.countByUid(11);
        System.out.println(rows);
    }

    @Test
    public void findByUid(){
        List<Address> dis= mapper.findByUid(11);
        for (Address d:dis
             ) {
            System.out.println(d);
        }
    }

    @Test
    public void findByAid(){
        Address address = mapper.findByAid(9);
        System.out.println(address);
    }

    @Test
    public void updateNonDefault(){
        Integer rows = mapper.updateNonDefault(11);
        System.out.println(rows);
    }

    @Test
    public void updateDefaultByAid(){
        Integer rows = mapper.updateDefaultByAid(9,"测试01",new Date());
        System.out.println(rows);
    }

    @Test
    public void deleteAddressByAid(){
        Integer rows = mapper.deleteAddressByAid(9);
        System.out.println(rows);
    }

    @Test
    public void findLastModified(){
        Address address = mapper.findLastModified(11);
        System.out.println(address);
    }
}
