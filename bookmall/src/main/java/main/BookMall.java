package main;

import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dao.CartDao;
import dao.CategoryDao;
import dao.MemberDao;
import dao.OrderDao;
import vo.BookVo;
import vo.CartVo;
import vo.CategoryVo;
import vo.MemberVo;
import vo.OrderVo;



public class BookMall {

	public static void main(String[] args) {

		insertData();
		displayInfo();

	}
	private static void insertData() {
//		CategoryDao categorydao = new CategoryDao();
//		CategoryVo categoryvo = new CategoryVo();
//		categoryvo.setName("과학");
//		categorydao.insert(categoryvo);
//		
//		categoryvo.setName("IT");
//		categorydao.insert(categoryvo);
//	
//		categoryvo.setName("문학");
//		categorydao.insert(categoryvo);
		
//		BookDao bookDao = new BookDao();
//		BookVo bookVo = new BookVo();
//		bookVo.setTitle("이것이 MariaDB다");
//		bookVo.setPrice(1000L);
//		bookVo.setCategoryNo(5L);
//		bookDao.insert(bookVo);  
//		
//		bookVo.setTitle("러닝 Rect.JS");
//		bookVo.setPrice(2000L);
//		bookVo.setCategoryNo(5L);
//		bookDao.insert(bookVo);
//		
//		bookVo.setTitle("코스모스");
//		bookVo.setPrice(1000L);
//		bookVo.setCategoryNo(4L);
//		bookDao.insert(bookVo);
//		
//		MemberDao memberDao = new MemberDao();
//		MemberVo memberVo = new MemberVo();
//		memberVo.setName("둘리");
//		memberVo.setEmail("dooly@gmail.com");
//		memberDao.insert(memberVo);
//		
//		memberVo.setName("마이콜");
//		memberVo.setEmail("michol@gmail.com ");
//		memberDao.insert(memberVo);
//		
		CartDao cartDao = new CartDao();
		CartVo cartVo = new CartVo();
//		cartVo.setMemberNo(3L);
//		cartVo.setBookNo(6L);
//		cartVo.setStock(2);
//		cartDao.insert(cartVo);
//			
//		cartVo.setMemberNo(4L);
//		cartVo.setBookNo(6L);
//		cartVo.setStock(1);
//		cartDao.insert(cartVo);
//		
//		
		OrderDao orderDao = new OrderDao();
		OrderVo orderVo = new OrderVo();
//		orderVo.setNo(20220519L);
//		orderVo.setNumber(1L);
//		orderVo.setMemberNo(3L);
//		orderVo.setPaymentPrice(3000L);
//		orderVo.setReceiveAddress("센텀호텔");
//	    orderDao.insert(orderVo);

			
		orderVo.setBookNo(6L);
		orderVo.setOrderNo(20220521L);
		orderVo.setStock(2L);
	    orderDao.insertOrderBook(orderVo);
	    
	    orderVo.setBookNo(7L);
	    orderVo.setOrderNo(20220521L);
	    orderVo.setStock(1L);	    
	    orderDao.insertOrderBook(orderVo);
	  
		
		
	}
	

	private static void displayInfo() {
		List<MemberVo> memberList = new MemberDao().findAll();
		List<CategoryVo> categoryList = new CategoryDao().findAll();
		List<BookVo> bookList = new BookDao().findAll();
		List<CartVo> cartList = new CartDao().findAll();
		List<OrderVo> orderList = new OrderDao().findAll();
		List<OrderVo> orderBookList = new OrderDao().findOrderBook();
		
		
		System.out.println("========================");
		for(MemberVo vo: memberList) {
			System.out.println(vo.getName() + ", "+ vo.getEmail());	
		}
		System.out.println("========================");
		for(CategoryVo vo: categoryList) {
			System.out.println(vo.getNo() + " " + vo.getName());	
		}
		System.out.println("========================");
		for(BookVo vo: bookList) {
			System.out.println(vo.getNo() + " " + vo.getTitle() + " " + vo.getPrice()+  ", " + vo.getCategoryName());	
		}
		System.out.println("========================");
		for(CartVo vo: cartList) {
			System.out.println(vo.getMemberName() + " " + vo.getBookTitle() + " " + vo.getStock());	
		}
		System.out.println("========================");
		for(OrderVo vo: orderList) {
			System.out.println(vo.getNo() + "-" + vo.getNumber() + "\n" + vo.getMemberName()+"("+vo.getMemberEmail()+")"+"\n"+vo.getPaymentPrice()+"\n"+vo.getReceiveAddress());	
		}
		System.out.println("========================");
		for(OrderVo vo: orderBookList) {
			System.out.println(vo.getNo() + " " + vo.getTitle() + " " + vo.getStock()+ " " + vo.getPaymentPrice());	
		}
		
		
	}

}
