package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imooc.dao.LoginDao;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(new LoginDao().LoginUser(username,password)) {
			
			
			System.out.println("登陆成功");
			//存入sesson
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			//重定向
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("登陆失败");

			request.setAttribute("info", "登陆失败");
			
			request.getRequestDispatcher("/infoBoard.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}
