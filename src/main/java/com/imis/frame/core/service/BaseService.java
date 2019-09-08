package com.imis.frame.core.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imis.frame.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseEntity> extends IService {
    //新增
    public void add(T baseEntity) throws Exception;

    //物理删除
    public void delete(Serializable id) throws Exception;

    //批量物理删除
    public void batchDelete(Serializable[] ids) throws Exception;

    //逻辑删除
    public void remove(Serializable id) throws Exception;

    //批量逻辑删除
    public boolean batchRemove(Serializable[] ids) throws Exception;

    //更新
    public void update(T BaseEntity) throws Exception;

    //根据ID获取一个对象
    public T getById(String id);

    //获取集合
    public List<T> list(Map map);

    //分页查询
    public Page<T> pageQuery(Map map);

}
