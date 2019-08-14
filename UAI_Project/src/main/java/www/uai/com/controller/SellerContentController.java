package www.uai.com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import www.uai.com.service.ProductService;
import www.uai.com.service.UserService;
import www.uai.com.vo.AdvancedSearchDataVO;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.SessionDataVO;

//판매자 관리 페이지용 컨트롤러

@Controller
public class SellerContentController {
	
	@Autowired
	private ProductService productService;
	private UserService userService;
	
	
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
	
	
	//관리 기능별 페이지...
	@RequestMapping ("/seller/manageProduct.do")
	public String productManagePage(Model model, AdvancedSearchDataVO searchDataVO){

		//상품 리스트 불러오기
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		productList=productService.getAllProductList(searchDataVO);
			
		model.addAttribute("productList", productList);
		
		return "sellerProductManagePage";
	}
	
	
	@RequestMapping ("/seller/manageOrder.do")
	public String orderManage(Model model, AdvancedSearchDataVO searchDataVO){
		
		
		return "sellerMemberManagePage";
	}
	
	@RequestMapping ("/seller/manageMember.do")
	public String memberManage(Model model){
		

		//회원 리스트 불러오기
		ArrayList<MemberDataVO> userDataList = new ArrayList<MemberDataVO>();
		userDataList=userService.getAllUserList();
			
		model.addAttribute("userDataList", userDataList);
		
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
	
	
	
	//lhe: 상품 등록 페이지 맵핑
	@RequestMapping("/seller/newProduct.do")
	public String newProductPage(){
		
		return "sellerNewProductPage";
	}
	
	
	
	
}
