package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
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

public class OrderMapperTests {
    @Autowired
    OrderMapper mapper;

    @Test
    public void insertOrder(){
        Order order = new Order();
        order.setUid(11);
        order.setRecvName("张某");
        order.setStatus(4);
        order.setPayTime(new Date());
        mapper.insertOrder(order);
    }
    @Test
    public void insertOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(10000012);
        orderItem.setTitle("戴尔Dell 燃700R1605高配版银色");
        Integer integer = mapper.insertOrderItem(orderItem);
        System.out.println(integer);
    }
}
