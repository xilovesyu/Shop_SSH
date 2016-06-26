package com.xixi.action;

import java.util.HashSet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xixi.model.Forder;
import com.xixi.model.Product;
import com.xixi.model.Sorder;
import com.xixi.model.Status;
import com.xixi.model.User;

@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {
	
	@Override
	public Forder getModel() {
		// TODO Auto-generated method stub
		model=(Forder)sessionMap.get("forder");
		return model;
	}

	public String save() {
		//订单和购物项入库
		//先把session中的购物项交给forder对象
//		Forder forder=(Forder)sessionMap.get("forder");
//		model.setSorderSet(forder.getSorderSet());
//		forder.setAddress(model.getAddress());
//		forder.setName(model.getName());
//		forder.setPhone(model.getPhone());
//		forder.setRemark(model.getRemark());
		model.setUser((User)sessionMap.get("user"));
		model.setStatus(new Status(1));
//		forder.setPost(model.getPost());	
//		//级联入库
//		forderService.save(forder);
		forderService.save(model);
		sessionMap.put("oldForder", sessionMap.get("forder"));
		//清空掉
		sessionMap.put("forder", new Forder(new HashSet<Sorder>()));
		
		return "bank";
	}
}
