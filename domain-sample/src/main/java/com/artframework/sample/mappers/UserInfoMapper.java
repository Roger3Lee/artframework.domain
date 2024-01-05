package com.artframework.sample.mappers;

import mo.gov.dsaj.parent.core.mybatis.CustomBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import com.artframework.sample.entities.*;

/**
* user_info
*
* @author auto
* @version v1.0
*/
@Mapper
public interface UserInfoMapper extends CustomBaseMapper<UserInfoDO> {
}
