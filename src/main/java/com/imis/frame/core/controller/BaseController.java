package com.imis.frame.core.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imis.frame.core.entity.BaseEntity;
import com.imis.frame.core.service.BaseService;
import com.imis.frame.utils.OperateInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseController<T extends BaseEntity, S extends BaseService> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final long serialVersionUID = 1L;

    @Autowired
    public S myService;

    /**
     * Description: 公共新增方法
     * Author: zcx
     * Date: Created in 2019-08-04 22:41:06
     * Param: [BaseEntity]
     * Return: com.imis.frame.utils.OperateInfo
     * Version: 1.0
     */
    @RequestMapping(value = "/add")
    public OperateInfo add(@ModelAttribute T baseEntity) {
        OperateInfo operateInfo = new OperateInfo();
        try {
            myService.add(baseEntity);
            operateInfo.setOperateSuccess(true);
            operateInfo.setOperateMessage("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            operateInfo.setOperateSuccess(false);
            operateInfo.setOperateMessage("添加失败");
            operateInfo.setErrorInfo(e.getMessage());
        }
        return operateInfo;
    }

    /**
     * Description: 公共物理删除方法
     * Author: zcx
     * Date: Created in 2019-08-18 17:42:27
     * Param: [id]
     * Return: com.imis.frame.utils.OperateInfo
     * Version: 1.0
     */
    @RequestMapping(value = "/delete")
    public OperateInfo delete(String id){
        OperateInfo operateInfo = new OperateInfo();
        try {
            myService.delete(id);
            operateInfo.setOperateSuccess(true);
            operateInfo.setOperateMessage("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            operateInfo.setOperateSuccess(false);
            operateInfo.setOperateMessage("删除失败");
            operateInfo.setErrorInfo(e.getMessage());
        }
        return operateInfo;
    }

    /**
     * Description: 公共批量物理删除方法
     * Author: zcx
     * Date: Created in 2019-08-16 21:27:27
     * Param: [ids]
     * Return: com.imis.frame.utils.OperateInfo
     * Version: 1.0
     */
    @RequestMapping(value = "/batchDelete")
    public OperateInfo batchDelete(@RequestBody JSONObject ids){
        JSONArray jsonArray = ids.getJSONArray("ids");
        OperateInfo operateInfo = new OperateInfo();
        if(jsonArray.size()!=0){
            try {
                Serializable[] arr = new Serializable[jsonArray.size()];
                for (int i=0;i<jsonArray.size();i++){
                    arr[i] = jsonArray.getString(i);
                }
                myService.batchDelete(arr);
                operateInfo.setOperateSuccess(true);
                operateInfo.setOperateMessage("删除成功");
            }catch (Exception e){
                e.printStackTrace();
                operateInfo.setOperateSuccess(false);
                operateInfo.setOperateMessage("删除失败");
                operateInfo.setErrorInfo(e.getMessage());
            }
        }else{
            operateInfo.setOperateSuccess(false);
            operateInfo.setOperateMessage("未获取到要删除的数据");
        }
        return operateInfo;
    }

    /**
     * Description: 公共逻辑删除方法
     * Author: zcx
     * Date: Created in 2019-09-08 15:41:04
     * Param: [id]
     * Return: com.imis.frame.utils.OperateInfo
     * Version: 1.0
     */
    @RequestMapping(value = "/remove")
    public OperateInfo remove(String id){
        OperateInfo operateInfo = new OperateInfo();
        try {
            myService.remove(id);
            operateInfo.setOperateSuccess(true);
            operateInfo.setOperateMessage("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            operateInfo.setOperateSuccess(false);
            operateInfo.setOperateMessage("删除失败");
            operateInfo.setErrorInfo(e.getMessage());
        }
        return operateInfo;
    }

    @RequestMapping(value = "/batchRemove")
    public OperateInfo batchRemove(){
        OperateInfo operateInfo = new OperateInfo();
        return operateInfo;
    }
    /**
     * Description:  公共修改方法
     * Author: zcx
     * Date: Created in 2019-09-02 21:52:09
     * Param: [baseEntity]
     * Return: com.imis.frame.utils.OperateInfo
     * Version: 1.0
     */
    @RequestMapping(value = "/update")
    public OperateInfo update(@ModelAttribute T baseEntity){
        OperateInfo operateInfo = new OperateInfo();
        try {
            myService.update(baseEntity);
            operateInfo.setOperateSuccess(true);
            operateInfo.setOperateMessage("修改成功");
        } catch (Exception e){
            e.printStackTrace();
            operateInfo.setOperateSuccess(false);
            operateInfo.setOperateMessage("修改失败");
            operateInfo.setErrorInfo(e.getMessage());
        }
        return operateInfo;
    }

    /**
     * Description:  公共根据ID获取一个对象
     * Author: zcx
     * Date: Created in 2019-09-07 15:32:59
     * Param: [id]
     * Return: T
     * Version: 1.0
     */
    @RequestMapping(value = "/getById")
    public T getById(String id){
        System.out.println("id:"+id);
        return (T) myService.getById(id);
    }
    /**
     * Description: 公共集合查询方法
     * Author: zcx
     * Date: Created in 2019-08-06 22:04:59
     * Param: [map]
     * Return: java.util.List<T>
     * Version: 1.0
     */
    @RequestMapping(value = "/list")
    public List<T> list(@RequestParam Map<String,Object> map){
        return myService.list(map);
    }

    /***
     * Description: 公共分页查询方法
     * Author: zcx
     * Date: Created in 2019-09-08 14:47:16
     * Param: [map]
     * Return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<T>
     * Version: 1.0
     */
    @RequestMapping(value = "/pageQuery")
    public Page<T> pageQuery(@RequestParam Map<String,Object> map){
        return myService.pageQuery(map);
    }
}
