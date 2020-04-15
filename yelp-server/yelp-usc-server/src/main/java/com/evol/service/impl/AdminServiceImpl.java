package com.evol.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.evol.domain.model.Admin;
import com.evol.mapper.AdminMapper;
import com.evol.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sn
 * @since 2020-02-22
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public Admin getAdminByPwd(String username, String password) {
        Admin admin = getOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getUsername, username));
        if(StringUtils.isEmpty(password)) { return null; }
        if(!password.equals(admin.getPassword())) { return null; }
        return admin;
    }
}
