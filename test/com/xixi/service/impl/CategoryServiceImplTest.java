package com.xixi.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xixi.model.Category;
import com.xixi.model.Product;
import com.xixi.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CategoryServiceImplTest {

	@Resource
	private CategoryService categoryService;
	@Test
	public void testSave() {
		categoryService.save(new Category("junit_test4", true));
	}

	@Test
	public void testUpdate() {
		categoryService.update(new Category(5,"junit_test2",false));
	}

	@Test
	public void testDelete() {
		categoryService.delete(6);
	}

	@Test
	public void testGet() {
		Category category=categoryService.get(5);
		System.out.println(category.toString());
	}

	@Test
	public void testGetAll() {
		List<Category> categorys=categoryService.getAll();
		for (Category category : categorys) {
			System.out.println(category.toString());
		}
	}
	@Test
	public void testqueryJoinAccount(){
		List<Category> categories=categoryService.queryJoinAccount("",2,1);
		for (Category category : categories) {
			System.out.println(category);
			System.out.println(category.getAccount());
		}
		
	}
	
	@Test
	public void testGetCount(){
		System.out.println(categoryService.getCount(""));
	}
	
	@Test
	public void testDelteByIds(){
		String ids="4,5,6";
		categoryService.deleteByIds(ids);
	}
	@Test
	public void testGetHot(){
		List<Category> lists=categoryService.queryByHot(true);
		for (Category category : lists) {
			System.out.println(category);
		}
	}
}
