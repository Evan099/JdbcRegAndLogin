package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.imooc.common.ConnecionUntil;

public class LoginDao {
	
	public boolean LoginUser(String username,String password) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		boolean regRs = false;
		
		try {
			//连接
			conn = ConnecionUntil.getConnection();
			//编写sql
			String sql = "select * from user where username = ? and password = ?";
			//预编译sql
			pstmt = conn.prepareStatement(sql);
			System.out.println(username);
			//设置参数
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			//执行sql
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 
				regRs = true;
			}else {
				regRs = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnecionUntil.release(rs,pstmt, conn);
		}
		return regRs;
		
	
		
	}
	
	
	
	

}
