package com.imooc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/SessionFilter")
public class CharacterEncodingFilter implements Filter {
	private FilterConfig fConfig;

 
    public CharacterEncodingFilter() {
       
    }


	public void destroy() {
		System.out.println("CharacterEncodingFilter destroy");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	

		String charset = fConfig.getInitParameter("charset");
		String version = fConfig.getInitParameter("version");
		
//		request.setCharacterEncoding("utf-8");如果不在xml里面传值过来(init-param)，则直接写上需要的值
		request.setCharacterEncoding(charset);
		
//		System.out.println("charset:"+charset);
//		System.out.println("version:"+version);
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

		this.fConfig = fConfig;
		
		
	}


	public FilterConfig getfConfig() {
		return fConfig;
	}


	public void setfConfig(FilterConfig fConfig) {
		this.fConfig = fConfig;
	}

}
