package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import com.imooc.common.ConnecionUntil;

//注册
public class RegiserDao {


	public boolean RegisterUser(String username,String password) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		boolean regRs = false;
		
		try {
			//连接
			conn = ConnecionUntil.getConnection();
			//编写sql
			String sql = "insert into user values(null,?,?)";
			//预编译sql
			pstmt = conn.prepareStatement(sql);
			System.out.println(username);
			//设置参数
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			//执行sql
			int num = pstmt.executeUpdate();
			
			if(num>0) {
				
				System.out.println(UUID.randomUUID());
				System.out.println("注册成功");
				regRs = true;
			}else {
				
				System.out.println("注册失败");
				regRs = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnecionUntil.release(pstmt, conn);
		}
		return regRs;
		
	
		
	}


	
	
	
	
	
	
	
	
	
	
	

}
