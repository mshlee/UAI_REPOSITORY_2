package www.uai.com.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import www.uai.com.vo.AdvancedSearchDataVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductNPageDataVO;

public interface ProductService {

	public ProductNPageDataVO getProductList(Model model, int nowPage);

}
