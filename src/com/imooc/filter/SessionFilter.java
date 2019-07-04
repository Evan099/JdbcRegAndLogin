package com.imooc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/SessionFilter")
public class SessionFilter implements Filter {

 
    public SessionFilter() {
       
    }


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpServletResponse hreresponse = (HttpServletResponse)response;
		
		String isLogin = (String)hrequest.getSession().getAttribute("isLogin");
		
		System.out.println("sesson doFilter");
		System.out.println("登录控制filter的值:"+isLogin);

		
		if(isLogin == null) {
			hreresponse.sendRedirect(hrequest.getContextPath()+"/login.jsp?flag=1");
			return;
		}else {
			
			chain.doFilter(request, response);
			return;
		}
		
		
		
		
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("sesson init");
	}

}
