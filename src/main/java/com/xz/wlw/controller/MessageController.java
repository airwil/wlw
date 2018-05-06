package com.xz.wlw.controller;

import com.xz.wlw.entity.Message;
import com.xz.wlw.entity.PageBean;
import com.xz.wlw.service.MessageService;
import com.xz.wlw.util.DateUtil;
import com.xz.wlw.util.ResponseUtil;
import com.xz.wlw.util.Result;
import com.xz.wlw.util.ResultGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 后台留言查询
     */
    @RequestMapping(value = "/listMessageMap",method = RequestMethod.POST)
    public void listMsgMap(@RequestParam(value = "page", required = false) String page,
                           @RequestParam(value = "rows", required = false) String rows,
                           HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        List<Message> list = messageService.findMessage(map);
        JSONObject object = new JSONObject();
        JSONArray array = JSONArray.fromObject(list);
        object.put("rows", array);
        object.put("total", messageService.countAll());
        ResponseUtil.write(response, object);
    }

    /**
     * 根据id删除
     */
    @RequestMapping(value = "/delMessage/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Result delMessage(@PathVariable("ids")String ids[]){
        if(ids.length>0){
            for(String id:ids){
                messageService.deleteMessage(Integer.valueOf(id));
            }
        }
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
