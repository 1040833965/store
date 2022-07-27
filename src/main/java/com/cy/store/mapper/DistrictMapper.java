package com.cy.store.mapper;

import com.cy.store.entity.District;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/22 23:10
 * @Description: 省市区的持久层接口
 */
@SuppressWarnings({"all"})
@Mapper
public interface DistrictMapper {

    /**
     * 根据用户的父代号查询区域信息
     * @param parent 父代号
     * @return 某个父区域下的所有区域列表
     */
    List<District> findByParent(String parent);

    /**
     * 通过当前code查询对应名称
     * @param code
     * @return
     */
    String findNameByCode(String code);
}
