package com.cy.store.service.impl;

import com.cy.store.entity.Product;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.IProductService;
import com.cy.store.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/24 20:36
 * @Description:
 */
@SuppressWarnings({"all"})
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> findHotList() {
        List<Product> hotList = productMapper.findHotList();
        return hotList;
    }

    @Override
    public Product findById(Integer id) {
        Product product = productMapper.findById(id);
        if (product==null){
            throw new ProductNotFoundException("无法找到该商品");
        }
        return product;
    }
}
