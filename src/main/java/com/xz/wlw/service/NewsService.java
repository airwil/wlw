package com.xz.wlw.service;

import java.util.List;
import java.util.Map;
import com.xz.wlw.entity.News;

/**
 * 
 * 新闻资讯
 *
 */
public interface NewsService {

	/**
	 * 新增
	 * @param news
	 * @return
	 */
	public int addNews(News news);
	
	
	/**
	 * 删除
	 */
	public int delNews(int id);
	
	/**
	 * 修改
	 */
	public int updateNews(News news);
	
	
	/**
	 * 查询
	 */
	public List<News> selectNews(Map<String, Object> map);
	
	/**
	 * 根据id查询
	 */
	public News selectById(int id);
	
	/**
	 * 总数
	 */
	public int getTotalNews();
}
