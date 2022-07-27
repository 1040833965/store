package com.cy.store.service;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;

import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/25 16:31
 * @Description:购物车业务层接口
 */
@SuppressWarnings({"all"})
public interface ICartService {
    /**
     *将商品加入购物车中
     * @param uid 用户id
     * @param pid 商品id
     * @param numb 加入数量
     * @param username 修改名
     */
    void addToCart(Integer uid,Integer pid,Integer numb,String username);

    /**
     * 根据不同用户展示购物车商品数据
     * @param uid 用户uid
     * @return 购物车数据
     */
    List<CartVO> showCart(Integer uid);

    /**
     /**
     * 根据产品cid修改num
     * @param cid产品cid
     *
     */
    Integer addNumByCid(Integer cid,String username,Integer uid);

    /**
     * 根据产品cid修改num
     * @param username用户名
     * @param cid产品cid
     */
    Integer cutNumByCid(Integer cid,String username,Integer uid);


    List<CartVO> showOrder(Integer[] cids,Integer uid);
}
