package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/25 15:17
 * @Description:  购物车持久层接口
 */
@SuppressWarnings({"all"})
public interface CartMapper {


    /**
     * 加入购物车数据
     * @param cart 购物车数据
     * @return 受影响行数
     */
    Integer insert(Cart cart);

    /**
     * 更新购物车某件商品数量
     * @param Cid 购物车id
     * @param num 跟新数量
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return受影响行数
     */
    Integer updateNumByCid(@Param("cid") Integer cid, @Param("num") Integer num,
                           @Param("modifiedUser") String modifiedUser,@Param("modifiedTime") Date modifiedTime);

    /**
     * 根据用户的id和商品id来查询购物车中的数据
     * @param uid 用户id
     * @param pid 商品id
     * @return 购物车数据
     */
    Cart findByUidAndPid(@Param("uid") Integer uid,
                         @Param("pid") Integer pid);

    /**
     * 根据用户uid查询其购物车数据
     * @param uid 用户uid
     * @return 购物车数据
     */
    List<CartVO> findVOByUid(Integer uid);

    /**
     * 根据商品cid减少num
     * @param cid 商品id
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return 受影响行数
     */
    Integer cutNumByCid(@Param("cid") Integer cid,
                        @Param("modifiedUser") String modifiedUser,
                        @Param("modifiedTime") Date modifiedTime,
                        @Param("uid")Integer uid);

    /**
     * 根据商品cid增加num
     * @param cid 商品id
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return 受影响行数
     */
    Integer addNumByCid(@Param("cid") Integer cid, @Param("modifiedUser") String modifiedUser,
                        @Param("modifiedTime") Date modifiedTime,@Param("uid")Integer uid);

    /**
     * 根据cid返回当前产品数量
     * @param cid
     * @Param uid 用户uid
     * @return
     */
    Integer findNumByCid(@Param("cid") Integer cid,@Param("uid")Integer uid);

    /**
     * 通过cid查询CartOV
     * @param cid
     * @return
     */
    List<CartVO> findVOByCids(Integer[] cids);
}
