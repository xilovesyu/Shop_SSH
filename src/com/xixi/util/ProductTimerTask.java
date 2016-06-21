package com.xixi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.xixi.model.Category;
import com.xixi.model.Product;
import com.xixi.service.CategoryService;
import com.xixi.service.ProductService;
/*
 * 设置定时任务刷新首页的商品信息
 * */
@Component("productTimerTask")
public class ProductTimerTask extends TimerTask {
	@Resource
	private ProductService productService=null;
	private ServletContext context=null;
	@Resource
	private CategoryService categoryService=null;
	public void setContext(ServletContext context) {
		this.context = context;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<List<Product>> bigList=new ArrayList<List<Product>>();
		for(Category category: categoryService.queryByHot(true)){
			List<Product> templist=productService.queryByCid(category.getId());
			if(templist.size()>0) bigList.add(templist);
		}
		for (int i = 0; i < bigList.size(); i++) {
			System.out.println("_________________________________");
			for (int j = 0; j < bigList.get(i).size(); j++) {
				System.out.println(bigList.get(i).get(j));
			}
		}
//		把查询的biglist交给application内置对象
		context.setAttribute("bigList", bigList);
	}

}
