package com.xixi.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xixi.model.Category;
import com.xixi.model.Product;
import com.xixi.service.CategoryService;
import com.xixi.service.ProductService;
import com.xixi.util.ProductTimerTask;

public class InitDataListener implements ServletContextListener {
	
	private ApplicationContext context=null;
	private ProductTimerTask productTimerTask=null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//1.获取业务逻辑查询商品的
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
//		WebApplicationContextUtils 
//		ApplicationContext context=(ApplicationContext)event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		productService=(ProductService)context.getBean("productService");
//		System.out.println("test productservice:"+productService);
		//solution 2
		context=WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		productTimerTask=(ProductTimerTask)context.getBean("productTimerTask");
		productTimerTask.setContext(event.getServletContext());		//通过定时器设置(配置为守护线程)
		new Timer(true).schedule(productTimerTask, 0, 1000*60);
	}

}
