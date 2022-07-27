package com.cy.store.controller;

import com.cy.store.entity.BaseEntity;
import com.cy.store.entity.Product;
import com.cy.store.service.IProductService;
import com.cy.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/24 20:39
 * @Description:
 */
@SuppressWarnings({"all"})
@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    @RequestMapping("show_hot")
    public JsonResult<List<Product>> findHotList(){
        List<Product> data = productService.findHotList();
        //将不必要的信息设空，减少不必要的信息传输
        for (Product pro:
            data ) {
            pro.setCreatedTime(null);
            pro.setModifiedUser(null);
            pro.setCreatedUser(null);
            pro.setModifiedTime(null);
        }
        return new JsonResult<>(OK,data);
    }


    @GetMapping("show_product/{id}")
    public JsonResult<Product> findProduct(@PathVariable("id") Integer id){
        Product data = productService.findById(id);
        data.setModifiedTime(null);
        data.setCreatedUser(null);
        data.setModifiedUser(null);
        data.setCreatedTime(null);
        return new JsonResult<>(OK,data);
    }
}
