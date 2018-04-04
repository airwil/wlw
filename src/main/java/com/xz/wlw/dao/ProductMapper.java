package com.xz.wlw.dao;

import java.util.List;
import java.util.Map;

import com.xz.wlw.entity.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    List<Product> selectAll(Map<String, Object> map);
    
    int countAllProduct();
}