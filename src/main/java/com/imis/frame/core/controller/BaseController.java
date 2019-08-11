package com.imis.frame.core.controller;

import com.imis.frame.core.entity.BaseEntity;
import com.imis.frame.core.service.BaseService;
import com.imis.frame.utils.OperateInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public abstract class BaseController<T extends BaseEntity, S extends BaseService> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public S myService;
    /**
     * Description: 公共新增方法
     * Author: zcx
     * Date: Created in 2019-08-04 22:41:06
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
     * Description: 公共列表查询方法
     * Author: zcx
     * Date: Created in 2019-08-06 22:04:59
     * Version: 1.0
     */
    @RequestMapping("/list")
    public List<T> list(@RequestParam Map<String,Object> map){
        return myService.list(map);
    }
}
