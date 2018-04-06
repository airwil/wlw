package com.xz.wlw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhaowei
 * @date 2018/4/5 16:25
 */
@Controller
public class IndexController {
    /**
     * 跳转到后台管理主页
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "main";
    }
}
