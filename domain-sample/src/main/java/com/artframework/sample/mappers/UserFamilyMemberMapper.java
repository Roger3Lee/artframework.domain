package com.artframework.sample.mappers;

import mo.gov.dsaj.parent.core.mybatis.CustomBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import com.artframework.sample.entities.*;

/**
* user_family_member
*
* @author auto
* @version v1.0
*/
@Mapper
public interface UserFamilyMemberMapper extends CustomBaseMapper<UserFamilyMemberDO> {
}
