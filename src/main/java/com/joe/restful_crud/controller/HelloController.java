package com.joe.restful_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("/success")
    public String success(){
        //classpath:/templates/success
        return "success";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
