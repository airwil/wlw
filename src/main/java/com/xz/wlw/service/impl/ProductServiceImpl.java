package com.xz.wlw.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.wlw.dao.ProductMapper;
import com.xz.wlw.entity.Product;
import com.xz.wlw.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Product record) {
		return productMapper.insert(record);
	}

	@Override
	public Product selectByPrimaryKey(Integer id) {
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Product record) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Product> selectAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return productMapper.selectAll(map);
	}

	@Override
	public int countAllProduct() {
		// TODO Auto-generated method stub
		return productMapper.countAllProduct();
	}

}
