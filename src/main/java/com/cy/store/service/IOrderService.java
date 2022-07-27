package com.cy.store.service;

import com.cy.store.entity.Order;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/28 0:09
 * @Description:
 */
@SuppressWarnings({"all"})
public interface IOrderService {


    /**
     *
     * @param aid
     * @param uid
     * @param username
     * @param cid
     * @return
     */
    Order creatOrder(Integer aid,Integer uid,String username,Integer[] cids);
}
