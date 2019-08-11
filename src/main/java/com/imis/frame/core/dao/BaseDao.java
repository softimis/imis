package com.imis.frame.core.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.imis.frame.core.entity.BaseEntity;

import java.util.List;
import java.util.Map;

public interface BaseDao<T extends BaseEntity> extends BaseMapper{

    /**
     * Description: 列表查询
     * Author: zcx
     * Date: Created in 2019-08-10 23:12:42
     * Version: 1.0
     */
    public List<T> list(Map map);
}
