package com.xz.wlw.controller;

import com.xz.wlw.entity.News;
import com.xz.wlw.entity.PageBean;
import com.xz.wlw.service.NewsService;
import com.xz.wlw.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaowei
 * @date 2018/4/5 20:40
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    private Logger log = Logger.getLogger(NewsController.class);

    /**
     * 添加新闻资讯
     * @param news
     * @return
     */
    @RequestMapping(value = "/news",method = RequestMethod.POST)
    @ResponseBody
    public Result addNews(@RequestBody News news){
        System.out.println("hello");
        news.setCreateTime(DateUtil.getCurrentDateStr());
        int resultTotal = newsService.addNews(news);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/news",method = RequestMethod.PUT)
    @ResponseBody
    public Result updateNews(@RequestBody News news){
        int resultTotal = newsService.updateNews(news);
        log.info("request: news/update , " + news.toString());
        if(resultTotal>0){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 查询新闻资讯
     * @param page
     * @param rows
     * @param news
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/listNews",method = RequestMethod.POST)
    public void list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            News news, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (news != null) {
            map.put("articleTitle",
                    StringUtil.formatLike(news.getTitle()));
        }
        List<News> newsList = newsService.selectNews(map);
        int total = newsService.getTotalNews();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(newsList);
        result.put("rows", jsonArray);
        result.put("total", total);

        ResponseUtil.write(response, result);
    }

    /**
     * 根据id查询
     */
    @RequestMapping(value = "/selectNewsById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result findById(@PathVariable("id")int id){
        News news = newsService.selectById(id);
        Result result = ResultGenerator.genSuccessResult(news);
        return result;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/deleteNews/{ids}",method = RequestMethod.POST)
    public Result deleteNews(@PathVariable("ids") String ids){
        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            newsService.delNews(Integer.valueOf(idsStr[i]));
        }

        log.info("request: news/delete , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }


}
