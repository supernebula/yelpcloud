package com.evol.service.impl;

import com.evol.domain.model.RolePermission;
import com.evol.mapper.RolePermissionMapper;
import com.evol.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限关联表 服务实现类
 * </p>
 *
 * @author sn
 * @since 2020-02-22
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

}
