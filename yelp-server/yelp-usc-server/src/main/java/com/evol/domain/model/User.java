package com.evol.domain.model;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author sn
 * @since 2020-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 评论数量
     */
    private Integer reviewCount;

    /**
     * 注册时间
     */
    private LocalDateTime yelpingSince;

    /**
     * 好友数量
     */
    private Integer useful;

    /**
     * 有趣投票数量
     */
    private Integer funny;

    /**
     * 酷投票数量
     */
    private Integer cool;

    /**
     * 粉丝数量
     */
    private Integer fans;

    /**
     * 平均评分
     */
    private Float averageStars;

    private Integer complimentHot;

    private Integer complimentMore;

    private Integer complimentProfile;

    private Integer complimentCute;

    private Integer complimentList;

    private Integer complimentNote;

    private Integer complimentPlain;

    private Integer complimentCool;

    private Integer complimentFunny;

    private Integer complimentWriter;

    private Integer complimentPhotos;


}
