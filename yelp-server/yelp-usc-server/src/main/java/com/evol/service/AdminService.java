package com.evol.service;

import com.evol.domain.model.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sn
 * @since 2020-02-22
 */
public interface AdminService extends IService<Admin> {

    Admin getAdminByPwd(String username, String password);

}
