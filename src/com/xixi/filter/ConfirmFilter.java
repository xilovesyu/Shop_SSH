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

import com.xixi.model.Forder;

public class ConfirmFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		Forder forder = (Forder) request.getSession().getAttribute("forder");
		if (forder != null) {
			if (forder.getSorderSet() != null) {
				if (forder.getSorderSet().size() == 0) {
					System.out.println("-------------购物车为空-----------");
				}
			}else{System.out.println("--------购物车中没有购物项null---------------");}
		} else {
			System.out.println("------------沒有購物車-------------");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
