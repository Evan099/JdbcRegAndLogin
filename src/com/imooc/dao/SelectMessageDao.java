package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.imooc.bean.Message;
import com.imooc.common.ConnecionUntil;

//获取留言
public class SelectMessageDao {
	

	
	//获取留言板信息
	public static ArrayList<Message> findInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean flag = false;
		
		ArrayList<Message> messagess = new ArrayList<>();
		

		try {
			//连接
			conn = ConnecionUntil.getConnection();
			//编写sql
			String sql = "select * from messagess";
			//编译sql
			pstmt = conn.prepareStatement(sql);
			//设置参数
			//执行sql
			rs = pstmt.executeQuery();
			//结果集
			while (rs.next()) {
				
				Message message = new Message();
				message.setTitle(rs.getString(1));
				message.setMessage(rs.getString(2));
				
			}
			return messagess;
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnecionUntil.release(rs,pstmt, conn);
		}
		
		
		
		
		return null;
		
		
		
	}


}
