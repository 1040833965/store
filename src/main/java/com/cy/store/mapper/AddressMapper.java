package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/21 22:53
 * @Description:收货地址持久层的接口
 */
@SuppressWarnings({"all"})
public interface AddressMapper {
    /**
     * 插入用户的收货地址
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    Integer insert(Address address);

    /**
     * 根据用户的id统计收货地址数量
     * @param uid 用户的id
     * @return 当前用户的收货地址总量
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户uid查询地址信息
     * @param uid用户udi
     * @return List集合中的district对象数据
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据aid查询收货地址数据
     * @param aid 收货地址id
     * @return 收货地址数据，没找到返回null
     */
    Address findByAid(Integer aid);

    /**
     * 根据用户的uid值来修改用户的收货地址设置为非默认
     * @param uid 用户的uid
     * @return 受影响的行数
     */
    Integer updateNonDefault(Integer uid);

    /**
     *通过aid修改收货地址为默认
     * @param aid 当前地址的aid
     * @return 受影响的行数
     */
    Integer updateDefaultByAid(@Param("aid") Integer aid,@Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") Date modifiedTime);

    /**
     * 通过aid删除收货地址
     * @param aid 当前地址的aid
     * @return 受影响的行数
     */
    Integer deleteAddressByAid(Integer aid);

    /**
     * 根据用户Uid查询用户最后一次修改的地址
     * @param uid 用户uid
     * @return 最后一次修改的地址信息
     */
    Address findLastModified(Integer uid);
}
