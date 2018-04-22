package com.xz.wlw.controller;

import com.xz.wlw.entity.Comment;
import com.xz.wlw.entity.Talk;
import com.xz.wlw.service.CommentService;
import com.xz.wlw.service.TalkService;
import com.xz.wlw.util.DateUtil;
import com.xz.wlw.util.Result;
import com.xz.wlw.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
