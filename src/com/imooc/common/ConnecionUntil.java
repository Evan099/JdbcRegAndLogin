package com.imooc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConnecionUntil {
	
	private static final String url = "jdbc:mysql://localhost:3306/regandlogin?useUnicode=true&characterEncoding=utf8";
	private static final String user = "root";
	private static final String password = "111111";
	
	
	//注册
	public static void loadDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	//连接
	public static Connection getConnection() throws Exception {
		loadDriver();
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	//释放
	public static void release(PreparedStatement pstmt,Connection conn) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//释放(结果集)
	public static void release(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
