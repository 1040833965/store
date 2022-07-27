package com.cy.store.service;

import com.cy.store.entity.District;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/22 23:44
 * @Description:省市区列表的业务层接口
 */
@SuppressWarnings({"all"})

public interface IDistrictService {
    /**
     * 根据父区域的代号查询区域信息
     * @param parent 父区域代号
     * @return 多个区域信息
     */
    List<District> getByParent(String parent);

    /**
     * 根据当前的code查询区域name值
     * @param code当前的code
     * @return name
     */
    String getNameByCode(String code);
}
