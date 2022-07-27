package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;

import java.util.Date;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/21 23:49
 * @Description: 收货地址的接口类
 */
@SuppressWarnings({"all"})
public interface IAddressService {

    void addNewAddress(Address address, Integer uid,String username);

    List<Address> getByUid(Integer uid);

    /**
     * 修改某个用户的某条收货地址数据为默认收货地址
     * @param aid aid收货地址的
     * @param uid 用户的
     * @param modifiedUser 修改者的
     */
    void setDefault(Integer aid, Integer uid , String modifiedUser);

    /**
     *
     *根据收货地址的aid删除
     * @param aid 当前收货地址的aid
     * @param uid 当前用户的uid
     * @param username 当前在线用户名称
     */
    void delectAddress(Integer aid,Integer uid,String username);

    /**
     * 根据aid查询地址
     * @param aid
     * @return
     */
    Address getByAid(Integer aid,Integer uid);

}
