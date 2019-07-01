package com.imooc.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.imooc.dao.AddMessageDao;
import com.imooc.dao.RegiserDao;


@WebServlet("/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String username = "hello";
		String title = request.getParameter("title");
		String message = request.getParameter("message");
//		Date time = new Date();
//		SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		System.out.println(username+" "+title+" "+message);
		if(title.equals("") || message.equals("")) {
		
				//输入为空时转发
				String messageStatue = "输入不能为空";
				request.getSession().setAttribute("messageStatue", messageStatue);
				request.getSession().setAttribute("flag", "0");//存入sesson
				request.getRequestDispatcher("addMessage.jsp").forward(request, response);;
		}else {
			System.out.println(username+" "+title+" "+message);
			if(new AddMessageDao().AddMessage(username,title,message)) {
				System.out.println("留言成功");
				
				//成功后转发
				String messageStatue = "留言成功";
				
				request.setAttribute("messageStatue", messageStatue);
				request.getSession().setAttribute("flag", "0");//存入sesson
				request.getSession().setAttribute("messageStatue", messageStatue);//存入sesson
				request.getRequestDispatcher("addMessage.jsp").forward(request, response);;
				
				//从数据库取出留言数据，存放在集合
				
					
			}else {
				System.out.println("留言失败");
				
				//成功后转发
				String messageStatue = "留言失败";
				request.setAttribute("messageStatue", messageStatue);
				request.getSession().setAttribute("flag", "0");//存入sesson
				request.getSession().setAttribute("messageStatue", messageStatue);//存入sesson
				request.setAttribute("messageStatue", messageStatue);
				request.getRequestDispatcher("addMessage.jsp").forward(request, response);;
			}
		}
		
		
		
		
		
		
		
		
		
	}

}
