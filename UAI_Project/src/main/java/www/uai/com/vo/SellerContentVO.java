package www.uai.com.vo;

public class SellerContentVO {
	private ProductVO productVO;
	private OrderDataVO orderVO;
	private MemberDataVO memberVO;
	private ProductContentVO productContentVO;
	private ProductDataVO productDataVO;
	
	
	
	public SellerContentVO() {
	}





	public SellerContentVO(ProductVO productVO, OrderDataVO orderVO, MemberDataVO memberVO,
			ProductContentVO productContentVO, ProductDataVO productDataVO) {
		super();
		this.productVO = productVO;
		this.orderVO = orderVO;
		this.memberVO = memberVO;
		this.productContentVO = productContentVO;
		this.productDataVO = productDataVO;
	}





	public ProductDataVO getProductDataVO() {
		return productDataVO;
	}





	public void setProductDataVO(ProductDataVO productDataVO) {
		this.productDataVO = productDataVO;
	}





	public ProductVO getProductVO() {
		return productVO;
	}



	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}



	public OrderDataVO getOrderVO() {
		return orderVO;
	}



	public void setOrderVO(OrderDataVO orderVO) {
		this.orderVO = orderVO;
	}



	public MemberDataVO getMemberVO() {
		return memberVO;
	}



	public void setMemberVO(MemberDataVO memberVO) {
		this.memberVO = memberVO;
	}



	public ProductContentVO getProductContentVO() {
		return productContentVO;
	}



	public void setProductContentVO(ProductContentVO productContentVO) {
		this.productContentVO = productContentVO;
	}
	
	
	
	
	
	
	
	
	

}
