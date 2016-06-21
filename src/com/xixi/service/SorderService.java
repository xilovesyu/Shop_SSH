package com.xixi.service;
import com.xixi.model.Forder;
import com.xixi.model.Product;
import com.xixi.model.Sorder;

public interface SorderService extends BaseService<Sorder>{
	public Forder addSorder(Forder forder,Product product);
	public Sorder productToSorder(Product product);
}
