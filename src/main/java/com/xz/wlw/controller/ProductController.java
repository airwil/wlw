package com.xz.wlw.controller;

import com.xz.wlw.entity.PageBean;
import com.xz.wlw.entity.Product;
import com.xz.wlw.service.ProductService;
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
 * 产品中心
 * @author
 * @date 2018/4/6 12:39
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger log = Logger.getLogger(ProductController.class);
    /**
     * 查询列表
     */
    @RequestMapping(value = "/listProduct",method = RequestMethod.POST)
    public void listProduct(HttpServletResponse response,
                            @RequestParam(value = "page",required = false) String page,
                            @RequestParam(value = "rows",required = false) String rows) throws Exception {
        Map<String,Object> map=new HashMap<>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }

        List<Product> products = productService.selectAll(map);
        JSONObject result=new JSONObject();
        JSONArray array = JSONArray.fromObject(products);
        result.put("rows", array);
        result.put("total", productService.countAllProduct());
        ResponseUtil.write(response,result);
    }

    /**
     * 根据id查询
     */
    @RequestMapping(value = "/selectProById/id",method = RequestMethod.GET)
    @ResponseBody
    public Result selectByid(@PathVariable("id")int id){
        Product product = productService.selectByPrimaryKey(id);
        return ResultGenerator.genSuccessResult(product);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePro(Product product) {
        int res = productService.updateByPrimaryKeySelective(product);
        if (res > 0) {
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delProduct/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Result delProduct(@PathVariable("ids")String ids){
        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            productService.deleteByPrimaryKey(Integer.valueOf(idsStr[i]));
        }
        log.info("request: product/delete , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/product",method = RequestMethod.POST)
    @ResponseBody
    public Result addProduct(@RequestBody Product product){
        System.out.println(product.getName());
        System.out.println(product.getPic());
        System.out.println(product.getDesc());
        productService.insert(product);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/product",method = RequestMethod.PUT)
    @ResponseBody
    public Result updateProduct(@RequestBody Product product){
        productService.updateByPrimaryKeySelective(product);
        return ResultGenerator.genSuccessResult();
    }
}
