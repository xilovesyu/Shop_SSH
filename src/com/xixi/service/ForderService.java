package com.xixi.service;

import com.xixi.model.Forder;

public interface ForderService extends BaseService<Forder>{
	//计算购物总价格
	public double calcuTotal(Forder forder);
}
