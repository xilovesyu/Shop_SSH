package com.xixi.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xixi.model.Product;
@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	public String queryJoinCategory(){
		//所有查询的要求
		List<Product> products=productService.queryJoinCategory(model.getName(), page, rows);
		//总记录数
		Long total=productService.getCount(model.getName());
		pagemap=new HashMap<String,Object>();
		pagemap.put("rows", products);
		pagemap.put("total", total);
		return "jsonMap";
	}
	public void save() throws IOException{
		System.out.println("---save product model---");
		//实现文件上传的功能
		String pic=fileUpload.uploadFile(fileModel);
		model.setPic(pic);
		productService.save(model);
	}
	public String get(){
		requestMap.put("product", productService.get(model.getId()));
		return "detail";
	}
}
