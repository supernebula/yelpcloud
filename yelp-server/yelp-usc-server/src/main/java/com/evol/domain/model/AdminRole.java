package com.evol.domain.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author sn
 * @since 2020-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdminRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 用户编号
     */
    private String adminId;

    /**
     * 角色编号
     */
    private String roleId;


}
