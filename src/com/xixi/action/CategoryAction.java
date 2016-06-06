package com.xixi.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
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
	
	
	public String queryJoinAccount(){
		System.out.println("TYPE:"+model.getType());
		//所有查询的要求
		List<Category> categorys=categoryService.queryJoinAccount(model.getType(), page, rows);
		//总记录数
		Long total=categoryService.getCount(model.getType());
		pagemap=new HashMap<String,Object>();
		pagemap.put("rows", categorys);
		pagemap.put("total", total);
		return "jsonMap";
	}
	public String deleteByIds(){
		System.out.println("删除id编号为："+ids);
		categoryService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		
		return "stream";
	}
	public void save(){
		categoryService.save(model);
	}
	public void update(){
		categoryService.update(model);
		return ;
	}
	public String query(){
		jsonList=categoryService.getAll();
		return "jsonList";
	}
//	

//	
//	public String query(){
//		//取代内置对象
////		ActionContext.getContext().put("categoryList", categoryService.getAll());
////		ActionContext.getContext().getSession().put("categoryList", categoryService.getAll());
////		ActionContext.getContext().getApplication().put("categoryList", categoryService.getAll());
//		
//		//method 2 implements RequestMap, SessionMap ,ApplicationMap
//		requestMap.put("categoryList", categoryService.getAll());
//		sessionMap.put("categoryList", categoryService.getAll());
//		applicationMap.put("categoryList", categoryService.getAll());
//		return "index";
//	}
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
