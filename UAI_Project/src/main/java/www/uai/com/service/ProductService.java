package www.uai.com.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import www.uai.com.vo.AdvancedSearchDataVO;
import www.uai.com.vo.ProductNPageDataVO;
import www.uai.com.vo.ProductVO;

public interface ProductService {

	public ProductNPageDataVO getProductList(Model model, int nowPage);

}
