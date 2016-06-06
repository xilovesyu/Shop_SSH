package com.xixi.service;

import java.util.List;

import com.xixi.model.Category;

public interface CategoryService extends BaseService<Category>{
//	public void save(Category category);
//	public void update(Category category);
//	public void delete(int id);
//	public Category get(int id);
//	public List<Category> getAll();
	public List<Category> queryJoinAccount(String type,int page,int size);
	public Long getCount(String type);
	public void deleteByIds(String ids);
}
