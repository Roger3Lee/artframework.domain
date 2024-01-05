package com.artframework.sample.domains.user.repository;

import com.artframework.sample.domains.user.domain.*;
import com.artframework.sample.entities.*;
import mo.gov.dsaj.domain.core.repository.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface UserAddressRepository extends BaseRepository<UserDomain.UserAddressDomain, UserAddressDO> {
}
