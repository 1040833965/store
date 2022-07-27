package com.cy.store.service.impl;

import com.cy.store.contant.AddressContant;
import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/21 23:50
 * @Description:
 */
@SuppressWarnings({"all"})
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;
    //在添加用户的收货地址的业务层依赖于IDistrictSerivce业务层层对应的接口
    @Autowired
    private IDistrictService districtService;

    /**最大地址添加数*/
    private int addMax = AddressContant.ADD_MAX;

    @Override
    public void addNewAddress(Address address, Integer uid, String username) {
        Integer count = addressMapper.countByUid(uid);
        if (count >= addMax){
            throw new AddressCountLimitException("地址数已达最大数据");
        }

        //对Address对象数据进行补齐：省市区
        String provincNmae = districtService.getNameByCode(address.getProvinceCode());
        String cityNmae = districtService.getNameByCode(address.getCityCode());
        String areaNmae = districtService.getNameByCode(address.getAreaCode());
        address.setProvinceName(provincNmae);
        address.setCityName(cityNmae);
        address.setAreaName(areaNmae);

        //uid、isDelete、
        address.setUid(uid);
        Integer isDefault = count == 0?1:0;//1表示默认，0表示非默认
        address.setIsDefault(isDefault);
        //补齐四项日志
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());
        address.setModifiedUser(username);

        //插入收货地址的方法
        Integer rows = addressMapper.insert(address);
        if (rows!=1){
            throw new InsertExcetion("插入用户的收货地址产生未知异常");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for (Address address: list
             ) {
//            address.setAid(null);
//            address.setUid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setZip(null);
            address.setCreatedTime(null);
            address.setCreatedUser(null);
            address.setModifiedUser(null);
            address.setModifiedTime(null);

        }
        return list;
    }

    @Override
    public void setDefault(Integer aid, Integer uid, String modifiedUser) {
        Address address = addressMapper.findByAid(aid);
        if (address == null){
            throw new AddressNotFoundException("数据未查询到");
        }
        //检测当前收货地址数据归属
        if (!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法访问");
        }
        //先将所有的收货地址设置为非默认
        Integer rows = addressMapper.updateNonDefault(uid);
        if (rows < 0){
            throw new UpdateExcetion("跟新时发生未知异常");
        }
        Integer row =addressMapper.updateDefaultByAid(aid,modifiedUser,new Date());
        if (row != 1){
            throw new UpdateExcetion("更新时发生未知异常");
        }

    }

    @Override
    public void delectAddress(Integer aid ,Integer uid,String username) {
        //先根据aid查询数据
        Address address = addressMapper.findByAid(aid);
        if (address == null){
            throw new AddressNotFoundException("数据不存在");
        }
        //检测当前收货地址数据归属
        if (address.getUid()!=uid){
            throw new AccessDeniedException("非法访问");
        }
        //删除地址
        Integer rows = addressMapper.deleteAddressByAid(aid);
        if (rows != 1){
            throw new DeleteException("删除时发生未知异常");
        }
        //查询到除删除的数据外最近的地址数据
        if (address.getIsDefault()==1){
            Address result = addressMapper.findLastModified(uid);
            if (result == null){
                //若为空则不执行后续操作
                return;
            }
            //将最近的一条设置为默认地址
            Integer integer = addressMapper.updateDefaultByAid(result.getAid(), username, new Date());
            if (integer != 1){
                throw new UpdateExcetion("更新数据时产生未知异常");
            }
        }

    }


}
