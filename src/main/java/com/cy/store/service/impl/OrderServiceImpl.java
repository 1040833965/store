package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.mapper.OrderMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.ICartService;
import com.cy.store.service.IOrderService;
import com.cy.store.service.ex.InsertExcetion;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/28 0:09
 * @Description:
 */
@SuppressWarnings({"all"})
@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;


    @Override
    public Order creatOrder(Integer aid, Integer uid, String username, Integer[] cid) {
        //即将要下单的列表
        List<CartVO> cartLsit = cartService.showOrder(cid, uid);
        Long totalPrice = 0L;//总价
        for (CartVO cartVo :
                cartLsit) {
            totalPrice += cartVo.getPrice()*cartVo.getNum();
        }

        Address address = addressService.getByAid(aid, uid);
        Order order = new Order();

        order.setUid(uid);
        //地址信息
        order.setRecvAddress(address.getAddress());
        order.setRecvArea(address.getAreaName());
        order.setRecvCity(address.getCityName());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvName(address.getName());

        order.setStatus(0);//未支付状态
        order.setTotalPrice(totalPrice);//支付的总价

        order.setOrderTime(new Date());
        //日志信息
        order.setCreatedTime(new Date());
        order.setCreatedUser(username);
        order.setModifiedTime(new Date());
        order.setModifiedUser(username);

        Integer rows = orderMapper.insertOrder(order);
        if (rows !=  1){
            throw new InsertExcetion("插入信息异常");
        }
        for (CartVO cartVo :
                cartLsit) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setTitle(cartVo.getTitle());
            orderItem.setPid(cartVo.getPid());
            orderItem.setNum(cartVo.getNum());
            orderItem.setPrice(cartVo.getPrice()*cartVo.getNum());
            orderItem.setImage(cartVo.getImage());
            //日志信息
            orderItem.setCreatedTime(new Date());
            orderItem.setCreatedUser(username);
            orderItem.setModifiedTime(new Date());
            orderItem.setModifiedUser(username);
            Integer integer = orderMapper.insertOrderItem(orderItem);
            if (integer != 1){
                throw new InsertExcetion("插入日志失败");
            }
        }
        return order;
    }
}
