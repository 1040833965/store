package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("addresses")
@RestController
public class AddressController extends BaseController{
    @Autowired
    private IAddressService addressService;


    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(HttpSession session, Address address){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(address,uid,username);
        return new JsonResult<>(OK);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<Address>> getAddressByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> byUid = addressService.getByUid(uid);
        return new JsonResult<>(OK,byUid);
    }
    //按照RestFul风格编写
    @RequestMapping("set_default/{aid}")
    public JsonResult<Void> setDefault(HttpSession session,@PathVariable("aid") Integer aid){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.setDefault(aid,uid,username);
        return new JsonResult<>(OK);
    }

    @RequestMapping("delete_address/{aid}")
    public  JsonResult<Void> deleteAddress(HttpSession session,@PathVariable("aid")Integer aid){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.delectAddress(aid,uid,username);
        return new JsonResult<>(OK);
    }

}
