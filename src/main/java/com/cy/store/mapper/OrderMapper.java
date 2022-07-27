package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/27 23:17
 * @Description: 订单持久层接口
 */
@SuppressWarnings({"all"})
public interface OrderMapper {


    /**
     * 插入订单信息
     * @param order 订单信息
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单项的数据
     * @param orderItem 订单项数据
     * @return受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

}
