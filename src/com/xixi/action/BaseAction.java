package com.xixi.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xixi.model.FileModel;
import com.xixi.service.AccountService;
import com.xixi.service.CategoryService;
import com.xixi.service.ForderService;
import com.xixi.service.ProductService;
import com.xixi.service.SorderService;
import com.xixi.service.UserService;
import com.xixi.util.FileUploadUtil;

@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{
	
	protected T model;
	protected FileModel fileModel;
	protected Integer page;
	protected Integer rows;
	protected String ids;
	protected InputStream inputStream;
	protected Map<String,Object> pagemap=null;
	protected List<T> jsonList=null;
	protected Map<String,Object> requestMap;
	protected Map<String,Object> sessionMap;
	protected Map<String,Object> applicationMap;
	
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;
	@Resource
	protected ProductService productService;
	@Resource
	protected ForderService forderService;
	@Resource
	protected SorderService sorderService;
	@Resource
	protected UserService userService;
	@Resource
	protected FileUploadUtil fileUpload;
	//注解不需要set方法
//	public void setCategoryService(CategoryService categoryService) {
//		this.categoryService = categoryService;
//	}
//	public void setAccountService(AccountService accountService) {
//		this.accountService = accountService;
//	}
	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.applicationMap=arg0;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.sessionMap=arg0;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.requestMap=arg0;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public List<T> getJsonList() {
		return jsonList;
	}
	public void setJsonList(List<T> jsonList) {
		this.jsonList = jsonList;
	}
	public Map<String, Object> getPagemap() {
		return pagemap;
	}
	public void setPagemap(Map<String, Object> pagemap) {
		this.pagemap = pagemap;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public FileModel getFileModel() {
		return fileModel;
	}
	public void setFileModel(FileModel fileModel) {
		this.fileModel = fileModel;
	}
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		Class clasz=(Class)type.getActualTypeArguments()[0];
		try {
			model=(T)clasz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

}
