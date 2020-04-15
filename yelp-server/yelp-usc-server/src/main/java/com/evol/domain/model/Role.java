package com.evol.domain.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author sn
 * @since 2020-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 角色标识 程序中判断使用,如"admin",这个是唯一的:
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Integer available;


}
