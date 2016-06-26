package com.xixi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		if(request.getSession().getAttribute("user")==null){
			//非法請求，保存当前客户想要去的地址然后跳轉到登錄頁面
			System.out.println("-------------非法请求-----------");
			String goURL=request.getServletPath();
			String param=request.getQueryString();
			if(param!=null){
				goURL=goURL+"?"+param;
			}
			request.getSession().setAttribute("goURL", goURL);
			request.setAttribute("error", "非法請求");
			response.sendRedirect(request.getContextPath()+"/ulogin.jsp");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
