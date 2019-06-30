package com.imooc.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.dao.AddMessageDao;
import com.imooc.dao.RegiserDao;


@WebServlet("/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String username = "hello";
		String title = request.getParameter("request");
		String message = request.getParameter("message");
//		Date time = new Date();
//		SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		
//		if(title.equals("") || message.equals("")) {
//			request.setAttribute("info", "留言不能为空");
//			
//			request.getRequestDispatcher("infoBoard.jsp").forward(request, response);
//		}else {
			if(new AddMessageDao().AddMessage(username,title,message)) {
				System.out.println("留言成功");
				response.sendRedirect("index.jsp");
							
			}else {
				System.out.println("留言失败");
			}
//		}
		
		
		
		
		
		
		
		
		
	}

}
