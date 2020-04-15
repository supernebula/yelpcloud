package com.evol.service.impl;

import com.evol.domain.model.Business;
import com.evol.domain.model.BusinessExample;
import com.evol.domain.query.BusinessSearchParam;
import com.evol.mapper.BusinessMapper;
import com.evol.service.BusinessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;


    @Override
    public PageInfo<Business> Search(BusinessSearchParam param) {
        if(param == null)
            throw new NullPointerException("param");

        PageHelper.startPage(param.getPage(), param.getPageSize());
        BusinessExample example = new BusinessExample();

        BusinessExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(param.getName())) {criteria.andNameLike(param.getName());}
        if(!StringUtils.isEmpty(param.getCity())) {criteria.andCityLike(param.getCity());}
        if(!StringUtils.isEmpty(param.getState())) {criteria.andStateEqualTo(param.getState());}
        if(!StringUtils.isEmpty(param.getPostCode())) {criteria.andPostalCodeEqualTo(param.getPostCode());}

        if(param.getIsOpen() != null) {criteria.andIsOpenEqualTo((byte)(param.getIsOpen().booleanValue() ? 1 : 0));}

        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Business> list = businessMapper.selectByExample(example);
        PageInfo<Business> pageInfo = new PageInfo<Business>(list);
        return pageInfo;
    }

    @Override
    public List<Business> getBusinessList(int offset, int rows) {

        BusinessExample example = new BusinessExample();
        BusinessExample.Criteria criteria = example.createCriteria();
        PageHelper.startPage(offset, rows);
        List<Business> list = businessMapper.selectByExample(example);
        PageInfo<Business> pageInfo = new PageInfo<Business>(list);
        return pageInfo.getList();
    }

    @Override
    public Business getBusiness(String id) {
        Business item = businessMapper.selectByPrimaryKey(id);
        return item;
    }
}
