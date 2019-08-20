package www.uai.com.vo;

public class ProductDataVO {
	
	private ProductVO productVO;
	private ProductContentVO productContentVO;
	
	public ProductDataVO() {}
	
	public ProductDataVO(ProductVO productVO, ProductContentVO productContentVO) {
		super();
		this.productVO = productVO;
		this.productContentVO = productContentVO;
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
