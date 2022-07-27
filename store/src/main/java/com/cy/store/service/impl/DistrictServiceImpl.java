package com.cy.store.service.impl;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/22 23:47
 * @Description:省市区区域获取接口的实现类
 */
@SuppressWarnings({"all"})
@Service
public class DistrictServiceImpl implements IDistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> byParent = districtMapper.findByParent(parent);
        /**
         * 进行网络数据传输时，为了尽量避免无效数据的传递，可以将无效数据设置为null;
         * 可以节省流量，提升效率
         *
         */
        for (District dist:byParent
             ) {
            dist.setId(null);
            dist.setParent(null);
        }
        return byParent;
    }

    @Override
    public String getNameByCode(String code) {
        String name = districtMapper.findNameByCode(code);
        return name;
    }


}
