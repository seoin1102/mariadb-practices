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
//		BookDao dao = new BookDao();
//		BookVo vo = new BookVo();
//		vo.setTitle("이것이 MariaDB다");
//		vo.setPrice(1000L);
//		vo.setCategoryNo(2L);
//		dao.insert(vo);
		
//		vo.setTitle("러닝 Rect.JS");
//		vo.setPrice(2000L);
//		vo.setCategoryNo(2L);
//		dao.insert(vo);
		
//		vo.setTitle("코스모스");
//		vo.setPrice(1000L);
//		vo.setCategoryNo(1L);
//		dao.insert(vo);
		
//		CartDao dao = new CartDao();
//		CartVo vo = new CartVo();
//		vo.setMemberNo(1L);
//		vo.setBookNo(1L);
//		vo.setStock(2);
//		dao.insert(vo);
		
//		vo.setMemberNo(1L);
//		vo.setBookNo(3L);
//		vo.setStock(1);
//		dao.insert(vo);
		
//		CategoryDao dao = new CategoryDao();
//		CategoryVo vo = new CategoryVo();
//		vo.setName("과학");
//		dao.insert(vo);
		
//		vo.setName("IT");
//		dao.insert(vo);
		
//		vo.setName("문학");
//		dao.insert(vo);
		
		
//		MemberDao dao = new MemberDao();
//		MemberVo vo = new MemberVo();
//		vo.setName("둘리");
//		vo.setEmail("dooly@gmail.com");
//		dao.insert(vo);
//		
//		vo.setName("마이콜");
//		vo.setEmail("michol@gmail.com ");
//		dao.insert(vo);
		
//		OrderDao dao = new OrderDao();
//		OrderVo vo = new OrderVo();
//		vo.setNo(20220519L);
//		vo.setNumber(1L);
//		vo.setMemberNo(1L);
//		vo.setPaymentPrice(3000L);
//		vo.setReceiveAddress("센텀호텔");
		
//		vo.setBookNo(1L);
//		vo.setOrderNo(20220519L);
//		vo.setStock(2L);
//		dao.insertOrderBook(vo);
//		
//		vo.setBookNo(3L);
//		vo.setOrderNo(20220519L);
//		vo.setStock(1L);
//
//		dao.insertOrderBook(vo);
//		
//		displayInfo();

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
