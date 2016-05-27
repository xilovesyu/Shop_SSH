package com.xixi.action;

import org.springframework.stereotype.Controller;

/**
 * 
 * 用来完成web-inf中jsp与jsp请求转发
 */

@Controller
public class SendAction {
	public String execute(){
		return "send";
	}
}
