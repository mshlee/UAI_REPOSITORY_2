package www.uai.com.vo;

public class WishListDataVO {

	private WishListVO wishListVO;
	private ProductVO productVO;
	private ProductContentVO productContentVO;
	
	public WishListDataVO(WishListVO wishListVO, ProductVO productVO, ProductContentVO productContentVO) {
		super();
		this.wishListVO = wishListVO;
		this.productVO = productVO;
		this.productContentVO = productContentVO;
	}

	public WishListVO getWishListVO() {
		return wishListVO;
	}

	public void setWishListVO(WishListVO wishListVO) {
		this.wishListVO = wishListVO;
	}

	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	public ProductContentVO getProductContentVO() {
		return productContentVO;
	}

	public void setProductContentVO(ProductContentVO productContentVO) {
		this.productContentVO = productContentVO;
	}
	
}
