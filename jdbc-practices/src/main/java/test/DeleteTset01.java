package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTset01 {

	public static void main(String[] args) {
		//delete(12L);
		//delete(13L);
		//delete(7L);
		delete();
	}

	private static void delete() {
		Connection connection = null;
		Statement stmt = null;
		try {
			//1. JDBC Driver 로딩 (JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://192.168.10.46:3306/webdb?charset=utf8";
			
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. Statment 생성
			stmt = connection.createStatement();
			
			//4. SQL 실생
			String sql = "delete from department";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection !=null) {
					connection.close();
				}
				}catch(SQLException e) {
					
				}
			}

	}
	private static boolean delete(Long no) {
		boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		try {
			//1. JDBC Driver 로딩 (JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://192.168.10.46:3306/webdb?charset=utf8";
			
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. Statment 생성
			stmt = connection.createStatement();
			
			//4. SQL 실생
			String sql = "delete from department where no= "+no;
			int count = stmt.executeUpdate(sql);
			result = count == 1;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
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
