package www.uai.com.vo;

public class SellerContentVO {
	private ProductVO productDataVO;
	private OrderDataVO orderDataVO;
	private MemberDataVO memberDataVO;
	private PurchaseDataVO purchaseDataVO;
	private ContentDataVO contentDataVO;
	private PaycheckDataVO paycheckDataVO;
	
	
	
	public SellerContentVO() {
	}



	public SellerContentVO(ProductVO productDataVO, OrderDataVO orderDataVO, MemberDataVO memberDataVO,
			PurchaseDataVO purchaseDataVO, ContentDataVO contentDataVO, PaycheckDataVO paycheckDataVO) {
		super();
		this.productDataVO = productDataVO;
		this.orderDataVO = orderDataVO;
		this.memberDataVO = memberDataVO;
		this.purchaseDataVO = purchaseDataVO;
		this.contentDataVO = contentDataVO;
		this.paycheckDataVO = paycheckDataVO;
	}



	public ProductVO getProductDataVO() {
		return productDataVO;
	}



	public void setProductDataVO(ProductVO productDataVO) {
		this.productDataVO = productDataVO;
	}



	public OrderDataVO getOrderDataVO() {
		return orderDataVO;
	}



	public void setOrderDataVO(OrderDataVO orderDataVO) {
		this.orderDataVO = orderDataVO;
	}



	public MemberDataVO getMemberDataVO() {
		return memberDataVO;
	}



	public void setMemberDataVO(MemberDataVO memberDataVO) {
		this.memberDataVO = memberDataVO;
	}



	public PurchaseDataVO getPurchaseDataVO() {
		return purchaseDataVO;
	}



	public void setPurchaseDataVO(PurchaseDataVO purchaseDataVO) {
		this.purchaseDataVO = purchaseDataVO;
	}



	public ContentDataVO getContentDataVO() {
		return contentDataVO;
	}



	public void setContentDataVO(ContentDataVO contentDataVO) {
		this.contentDataVO = contentDataVO;
	}



	public PaycheckDataVO getPaycheckDataVO() {
		return paycheckDataVO;
	}



	public void setPaycheckDataVO(PaycheckDataVO paycheckDataVO) {
		this.paycheckDataVO = paycheckDataVO;
	}



	
	
	

}
