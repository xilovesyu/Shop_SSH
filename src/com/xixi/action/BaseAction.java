package com.xixi.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xixi.service.AccountService;
import com.xixi.service.CategoryService;

@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{
	
	protected T model;
	protected Map<String,Object> requestMap;
	protected Map<String,Object> sessionMap;
	protected Map<String,Object> applicationMap;
	
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;
	//注解不需要set方法
//	public void setCategoryService(CategoryService categoryService) {
//		this.categoryService = categoryService;
//	}
//	public void setAccountService(AccountService accountService) {
//		this.accountService = accountService;
//	}
	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.applicationMap=arg0;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.sessionMap=arg0;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.requestMap=arg0;
	}
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		Class clasz=(Class)type.getActualTypeArguments()[0];
		try {
			model=(T)clasz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

}
