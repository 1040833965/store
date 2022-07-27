package com.cy.store.service.impl;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ICartService;
import com.cy.store.service.ex.InsertExcetion;
import com.cy.store.service.ex.ProductNotFoundException;
import com.cy.store.service.ex.UpdateExcetion;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/25 16:31
 * @Description:购物车的业务层接口实现类
 */
@SuppressWarnings({"all"})
@Service
public class CartServiceImpl implements ICartService {
    /**购物车的业务层依赖于购物车的持久层和商品的持久层*/
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer numb, String username) {
        //查询当前要添加的购物车是否在表中已存在‘
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        if (result == null){
            Product byId = productMapper.findById(pid);
            //商品不存在过加入
            Cart cart = new Cart();
            cart.setCreatedUser(username);
            cart.setCreatedTime(new Date());
            cart.setModifiedTime(new Date());
            cart.setModifiedUser(username);
            cart.setPid(pid);
            cart.setUid(uid);
            cart.setNum(numb);
            cart.setPrice(byId.getPrice());
            Integer rows = cartMapper.insert(cart);
            if (rows != 1){
                throw new InsertExcetion("加入购物车失败");
            }
        }else {
            //表示当前商品在购物车中已存在，则更新这条数据的num
            Integer rows = cartMapper.updateNumByCid(result.getCid(), numb, username, new Date());
            if (rows != 1){
                throw new UpdateExcetion("跟新数据失败");
            }
        }
    }

    @Override
    public List<CartVO> showCart(Integer uid) {
        List<CartVO> voByUid = cartMapper.findVOByUid(uid);
        return voByUid;
    }

    @Override
    public Integer addNumByCid(Integer cid ,String username,Integer uid) {
        Integer rows = cartMapper.addNumByCid(cid,username,new Date(),uid);
        if (rows != 1){
            throw new UpdateExcetion("添加商品数量失败");
        }
        Integer num = cartMapper.findNumByCid(cid,uid);
        return num;
    }

    @Override
    public Integer cutNumByCid(Integer cid,String username ,Integer uid) {
        Integer rows = cartMapper.cutNumByCid(cid,username,new Date(),uid);
        if (rows != 1){
            throw new UpdateExcetion("减少商品失败");
        }
        Integer num = cartMapper.findNumByCid(cid,uid);
        return num;
    }

    @Override
    public List<CartVO> showOrder(Integer[] cids, Integer uid) {
        List<CartVO> result = cartMapper.findVOByCids(cids);
        for (CartVO cartvo :
                result) {
            if (!cartvo.getUid().equals(uid)){
            //当前的数据不属于当前的用户,从集合中移除该元素
                result.remove(cartvo);
            }

        }
        return result;
    }


}
