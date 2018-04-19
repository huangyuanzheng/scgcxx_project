package com.johe.scgcxx.base;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.do")
public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter.init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		//禁用浏览器缓存
		res.addHeader("Pragma", "no-cache");
		res.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		res.addHeader("Cache-Control","pre-check=0, post-check=0");
		res.setDateHeader("Expires", 0);
		
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		if(path.equals("/safty/login/toLogin.do") || path.equals("/safty/login/doLogin.do") || session.getAttribute("userName")!=null){
			//放行通过
			chain.doFilter(req, res);
		}else{
			res.sendRedirect(req.getContextPath()+"/safty/login/toLogin.do");
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter.destroy");
	}
	
}
