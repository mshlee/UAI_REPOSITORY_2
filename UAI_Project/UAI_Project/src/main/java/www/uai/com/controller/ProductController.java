package www.uai.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import www.uai.com.service.ProductService;
import www.uai.com.vo.ProductNPageDataVO;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productList")
	public String productList(Model model, int nowPage) {
		
		ProductNPageDataVO productList = productService.getProductList(model, nowPage);
		
		model.addAttribute("productList", productList);
		
		return "productListPage";
	}
	


}
