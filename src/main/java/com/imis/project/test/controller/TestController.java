package com.imis.project.test.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imis.frame.core.controller.BaseController;
import com.imis.project.test.entity.TestEntity;
import com.imis.project.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/testController")
public class TestController extends BaseController<TestEntity,TestService> {

    @Autowired
    public TestService testService;

    @RequestMapping("/postTest")
    //@ModelAttribute TestEntity testEntity
    public String postTest(TestEntity testEntity){
        System.out.println("--++--"+testEntity.toString());
        boolean flag = true;
        testEntity.setId("123");
        try{
            testService.add(testEntity);
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return "操作状态："+flag+"，提交的账号为："+testEntity.getUsername()+",密码为："+testEntity.getPassword();
    }

    @GetMapping("/getTest")
    public List<TestEntity> getTest(@RequestParam Map<String,Object> map){
        System.out.println("getTest:"+map.get("username"));
        return testService.list(map);
    }

}
