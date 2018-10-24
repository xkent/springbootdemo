package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class MyJspController {

    private static Logger logger = LoggerFactory.getLogger(MyJspController.class);

    @RequestMapping(value = {"/", "/view"})
    public String view(Map<String, Object> map) {
        map.put("name", "SpringBoot");
        map.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("----->aaaaa");
        return "index";
    }
}
