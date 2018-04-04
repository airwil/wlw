package com.xz.wlw.service;

import java.util.List;
import java.util.Map;

import com.xz.wlw.entity.Product;

/**
 * 产品接口
 * @author ThinkPad
 *
 */
public interface ProductService {
	int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    
    List<Product> selectAll(Map<String, Object> map);
    
    int countAllProduct();
}
