package com.xixi.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xixi.model.Category;
import com.xixi.service.CategoryService;

public class CategoryAction extends BaseAction{
	private CategoryService categoryService;
	private Category category;
	public void setCategory(Category category) {
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public String update(){
		System.out.println("*****");
		System.out.println(categoryService);
		categoryService.update(category);
		return "index";
	}
	
	public String save(){
		System.out.println("******save");
		return "save";
	}
	
	public String query(){
		//取代内置对象
//		ActionContext.getContext().put("categoryList", categoryService.getAll());
//		ActionContext.getContext().getSession().put("categoryList", categoryService.getAll());
//		ActionContext.getContext().getApplication().put("categoryList", categoryService.getAll());
		
		//method 2 implements RequestMap, SessionMap ,ApplicationMap
		requestMap.put("categoryList", categoryService.getAll());
		sessionMap.put("categoryList", categoryService.getAll());
		applicationMap.put("categoryList", categoryService.getAll());
		return "index";
	}
	
//	
//	private Map<String,Object> requestMap;
//	private Map<String,Object> sessionMap;
//	private Map<String,Object> applicationMap;
//	@Override
//	public void setApplication(Map<String, Object> arg0) {
//		// TODO Auto-generated method stub
//		this.applicationMap=arg0;
//	}
//	@Override
//	public void setSession(Map<String, Object> arg0) {
//		// TODO Auto-generated method stub
//		this.sessionMap=arg0;
//	}
//	@Override
//	public void setRequest(Map<String, Object> arg0) {
//		// TODO Auto-generated method stub
//		this.requestMap=arg0;
//	}
}
