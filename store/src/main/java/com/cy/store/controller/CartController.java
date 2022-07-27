package com.cy.store.controller;

import com.cy.store.entity.BaseEntity;
import com.cy.store.service.ICartService;
import com.cy.store.service.impl.CartServiceImpl;
import com.cy.store.utils.JsonResult;
import com.cy.store.vo.CartVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/25 17:49
 * @Description:
 */
@SuppressWarnings({"all"})
@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
    @Autowired
    ICartService cartService;


    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(@RequestParam("pid") Integer pid, @RequestParam("num") Integer numb, HttpSession session){
        cartService.addToCart(getUidFromSession(session),
                pid,
                numb,
                getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
    @RequestMapping({"","/"})
    public JsonResult<List<CartVO>> showcart(HttpSession session){
        List<CartVO> data = cartService.showCart(getUidFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(HttpSession session,@PathVariable("cid") Integer cid){
        Integer data = cartService.addNumByCid(cid, getUsernameFromSession(session), getUidFromSession(session));
        return new JsonResult<>(OK,data);
    }
    @RequestMapping("{cid}/num/cut")
    public JsonResult<Integer> cutNum(HttpSession session,@PathVariable("cid") Integer cid){
        Integer data = cartService.cutNumByCid(cid, getUsernameFromSession(session), getUidFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("list")
    public JsonResult<List<CartVO>> showOrder(Integer[] cids,HttpSession session){
        List<CartVO> data = cartService.showOrder(cids, getUidFromSession(session));
        return new JsonResult<>(OK,data);
    }
}
