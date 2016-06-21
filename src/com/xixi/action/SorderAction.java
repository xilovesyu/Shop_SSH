package com.xixi.action;

import java.util.HashSet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xixi.model.Forder;
import com.xixi.model.Product;
import com.xixi.model.Sorder;

@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {
	public String addSorder(){
		//1.根据product id获取相应商品信息
		Product product=productService.get(model.getProduct().getId());
		//2.判断当前session中是否有购物车，如果没有则创建
		if(sessionMap.get("forder")==null){
			sessionMap.put("forder", new Forder(new HashSet<Sorder>()));
		}
		Forder forder=(Forder)sessionMap.get("forder");
		//3.把商品信息转换为sorder，并添加进购物车当中
		forder=sorderService.addSorder(forder, product);
		forder.setTotal(forderService.calcuTotal(forder));
		sessionMap.put("forder", forder);
		return "showCar";
	}
}
