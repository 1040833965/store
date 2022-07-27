package com.cy.store.mapper;

import com.cy.store.entity.Product;

import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/24 20:11
 * @Description:
 */
@SuppressWarnings({"all"})
public interface ProductMapper {

    /**
     * 查询热卖商品
     * @return
     */
    List<Product> findHotList();

    /**
     * 根据返回的id查询具体的商品信息
     * @param id 商品id
     * @return 商品信息
     */
    Product findById(Integer id);

}
