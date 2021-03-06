package com.carol.yj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DBManager {

	public void inserttest(String para1, String para2) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
			pstmt = conn.prepareStatement("insert into test values (?,?)");
			pstmt.setString(1, para1);
			pstmt.setString(2, para2);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void deletetest(String para1) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");	
			pstmt = conn.prepareStatement("delete from test where para1=?");
			pstmt.setString(1, para1);
			pstmt.execute(); //실행		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn != null)
				   conn.close(); 
				if(pstmt!=null)
				   pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	
	public void updatetest(String para1, String para2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");	
			pstmt = conn.prepareStatement("Update test Set para2 = ? where para1 = ?");
			pstmt.setString(1, para2); //순서대로!
			pstmt.setString(2, para1);
			pstmt.execute(); //실행		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn != null)
				   conn.close(); 
				if(pstmt!=null)
				   pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	

}
