package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.OrderVo;

public class OrderDao {
	public boolean insert(OrderVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			
			String sql = "insert into orders values(null,?, ?, ?, ?)"; 
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getNumber());
			pstmt.setLong(2, vo.getMemberNo());
			pstmt.setLong(3, vo.getPaymentPrice());
			pstmt.setString(4, vo.getReceiveAddress());

			
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean insertOrderBook(OrderVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			
			String sql = "insert into order_book values(null, ?, ?, ?)"; 
			pstmt = connection.prepareStatement(sql);
			
			
			pstmt.setLong(1, vo.getBookNo());
			pstmt.setLong(2, vo.getOrderNo());
			pstmt.setLong(3, vo.getStock());

			
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "select  a.no, a.number,b.name,b.email,a.payment_price ,a.receive_address "
					+ "from orders a, member b "
					+ "where a.member_no = b.no ";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long no = rs.getLong(1); // db 1濡� ����
				Long number = rs.getLong(2);
				String memberName = rs.getString(3);
				String memberEmail = rs.getString(4);
				Long paymentPrice = rs.getLong(5);
				String receiveAddress = rs.getString(6);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setNumber(number);
				vo.setMemberName(memberName);
				vo.setMemberEmail(memberEmail);

				vo.setPaymentPrice(paymentPrice);
				vo.setReceiveAddress(receiveAddress);
				
			
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<OrderVo> findOrderBook() {
		List<OrderVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "select c.no, b.title, c.stock, a.payment_price \r\n"
					+ "from orders a, book b, order_book c\r\n"
					+ "where a.no = c.orders_no\r\n"
					+ "and b.no = c.book_no;";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long no = rs.getLong(1); // db 1濡� ����
				String title = rs.getString(2);
				Long stock = rs.getLong(3);
				Long paymentPrice = rs.getLong(4);
	
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setStock(stock);
				vo.setPaymentPrice(paymentPrice);
	
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mysql://192.168.10.46:3306/bookmall?charset=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR"+ e);
		}
		return connection;
	}
}
