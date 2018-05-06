package com.xz.wlw.controller;

import com.xz.wlw.entity.Comment;
import com.xz.wlw.entity.PageBean;
import com.xz.wlw.entity.Talk;
import com.xz.wlw.service.CommentService;
import com.xz.wlw.service.TalkService;
import com.xz.wlw.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交流
 * @author
 * @date 2018/4/21 13:26
 */
@Controller
public class TalkController {

    @Autowired
    private TalkService talkService;
    @Autowired
    private CommentService commentService;

    /**
     * 新增交流帖
     */
    @RequestMapping(value = "/addTalk",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Talk talk, HttpServletRequest request){
        String ip = request.getRemoteHost();
        talk.setIp(ip);
        talkService.insert(talk);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 查询交流帖的名称和评论数
     */
    @RequestMapping(value = "/indexTalk",method = RequestMethod.POST)
    @ResponseBody
    public List<Talk> index(){
        List<Talk> talks = talkService.selectTalkAndComms();
        return talks;
    }

    /**
     * 后台查询功能
     */
    @RequestMapping(value = "/listTalk",method =RequestMethod.POST)
    public void list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Talk talk, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        List<Talk> talks = talkService.selectTalkMap(map);
        int total=talkService.countTotal();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(talks);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
    }

    /**
     * 根据id删除
     */
    @RequestMapping(value = "/delTalk/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Result delTalk(@PathVariable("ids")String ids[]){
        if(ids.length>0){
            for(String id:ids){
                talkService.delTalk(Integer.valueOf(id));
            }
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 根据id查询帖子
     */
    @RequestMapping(value = "/selectTalkById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result selectById(@PathVariable("id") int id){
        Talk talk = talkService.selectById(id);
        return ResultGenerator.genSuccessResult(talk);
    }

    /**
     * 根据帖子id查询回复
     */
    @RequestMapping(value = "/selectCommByTid/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> selectByTid(@PathVariable("id")int tid){
        List<Comment> comments = commentService.selectByTid(tid);
        return comments;
    }

    /**
     * 添加回复
     */
    @RequestMapping(value = "/addComm",method = RequestMethod.POST)
    @ResponseBody
    public Result addComm(@RequestBody Comment comment,HttpServletRequest request){
        comment.setIp(request.getRemoteHost());
        comment.setCreatetime(DateUtil.getCurrentDateStr());
        commentService.insert(comment);
        return ResultGenerator.genSuccessResult();
    }
}
