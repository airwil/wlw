package com.xz.wlw.controller;

import com.xz.wlw.entity.PageBean;
import com.xz.wlw.entity.Solution;
import com.xz.wlw.service.SolutionService;
import com.xz.wlw.util.DateUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解决方案
 * @author
 * @date 2018/4/6 20:32
 */
@Controller
public class SolutionController {

    @Autowired
    private SolutionService solutionService;
    private static final Logger log = Logger.getLogger(SolutionController.class);

    /**
     * 查询列表
     */
    @RequestMapping(value = "/listSolution", method = RequestMethod.POST)
    public void listSolution(@RequestParam("page")String page,
                             @RequestParam("rows")String rows,
                             HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.valueOf(page),Integer.valueOf(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        List<Solution> solutions = solutionService.selectAll(map);
        JSONObject result=new JSONObject();
        JSONArray array = JSONArray.fromObject(solutions);
        result.put("rows", array);
        result.put("total",solutionService.countAll());
        ResponseUtil.write(response,result);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "/listSolution", method = RequestMethod.GET)
    public void listSolutionPortal(HttpServletResponse response) throws Exception {
        List<Solution> solutions = solutionService.selectAll(null);
        JSONObject result=new JSONObject();
        JSONArray array = JSONArray.fromObject(solutions);
        result.put("rows", array);
        result.put("total",solutionService.countAll());
        ResponseUtil.write(response,result);
    }

    /**
     * 根据id查询
     */
    @RequestMapping(value ="/selectSolutionById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result selectByid(@PathVariable("id")int id){
        Solution solution = solutionService.selectById(id);
        return ResultGenerator.genSuccessResult(solution);
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/solution",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Solution solution){
        solution.setCreateDate(DateUtil.getCurrentDateStr());
        int res=solutionService.insert(solution);
        if (res > 0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }


    /**
     * 修改
     */
    @RequestMapping(value = "/solution",method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Solution solution){
        int res = solutionService.update(solution);
        log.info("request: solution/update , " + solution.toString());
        if (res > 0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delSolution/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@PathVariable("ids") String ids) {
        String[] strs = ids.split(",");
        for (int i = 0; i < strs.length; i++) {
            solutionService.delete(Integer.valueOf(strs[i]));
        }
        return ResultGenerator.genSuccessResult();
    }
}
