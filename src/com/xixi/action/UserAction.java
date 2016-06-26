package com.xixi.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xixi.model.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	public String login() {
		//
		model = userService.login(model);
		if (model == null) {
			sessionMap.put("error", "未登錄");
			return "ulogin";
		} else {
			// 存储到session，跳转到响应的页面
			sessionMap.put("user", model);
			// 根据session中goURL是否有值决定跳转
			if (sessionMap.get("goURL") == null) {
				return "index";
			} else {
				return "goURL";
			}
		}
	}
}
