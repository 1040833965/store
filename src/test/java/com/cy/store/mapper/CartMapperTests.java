package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;
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

public class CartMapperTests {
    /**
     * 单元测试：
     * 必须被@Test修饰
     * 返回值必须是void
     * 方法的参数列表不能指定任何类型
     * 方法的访问修饰符必须是public
     */
    @Autowired
    CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(11);
        cart.setNum(1);
        cart.setPid(10000017);
        cart.setPrice(1000L);
        cartMapper.insert(cart);
    }
    @Test
    public void updateNumByCid(){
        cartMapper.updateNumByCid(1,1,"测试01",new Date());
    }
    @Test
    public void findByUidAndPid(){
        Cart cart = cartMapper.findByUidAndPid(11, 10000);
        System.out.println(cart);
    }

    @Test
    public void findOVByUid(){
        System.out.println(cartMapper.findVOByUid(11));

    }

    @Test
    public void cutNumByCid(){
        System.out.println(cartMapper.cutNumByCid(4,"测试10",new Date(),11));
    }

    @Test
    public void addNumByCid(){
        System.out.println(cartMapper.addNumByCid(4,"测试10",new Date(),11));
    }

    @Test
    public void findOVByCid(){
        Integer[] integers = {3,4,5};
        List<CartVO> ovByCid = cartMapper.findVOByCids(integers);
        for (CartVO cvo :
                ovByCid) {
            System.out.println(cvo);
        }
    }
}
