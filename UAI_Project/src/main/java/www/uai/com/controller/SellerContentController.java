package www.uai.com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import www.uai.com.service.ProductService;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.SessionDataVO;

//판매자 관리 페이지용 컨트롤러

@Controller
public class SellerContentController {
	
	@Autowired
	private ProductService productService;
	
	//관리자 계정 관리에 대한 페이지들...
	@RequestMapping("/seller/manageAdmin.do")
	public String sellerAccountMainPage(SessionDataVO sessionVO) {
		
		return "sellerAccountManageMainPage";
	}
	
	@RequestMapping("/seller/adminEdit.do")
	public String sellerAccountEditPage(SessionDataVO sessionVO) {
		
		return "sellerAccountEditPage";
	}
	@RequestMapping("/seller/newAdmin.do")
	public String sellerNewAccountPage(SessionDataVO sessionVO) {
		
		return "sellerNewAccountPage";
	}
	
	
	//관리자 메인 페이지
	@RequestMapping ("/seller/index.do")
	public String sellerMainPage(BoardDataVO boardVO){
		
		return "sellerMainPage";
	}
	
	
	//관리 기능별 페이지... (페이지를 돌려막기할까 1:1로 쓸까??)
	@RequestMapping ("/seller/manageProduct.do")
	public String productManagePage(Model model){
		
		//상품 리스트 불러오기
		ArrayList<ProductDataVO> productDataList = new ArrayList<ProductDataVO>();
		productDataList=productService.getAllProductContent();
		
		model.addAttribute("productDataList", productDataList);
		
		return "sellerProductManagePage";
	}
	
	
	@RequestMapping ("/seller/manageOrder.do")
	public String orderManage(BoardDataVO boardVO){
		
		return "sellerManagePage";
	}
	
	@RequestMapping ("/seller/manageMember.do")
	public String memberManage(BoardDataVO boardVO){
		
		return "sellerManagePage";
	}

	@RequestMapping ("/seller/manageReview.do")
	public String reviewManage(BoardDataVO boardVO){
		
		return "sellerManagePage";
	}
	
	@RequestMapping("/seller/manageQnA.do")
	public String qnaManagePage(BoardDataVO boardVO) {
		
		return "sellerManagePage";		
	}
	
	@RequestMapping("/seller/managePaycheck.do")
	public String paycheckManagePage(BoardDataVO boardVO) {
		
		return "sellerManagePage";		
	}
	
	
}
