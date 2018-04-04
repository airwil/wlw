package com.xz.wlw.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.wlw.dao.NewsMapper;
import com.xz.wlw.entity.News;
import com.xz.wlw.service.NewsService;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

	@Resource
	private NewsMapper newsMapper;
	
	@Override
	public int addNews(News news) {
		return newsMapper.insert(news);
	}

	@Override
	public int delNews(int id) {
		return newsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateNews(News news) {
		return newsMapper.updateByPrimaryKeySelective(news);
	}

	@Override
	public List<News> selectNews(Map<String, Object> map) {
		return newsMapper.selectAll(map);
	}

	@Override
	public News selectById(int id) {
		return newsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int getTotalNews() {
		return newsMapper.countAllNews();
	}

}
