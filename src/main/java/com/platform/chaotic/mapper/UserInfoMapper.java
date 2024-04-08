package com.platform.chaotic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.platform.chaotic.model.po.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/8 16:18
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoDO> {
}
