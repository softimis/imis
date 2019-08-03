package com.imis.frame.core.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.imis.frame.core.entity.BaseEntity;

public interface BaseDao<T extends BaseEntity> extends BaseMapper{
}
