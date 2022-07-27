package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import com.cy.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/22 15:54
 * @Description: 处理用户的收货地址的请求和响应
 */
@SuppressWarnings({"all"})
@RequestMapping("districts")
@RestController
public class DistirictController extends BaseController{
    @Autowired
    private IDistrictService districtService;


    @RequestMapping({"","/"})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK,data);
    }

}
