package com.xixi.action;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xixi.model.Account;
/*
 * Model driven 此接口需要实现getModel方法
 * */
@Controller
@Scope("prototype")
public class AccountAction extends BaseAction<Account>{
	public void update(){
		accountService.update(model);
		return;
	}
	
	public String save(){
		System.out.println("******save");
		return "save";
	}
	
	public String query(){
		jsonList=new ArrayList<Account>();
		jsonList=accountService.getAll();
		return "jsonList";
	}
	
	
}
