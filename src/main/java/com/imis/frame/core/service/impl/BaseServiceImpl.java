package com.imis.frame.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.imis.frame.core.dao.BaseDao;
import com.imis.frame.core.entity.BaseEntity;
import com.imis.frame.core.service.BaseService;
import com.imis.frame.utils.DateUtils;
import com.imis.frame.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<M extends BaseDao,T extends BaseEntity> extends ServiceImpl implements BaseService<T>{

    //public abstract BaseDao<T> getDao();
    @Autowired
    public M myDao;
    /**
     * Description: 公共新增方法
     * Author: zcx
     * Date: Created in 2019-08-04 15:32:29
     * Version: 1.0
     */
    @Override
    public boolean add(T baseEntity) throws Exception{
        if(StringUtils.isEmpty(baseEntity.getId())){
            baseEntity.setId(StringUtils.getUUID());
        }
        baseEntity.setCreateDate(DateUtils.getCurrentDate());
        baseEntity.setCreateTime(DateUtils.getCurrentTime());
        baseEntity.setUpdateDate(DateUtils.getCurrentDate());
        baseEntity.setUpdateTime(DateUtils.getCurrentTime());
        baseEntity.setStatus("1");
        return insert(baseEntity);
    }

    @Override
    public boolean delete(Serializable[] ids) throws Exception {
        return false;
    }

    @Override
    public boolean remove(Serializable[] ids) throws Exception {
        return false;
    }

    @Override
    public boolean update(T baseEntity) throws Exception {
        return false;
    }

    @Override
    public T getById(String id) {
        return null;
    }

    /**
     * Description:  公共列表查询方法
     * Author: zcx
     * Date: Created in 2019-08-06 22:04:27
     * Version: 1.0
     */
    @Override
    public List<T> list(Map map) {
        //return selectByMap(map);
        return myDao.list(map);
    }
}
