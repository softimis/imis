package com.imis.frame.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.imis.frame.core.dao.BaseDao;
import com.imis.frame.core.entity.BaseEntity;

public abstract class BaseServiceImpl<M extends BaseDao,T extends BaseEntity> extends ServiceImpl {
}
