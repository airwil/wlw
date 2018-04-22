package com.xz.wlw.controller;

import com.xz.wlw.entity.Message;
import com.xz.wlw.service.MessageService;
import com.xz.wlw.util.DateUtil;
import com.xz.wlw.util.Result;
import com.xz.wlw.util.ResultGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author
 * @date 2018/4/15 18:23
 */
@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 查询留言
     */
    @RequestMapping(value = "/listMessage",method = RequestMethod.POST)
    public void listMessage(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        List<Message> list = messageService.findMessage(null);
        JSONObject object = new JSONObject();
        JSONArray array = JSONArray.fromObject(list);
        object.put("rows", array);
        object.put("total", messageService.countAll());
        PrintWriter writer = response.getWriter();
        writer.write(object.toString());
        writer.close();
    }

    /**
     * 根据id删除
     */
    @RequestMapping(value = "/delMessage/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Result delMessage(@PathVariable("id")int id){
        messageService.deleteMessage(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 添加留言
     */
    @RequestMapping(value = "/addMessage",method = RequestMethod.POST)
    @ResponseBody
    public Result addMessage(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");
        Message message = new Message();
        String content=request.getParameter("content");
        String ip = request.getRemoteHost();
        message.setCreateTime(DateUtil.getCurrentDateStr());
        message.setIp(ip);
        message.setContent(content);
        messageService.addMessage(message);
        return ResultGenerator.genSuccessResult();
    }
}
