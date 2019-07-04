package com.imooc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imooc.bean.Message;
import com.imooc.dao.LoginDao;
import com.imooc.dao.SelectMessageDao;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		
		if(new LoginDao().LoginUser(username,password)) {//登录成功	
			System.out.println("登陆成功");

			HttpSession session = request.getSession();
			
			//获取留言板信息
			ArrayList<Message> al = SelectMessageDao.findInfo();
			session.setAttribute("al", al);
			
			
			
			
			
			//存入sesson

			session.setAttribute("username", username);
			
			session.setAttribute("isLogin", "isLoginYes");
			//重定向
			response.sendRedirect("index.jsp");
		}else {//登录失败
			System.out.println("登陆失败");
	
			

			request.setAttribute("info", "登陆失败");
		
			request.getRequestDispatcher("/infoBoard.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}
