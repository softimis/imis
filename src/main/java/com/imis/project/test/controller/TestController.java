package com.imis.project.test.controller;

import com.imis.frame.core.controller.BaseController;
import com.imis.project.entity.TestEntity;
import org.json.JSONArray;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@RestController
//@Controller
@RequestMapping("/testController")
public class TestController extends BaseController {

    @RequestMapping("/postTest")
    //@ModelAttribute TestEntity testEntity
    public String postTest(TestEntity testEntity){
        System.out.println("--++--"+testEntity.toString());
        return "提交的账号为："+testEntity.getUsername()+",密码为："+testEntity.getPassword();
    }

    @GetMapping("/getTest")
    public  String getTest(@RequestParam Map<String,Object> map){
        System.out.println("getTest:"+map.get("searchInfo"));
        return "查询的内容为："+map.get("searchInfo");
    }
}
