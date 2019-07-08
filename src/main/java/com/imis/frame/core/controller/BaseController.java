package com.imis.frame.core.controller;

import com.imis.frame.core.entity.BaseEntity;
import com.imis.frame.core.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

public class BaseController<T extends BaseEntity, S extends BaseService> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Resource
    protected S myService;

//    @RequestMapping("find")
//    public T find(){
//
//    }

    @RequestMapping("/test1")
    public String test(){
        return "hello world";
    }
}
