package com.xixi.service.impl;

import org.springframework.stereotype.Service;

import com.xixi.model.Forder;
import com.xixi.model.Product;
import com.xixi.model.Sorder;
import com.xixi.service.SorderService;
@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService {

	@Override
	public Forder addSorder(Forder forder, Product product) {
		// TODO Auto-generated method stub
		boolean isHave=false;
		Sorder sorder=productToSorder(product);
		//判断是否重复，如果重复，添加数量即可
		for(Sorder oldsorder:forder.getSorderSet()){
			if(oldsorder.getProduct().getId().equals(sorder.getProduct().getId())){
				//购物项有重复，添加数量即可
				oldsorder.setNumber(oldsorder.getNumber()+sorder.getNumber());
				isHave=true;
				break;
			}
		}
		if(!isHave){
			forder.getSorderSet().add(sorder);
		}
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		// TODO Auto-generated method stub
		Sorder sorder=new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	
	
}
