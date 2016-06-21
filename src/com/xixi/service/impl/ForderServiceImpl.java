package com.xixi.service.impl;

import org.springframework.stereotype.Service;

import com.xixi.model.Forder;
import com.xixi.model.Sorder;
import com.xixi.service.ForderService;
@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {

	@Override
	public double calcuTotal(Forder forder) {
		// 计算总价格
		double total=0.0;
		for(Sorder sorder:forder.getSorderSet()){
			total+=sorder.getNumber()*sorder.getPrice();
		}
		return total;
	}
	
}
