package com.xz.wlw.controller;

import com.xz.wlw.entity.Introduct;
import com.xz.wlw.service.IntroductService;
import com.xz.wlw.util.ResponseUtil;
import com.xz.wlw.util.Result;
import com.xz.wlw.util.ResultGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author
 * @date 2018/4/7 17:14
 */
@Controller
public class IntroductController {

    @Autowired
    private IntroductService introductService;
    public static final Logger log = Logger.getLogger(IntroductController.class);

    /**
     * 查询
     */
    @RequestMapping(value = "/selectIntroduct", method = RequestMethod.POST)
    public void select(HttpServletResponse response) throws Exception {
        List<Introduct> list = introductService.select();
        JSONObject object = new JSONObject();
        JSONArray array = JSONArray.fromObject(list);
        object.put("rows", array);
        object.put("total", 1);
        ResponseUtil.write(response,object);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/updateIntroduct", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Introduct introduct) {
        int rs = introductService.update(introduct);
        if (rs > 0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

}
