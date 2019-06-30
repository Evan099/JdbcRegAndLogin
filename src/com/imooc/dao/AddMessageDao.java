package com.imooc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.imooc.common.ConnecionUntil;

//添加留言
public class AddMessageDao {

	
	public Boolean AddMessage(String username, String title,String message) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		boolean flag = false;
		

		try {
			//连接
			conn = ConnecionUntil.getConnection();
			//编写sql
			String sql = "insert into regandlogin values(null,?,?,?,?)";
			//编译sql
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, username);
			pstmt.setString(2, title);
			pstmt.setString(3, message);
//			pstmt.setDate(4, (Date) time);
			//执行sql
			int num = pstmt.executeUpdate();
			//结果集
			if(num>0) {
				flag = true;
			}else {
				flag = false;
			}
			
			
			return flag;
			
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnecionUntil.release(pstmt, conn);
		}
		
		
		
		
		
		
		
		
		
		return null;
	}


	
	
	

}
