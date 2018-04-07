package com.xz.wlw.controller;

import com.xz.wlw.entity.PageBean;
import com.xz.wlw.entity.Resource;
import com.xz.wlw.service.ResourceService;
import com.xz.wlw.util.ResponseUtil;
import com.xz.wlw.util.Result;
import com.xz.wlw.util.ResultGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2018/4/7 19:59
 */
@Controller
public class ResoureController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 查询
     * @param page
     * @param rows
     * @param response
     */
    @RequestMapping(value = "/listResource", method = RequestMethod.POST)
    public void listResource(
            @RequestParam(value = "page", required = false) int page,
            @RequestParam(value = "rows", required = false) int rows,
            HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(page, rows);
        Map map = new HashMap();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());

        List list = resourceService.selectAll(map);
        JSONObject object = new JSONObject();
        JSONArray array = JSONArray.fromObject(list);
        object.put("rows", array);
        object.put("total", resourceService.countAll());

        ResponseUtil.write(response,object);
    }



    /**
     * 文件下载
     */
    @RequestMapping(value = "/downfile/{id}",method = RequestMethod.GET)
    public void downfile(HttpServletRequest request, HttpServletResponse response, @PathVariable("id")int id) throws Exception {
        Resource resource = resourceService.selectById(id);

        String url=resource.getFileurl();
        ServletContext sc = request.getSession().getServletContext();
        String filePath=sc.getRealPath(url);
        File f=new File(filePath);
        FileInputStream fis = new FileInputStream(f);
        //解决中文文件名下载后乱码的问题
        String filename= URLEncoder.encode(f.getName(),"utf-8");
        byte[] by = new byte[fis.available()];
        fis.read(by);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename + "");
        //获取响应报文输出流对象
        ServletOutputStream outputStream = response.getOutputStream();
        //输出
        outputStream.write(by);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/deleteResource/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@PathVariable("ids")String ids){
        String[] str = ids.split(",");

        for (int i = 0; i < str.length; i++) {
            resourceService.delete(Integer.valueOf(str[i]));
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/resource",method = RequestMethod.POST)
    @ResponseBody
    public Result addFile(@RequestBody Resource resource){
        resourceService.add(resource);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/resource", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateFile(@RequestBody Resource resource) {
        resourceService.update(resource);
        return ResultGenerator.genSuccessResult();
    }
}
