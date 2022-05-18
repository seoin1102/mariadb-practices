package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest02 {
	public static void main(String[] args) {
		insert("cs");
		insert("경영지원");
		insert("인프라");
		
	}
	public static boolean insert(String name) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			//1. JDBC Driver 로딩 (JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://192.168.10.46:3306/webdb?charset=utf8";
			
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. SQL 준비
			String sql = "insert into department values(null, ?)"; //값을 바인딩시킴. 치환시키는것이 아님!
			pstmt = connection.prepareStatement(sql);
			
			//4. Mapping(bind)
			pstmt.setString(1, name);
			
			//5. SQL 실생
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection !=null) {
					connection.close();
				}
				}catch(SQLException e) {
					
				}
			}
		
			return result;
	}
	

}
