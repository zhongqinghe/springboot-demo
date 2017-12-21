package com.zhong.demo.controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mb")
public class MbController {
    @Value("${com.zhong.helloWorld}")
    private String helloWorld;

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }
    @RequestMapping("/hello")
    public String hello2(ModelMap map){
        map.addAttribute("content",helloWorld);
        return "hello2";
    }
    @RequestMapping("/bye2")
    @ResponseBody
    public String bye(ModelMap map){
        map.addAttribute("content",helloWorld);
        return "bye2";
    }
}
