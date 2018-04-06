package com.xz.wlw.controller;

import com.xz.wlw.entity.Admin;
import com.xz.wlw.service.AdminService;
import com.xz.wlw.util.Result;
import com.xz.wlw.util.ResultGenerator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ThinkPad
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    private static final Logger log=Logger.getLogger(AdminController.class);
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    /**
     * 管理员登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpServletRequest request){
        String name=request.getParameter("userName");
        String pwd=request.getParameter("password");
        System.out.println(name+pwd);
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPwd(pwd);
        Admin resultAdmin = adminService.login(admin);
        if(resultAdmin==null){
            log.info("登录失败");
            return ResultGenerator.genFailResult("请认真核对账号、密码！");
        }else{
            log.info(resultAdmin.getName()+" --登录成功");
            resultAdmin.setPwd("PASSWORD");
            //存入session
            request.getSession().setAttribute("admin",resultAdmin);
            //存入统一结果集
            Map data = new HashMap();
            data.put("currentUser", resultAdmin);
            return ResultGenerator.genSuccessResult(data);
        }
    }
}
