package com.imis.frame.core.service.impl;

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
    public boolean add(T baseEntity) throws Exception{
        if(StringUtils.isEmpty(baseEntity.getId())){
            baseEntity.setId(StringUtils.getUUID());
        }
        baseEntity.setCreateDate(DateUtils.getCurrentDate());
        baseEntity.setCreateTime(DateUtils.getCurrentTime());
        baseEntity.setUpdateDate(DateUtils.getCurrentDate());
        baseEntity.setUpdateTime(DateUtils.getCurrentTime());
        baseEntity.setStatus("1");
        baseMapper.insert(baseEntity);
        return true;
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
    public boolean delete(Serializable id) throws Exception {
        boolean isSuccess = true;
        int i = baseMapper.deleteById(id);
        if(i!=1){
            isSuccess = false;
        }
//        try {
//            int i = baseMapper.deleteById(id);
//            if(i!=1){
//                isSuccess = false;
//            }
////            isSuccess = deleteById(id);
//        }catch (Exception e){
//            isSuccess = false;
//            e.printStackTrace();
//        }
        return isSuccess;
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
    public boolean batchDelete(Serializable[] ids) throws Exception {
        boolean isSuccess = true;
        try{
            isSuccess = myDao.batchDelete(ArrayUtils.arrToList(ids));
        }catch (Exception e){
            isSuccess = false;
            e.printStackTrace();
        }
        return isSuccess;
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
    public boolean remove(T baseEntity) throws Exception {
        return myDao.remove(baseEntity);
    }

    @Override
    public boolean batchRemove(Serializable[] ids) throws Exception {
        return false;
    }

    @Override
    public boolean update(T baseEntity) throws Exception {
        return false;
    }

    @Override
    public T getById(String id) {
//        selectById(id);
        return null;
    }

    /**
     * Description: 公共列表查询方法
     * Author: zcx
     * Date: Created in 2019-08-06 22:04:27
     * Param: [map]
     * Return: java.util.List<T>
     * Version: 1.0
     */
    @Override
    public List<T> list(Map map) {
        //return selectByMap(map);
        return myDao.list(map);
    }
}
