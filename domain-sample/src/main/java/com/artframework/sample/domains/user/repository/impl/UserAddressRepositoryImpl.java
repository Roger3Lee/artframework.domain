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
public class UserAddressRepositoryImpl extends BaseRepositoryImpl<UserDomain.UserAddressDomain,UserAddressDO>  implements UserAddressRepository {

    @Override
    public List<UserAddressDO> convert2DO(List<UserDomain.UserAddressDomain> list) {
        return UserConvertor.INSTANCE.convert2UserAddressDO(list);
    }

    @Override
    public List<UserDomain.UserAddressDomain> convert2DTO(List<UserAddressDO> list) {
        return UserConvertor.INSTANCE.convert2UserAddressDTO(list);
    }

    @Override
    public SFunction<UserDomain.UserAddressDomain, Serializable> keyLambda() {
        return UserLambdaExp.userAddressKeyLambda;
    }

    @Override
    public Class<UserAddressDO> getDOClass() {
        return UserAddressDO.class;
    }
}
