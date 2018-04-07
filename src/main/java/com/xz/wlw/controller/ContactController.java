package com.xz.wlw.controller;

import com.xz.wlw.entity.Contact;
import com.xz.wlw.service.ContactService;
import com.xz.wlw.util.ResponseUtil;
import com.xz.wlw.util.Result;
import com.xz.wlw.util.ResultGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 联系方式接口
 *
 * @author
 * @date 2018/4/7 13:04
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;
    private static final Logger log = Logger.getLogger(ContactController.class);

    /**
     * 查询
     */
    @RequestMapping(value = "/selectContact", method = RequestMethod.POST)
    public void selectContact(HttpServletResponse response, @RequestParam("rows") String rows, @RequestParam("page") String page) throws Exception {
        Contact contact = contactService.selectAll();
        List list = new ArrayList();
        list.add(contact);
        JSONObject jsonObject = new JSONObject();
        JSONArray array = JSONArray.fromObject(list);
        jsonObject.put("rows", array);
        jsonObject.put("total", 1);
        ResponseUtil.write(response, jsonObject);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/updateContact", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Contact contact) {
        int rs = contactService.update(contact);
        if (rs > 0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }
}
