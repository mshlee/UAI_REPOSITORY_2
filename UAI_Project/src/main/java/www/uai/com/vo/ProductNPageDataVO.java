package www.uai.com.vo;

import java.util.ArrayList;

public class ProductNPageDataVO {

	private PageVO pageVO;
	private ArrayList<ProductDataVO> productDataList;
	
	public ProductNPageDataVO() {}
	
	public ProductNPageDataVO(PageVO pageVO, ArrayList<ProductDataVO> productDataList) {
		super();
		this.pageVO = pageVO;
		this.productDataList = productDataList;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public ArrayList<ProductDataVO> getProductDataList() {
		return productDataList;
	}

	public void setProductDataList(ArrayList<ProductDataVO> productDataList) {
		this.productDataList = productDataList;
	}
	
}
