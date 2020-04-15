package com.evol.service;

import com.evol.domain.model.Business;
import com.evol.domain.query.BusinessSearchParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BusinessService {
    /**
     * 搜索商家
     * @param param 搜索条件
     * @return
     */
    PageInfo<Business> Search(BusinessSearchParam param);


    /**
     * 从指定offset位置开始，获取指定数量的商家记录
     * @param offset
     * @param rows
     * @return
     */
    List<Business> getBusinessList(int offset, int rows);

    /**
     * 根据id获取单条商家记录
     * @param id
     * @return
     */
    Business getBusiness(String id);
}
