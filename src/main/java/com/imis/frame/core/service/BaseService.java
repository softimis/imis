package com.imis.frame.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.imis.frame.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseEntity> extends IService {
    //新增
    public boolean add(T baseEntity) throws Exception;

    //物理删除
    public boolean delete(Serializable[] ids) throws Exception;

    //逻辑删除
    public boolean remove(Serializable[] ids) throws Exception;

    //更新
    public boolean update(T BaseEntity) throws Exception;

    //根据ID获取一个对象
    public T getById(String id);

    //获取列表
    public List<T> list(Map map);
}
