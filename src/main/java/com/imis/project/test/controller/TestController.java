package com.imis.project.test.controller;

import com.imis.frame.core.controller.BaseController;
import com.imis.project.test.entity.TestEntity;
import com.imis.project.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
//@Controller
@RequestMapping("/testController")
public class TestController extends BaseController {

    @Autowired
    public TestService testService;

    @RequestMapping("/postTest")
    //@ModelAttribute TestEntity testEntity
    public String postTest(TestEntity testEntity){
        System.out.println("--++--"+testEntity.toString());
        testEntity.setId("123");
        Boolean flag = testService.insert(testEntity);
        return "操作状态："+flag+"，提交的账号为："+testEntity.getUsername()+",密码为："+testEntity.getPassword();
    }

    @GetMapping("/getTest")
    public  String getTest(@RequestParam Map<String,Object> map){
        System.out.println("getTest:"+map.get("searchInfo"));
        return "查询的内容为："+map.get("searchInfo");
    }
}
