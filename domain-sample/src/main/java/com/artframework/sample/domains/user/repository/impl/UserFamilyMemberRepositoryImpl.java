package com.artframework.sample.domains.user.repository.impl;

import com.artframework.sample.domains.user.convertor.*;
import com.artframework.sample.domains.user.lambdaexp.*;
import com.artframework.sample.domains.user.domain.*;
import com.artframework.sample.domains.user.repository.*;
import com.artframework.sample.entities.*;
import mo.gov.dsaj.domain.core.repository.impl.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserFamilyMemberRepositoryImpl extends BaseRepositoryImpl<UserDomain.UserFamilyMemberDomain,UserFamilyMemberDO>  implements UserFamilyMemberRepository {

    @Override
    public List<UserFamilyMemberDO> convert2DO(List<UserDomain.UserFamilyMemberDomain> list) {
        return UserConvertor.INSTANCE.convert2UserFamilyMemberDO(list);
    }

    @Override
    public List<UserDomain.UserFamilyMemberDomain> convert2DTO(List<UserFamilyMemberDO> list) {
        return UserConvertor.INSTANCE.convert2UserFamilyMemberDTO(list);
    }

    @Override
    public SFunction<UserDomain.UserFamilyMemberDomain, Serializable> keyLambda() {
        return UserLambdaExp.userFamilyMemberKeyLambda;
    }

    @Override
    public Class<UserFamilyMemberDO> getDOClass() {
        return UserFamilyMemberDO.class;
    }
}
