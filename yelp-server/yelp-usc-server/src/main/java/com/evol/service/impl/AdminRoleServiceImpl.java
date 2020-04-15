package com.evol.service.impl;

import com.evol.domain.model.AdminRole;
import com.evol.mapper.AdminRoleMapper;
import com.evol.service.AdminRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author sn
 * @since 2020-02-22
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {

}
