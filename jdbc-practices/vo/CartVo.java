package vo;

public class CartVo {
	private Long no;
	private Long bookNo;
	private Long memberNo;
	private int stock;
	private Long price;
	private String bookTitle;
	private String memberName;
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", bookNo=" + bookNo + ", memberNo=" + memberNo + ", stock=" + stock + ", price="
				+ price + ", memberName=" + memberName + ", bookTitle=" + bookTitle + "]";
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
}
