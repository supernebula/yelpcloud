package com.evol.service.impl;

import com.evol.domain.model.Friend;
import com.evol.mapper.FriendMapper;
import com.evol.service.FriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户朋友表 服务实现类
 * </p>
 *
 * @author sn
 * @since 2020-02-22
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

}
