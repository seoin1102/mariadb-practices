package vo;

public class OrderVo {
	private Long no;
	private Long number;
	private Long memberNo;
	private Long paymentPrice;
	private String title;
	private Long stock;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	private String receiveAddress;
	private String memberName;
	private String memberEmail;
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", number=" + number + ", memberNo=" + memberNo + ", paymentPrice=" + paymentPrice
				+ ", title=" + title + ", stock=" + stock + ", receiveAddress=" + receiveAddress + ", memberName="
				+ memberName + ", memberEmail=" + memberEmail + "]";
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(Long paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
		
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;		
	}
}
