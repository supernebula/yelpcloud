package com.evol.controller;

import com.evol.ApiResult;
import com.evol.PageResult;
import com.evol.domain.dto.BusinessDTO;
import com.evol.domain.model.Business;
import com.evol.domain.query.BusinessSearchParam;
import com.evol.service.BusinessService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@RestController
@RequestMapping("/api/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    private <T, K extends Object> List<K> BeanCopierList(BeanCopier beanCopier, List<T> source, Class<K> tgaetClazz) {
        List<K> target = new ArrayList<>();
        for (T item : source) {

            K dto = null;
            try {
                dto = tgaetClazz.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            ;

            beanCopier.copy(item, dto, null);
            target.add(dto);
        }
        return target;
    }


    @GetMapping("search")
    public ApiResult<PageResult<BusinessDTO>> search(BusinessSearchParam param) {
        PageInfo<Business> pageInfo = businessService.Search(param);
        BeanCopier beanCopier = BeanCopier.create(Business.class, BusinessDTO.class, false);
        List<BusinessDTO> businessDTOs = BeanCopierList(beanCopier, pageInfo.getList(), BusinessDTO.class);

        PageResult<BusinessDTO> result = new PageResult<>(businessDTOs, pageInfo.getPages(), pageInfo.getPageSize(), pageInfo.getTotal() / pageInfo.getPageSize(), pageInfo.getTotal());
        return ApiResult.success(result);
    }

    @GetMapping("detail/{id}")
    public ApiResult<BusinessDTO> detail(@PathVariable String id) {
        if (StringUtils.isEmpty(id)) {
            return ApiResult.paramError();
        }
        Business item = businessService.getBusiness(id);
        BeanCopier beanCopier = BeanCopier.create(Business.class, BusinessDTO.class, false);
        BusinessDTO dto = new BusinessDTO();
                beanCopier.copy(item, dto, null);
        return ApiResult.success(dto);

    }

    @PostMapping("create")
    public void createPost() {

    }

    @PostMapping("edit")
    public void editPost() {

    }

    @DeleteMapping("delete")
    public void delete() {

    }
}