package com.cy.store.service;

import com.cy.store.entity.Product;

import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/24 20:34
 * @Description:  product业务层接口
 */
@SuppressWarnings({"all"})
public interface IProductService {
    /**
     * 业务层查询热门商品抽象方法
     * @return
     */
    List<Product> findHotList();

    /**
     * 查询商品具体信息
     * @return
     */
    Product findById(Integer id);
}
