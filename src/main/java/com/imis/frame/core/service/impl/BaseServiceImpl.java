package com.imis.frame.core.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imis.frame.core.dao.BaseDao;
import com.imis.frame.core.entity.BaseEntity;
import com.imis.frame.core.service.BaseService;
import com.imis.frame.utils.ArrayUtils;
import com.imis.frame.utils.DateUtils;
import com.imis.frame.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<M extends BaseDao,T extends BaseEntity> extends ServiceImpl implements BaseService<T>{

    @Autowired
    public M myDao;

    /**
     * Description:  公共新增方法
     * Author: zcx
     * Date: Created in 2019-08-04 15:32:29
     * Param: [baseEntity]
     * Return: boolean
     * Version: 1.0
     */
    @Override
    public void add(T baseEntity) throws Exception{
        if(StringUtils.isEmpty(baseEntity.getId())){
            baseEntity.setId(StringUtils.getUUID());
        }
        baseEntity.setCreateDate(DateUtils.getCurrentDate());
        baseEntity.setCreateTime(DateUtils.getCurrentTime());
        baseEntity.setUpdateDate(DateUtils.getCurrentDate());
        baseEntity.setUpdateTime(DateUtils.getCurrentTime());
        baseEntity.setStatus("1");
        myDao.insert(baseEntity);
    }

    /**
     * Description: 公共物理删除方法
     * Author: zcx
     * Date: Created in 2019-08-16 20:58:54
     * Param: [id]
     * Return: boolean
     * Version: 1.0
     */
    @Override
    public void delete(Serializable id) throws Exception {
        myDao.deleteById(id);
    }

    /**
     * Description: 公共批量物理删除
     * Author: zcx
     * Date: Created in 2019-08-18 18:46:50
     * Param: [ids]
     * Return: boolean
     * Version: 1.0
     */
    @Override
    public void batchDelete(Serializable[] ids) throws Exception {
        myDao.batchDelete(ArrayUtils.arrToList(ids));
    }

    /**
     * Description: 公共逻辑删除
     * Author: zcx
     * Date: Created in 2019-08-16 21:07:20
     * Param: [baseEntity]
     * Return: boolean
     * Version: 1.0
     */
    @Override
    public void remove(Serializable id) throws Exception {
        BaseEntity baseEntity = (T)getById(id);
        baseEntity.setUpdateDate(DateUtils.getCurrentDate());
        baseEntity.setUpdateTime(DateUtils.getCurrentTime());
        baseEntity.setStatus("0");
        myDao.remove(baseEntity);
    }

    @Override
    public boolean batchRemove(Serializable[] ids) throws Exception {
        return false;
    }

    /**
     * Description: 公共修改方法
     * Author: zcx
     * Date: Created in 2019-09-02 21:53:40
     * Param: [baseEntity]
     * Return: void
     * Version: 1.0
     */
    @Override
    public void update(T baseEntity) throws Exception {
        baseEntity.setUpdateDate(DateUtils.getCurrentDate());
        baseEntity.setUpdateTime(DateUtils.getCurrentTime());
        myDao.updateById(baseEntity);
    }

    /**
     * Description:  根据ID获取一个对象
     * Author: zcx
     * Date: Created in 2019-09-07 15:23:02
     * Param: [id]
     * Return: T
     * Version: 1.0
     */
    @Override
    public T getById(String id) {
        return (T)myDao.selectById(id);
    }

    /**
     * Description: 公共集合查询方法
     * Author: zcx
     * Date: Created in 2019-08-06 22:04:27
     * Param: [map]
     * Return: java.util.List<T>
     * Version: 1.0
     */
    @Override
    public List<T> list(Map map) {
        return myDao.selectByMap(map);
    }

    /**
     * Description: 公共分页查询
     * Author: zcx
     * Date: Created in 2019-09-08 14:52:31
     * Param: [map]
     * Return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<T>
     * Version: 1.0
     */
    @Override
    public Page<T> pageQuery(Map map) {
        Page<T> page = new Page<>();
        page.setCurrent(Long.valueOf(String.valueOf(map.get("currentPage"))));
        page.setSize(Long.valueOf(String.valueOf(map.get("pageSize"))));
        page.setRecords(myDao.pageQuery(page,map));
        return page;
    }
}
