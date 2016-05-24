package com.xixi.action;

import com.xixi.model.Account;
/*
 * Model driven 此接口需要实现getModel方法
 * */
public class AccountAction extends BaseAction<Account>{
	public String update(){
		System.out.println("*****");
		System.out.println(accountService);
		accountService.update(model);
		return "index";
	}
	
	public String save(){
		System.out.println("******save");
		return "save";
	}
	
	public String query(){
		requestMap.put("accountList", accountService.getAll());
		sessionMap.put("accountList", accountService.getAll());
		applicationMap.put("accountList", accountService.getAll());
		return "index";
	}
}
