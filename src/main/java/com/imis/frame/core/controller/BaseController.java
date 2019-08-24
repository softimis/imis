package com.imis.frame.core.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
    public OperateInfo add(@ModelAttribute T BaseEntity) {
        OperateInfo operateInfo = new OperateInfo();
        try {
            myService.add(BaseEntity);
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
    @RequestMapping("/batchDelete")
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
     * Description: 公共列表查询方法
     * Author: zcx
     * Date: Created in 2019-08-06 22:04:59
     * Param: [map]
     * Return: java.util.List<T>
     * Version: 1.0
     */
    @RequestMapping("/list")
    public List<T> list(@RequestParam Map<String,Object> map){
        return myService.list(map);
    }
}
