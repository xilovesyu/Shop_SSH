package com.xixi.service;
import java.util.List;

import com.xixi.model.Product;

public interface ProductService extends BaseService<Product>{

	public Long getCount(String name);
	public List<Product> queryJoinCategory(String name,int page,int size);
}
