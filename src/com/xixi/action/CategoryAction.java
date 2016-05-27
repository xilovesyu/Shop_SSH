package com.xixi.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xixi.model.Category;
import com.xixi.service.CategoryService;
/*
 * Model driven 此接口需要实现getModel方法
 * */
@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>{
	
//	private Category category;
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//	public Category getCategory() {
//		return category;
//	}
	
	public String update(){
		System.out.println("*****");
		System.out.println(categoryService);
		categoryService.update(model);
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
//	@Override
//	public Category getModel() {
//		// TODO Auto-generated method stub
//		category=new Category();
//		return category;
//	}
//	
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
