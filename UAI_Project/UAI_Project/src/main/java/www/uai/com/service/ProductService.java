package www.uai.com.service;

import org.springframework.ui.Model;

import www.uai.com.vo.ProductNPageDataVO;

public interface ProductService {

	public ProductNPageDataVO getProductList(Model model, int nowPage);
	
}
