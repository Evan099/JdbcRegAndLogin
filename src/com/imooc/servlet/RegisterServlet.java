package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.dao.RegiserDao;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("") || password.equals("")) {
			request.setAttribute("info", "输入不能为空");
			
			request.getRequestDispatcher("infoBoard.jsp").forward(request, response);
		}else {
			
			if(new RegiserDao().RegisterUser(username,password)) {
				System.out.println("注册成功");
				response.sendRedirect("login.jsp");
							
			}else {
				System.out.println("注册失败");
			}
			
		}
		
		
		

		
		
		
		
		
		
	}

}
