package com.cy.store.controller;

import com.cy.store.entity.Order;
import com.cy.store.service.IOrderService;
import com.cy.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/28 1:46
 * @Description:
 */
@SuppressWarnings({"all"})
@RestController
@RequestMapping("orders")
public class OrderController extends BaseController{
    @Autowired
    private IOrderService orderService;


    @RequestMapping("create")
    public JsonResult<Order> create(HttpSession session,Integer aid,Integer[] cids){
        Order data = orderService.creatOrder(aid,
                getUidFromSession(session),
                getUsernameFromSession(session),
                cids);
        return new JsonResult<>(OK,data);
    }

}
