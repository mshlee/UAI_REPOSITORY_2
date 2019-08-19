package www.uai.com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import www.uai.com.service.ProductService;
import www.uai.com.service.SellerContentService;
import www.uai.com.service.UserService;
import www.uai.com.vo.AdvancedSearchDataVO;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.PaycheckDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.PurchaseDataVO;
import www.uai.com.vo.SellerContentVO;
import www.uai.com.vo.SessionDataVO;

//판매자 관리 페이지용 컨트롤러

@Controller
public class SellerContentController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SellerContentService sellerContentService;
	
	
	//lhe-판매자 관리자 계정 관리에 대한 페이지들...
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
	
	
	//lhe-판매자 상품 관리 페이지 관련 맵핑
	@RequestMapping ("/seller/manageProduct.do")
	public String productManagePage(Model model, AdvancedSearchDataVO searchDataVO){

		//상품 리스트 불러오기
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		productList=productService.getAllProductList(searchDataVO);
			
		model.addAttribute("productList", productList);
		
		return "sellerProductManagePage";
	}
	
	//lhe-판매자 상품 관리 페이지 복수 상품 삭제 명령
	@RequestMapping("/seller/deleteProductByIdx.do")
	public String deleteProductByIdxAction (ArrayList<ProductVO> productVO) {
		
		//선택한 상품 목록 지우기
		sellerContentService.deleteProductByIdx(productVO);
		
		return "redired:sellerProductManagePage";
	}
	
	
	
	//lhe-판매자 주문 관리 페이지 관련 맵핑
	@RequestMapping ("/seller/manageOrder.do")
	public String orderManage(Model model, AdvancedSearchDataVO searchDataVO){
		
		//lhe-주문 리스트 불러오기
		ArrayList<SellerContentVO> orderDataList = new ArrayList<SellerContentVO>();
		orderDataList=sellerContentService.getAllOrderList();
		
		model.addAttribute("orderDataList", orderDataList);
		
		return "sellerOrderManagePage";
	}
	
	//lhe-판매자 주문 관리 페이지 복수 주문 결제상태 변경
	@RequestMapping("/seller/updateOrderByIdx.do")
	public String updateOrderByIdxAction(ArrayList<PurchaseDataVO> purchaseVO) {
		
		//선택한 주문 결제 상태 변경
		sellerContentService.updateOrderByIdx(purchaseVO);
		
		return "redirect:sellerOrderManagePage";
	}
	
	
	//lhe-판매자 회원 관리 페이지 관련 맵핑
	@RequestMapping ("/seller/manageMember.do")
	public String memberManage(Model model){
		

		//회원 리스트 불러오기
		ArrayList<MemberDataVO> userDataList = new ArrayList<MemberDataVO>();
		userDataList=userService.getAllUserList();
			
		model.addAttribute("userDataList", userDataList);
		
		return "sellerMemberManagePage";
		
	}
	
	//lhe-판매자 회원 관리 페이지 복수 회원 탈퇴
	@RequestMapping("/seller/deleteMemberByIdx.do")
		public String deleteMemberByIdxAction (ArrayList<MemberDataVO> memberVO) {
		
		//선택한 회원 리스트 지우기
		sellerContentService.deleteMemberByIdx(memberVO);
			
			return "redirect:sellerMemberManagePage";
		}
	
	//lhe-판매자 리뷰 관리 페이지 관련 맵핑
	@RequestMapping ("/seller/manageReview.do")
	public String reviewManage(Model model){
		
		//리뷰 리스트 불러오기
		ArrayList<SellerContentVO> reviewDataList = new ArrayList<SellerContentVO>();
		reviewDataList = sellerContentService.getAllReviewList();
		
		model.addAttribute("reviewDataList", reviewDataList);
		
		
		return "sellerReviewManagePage";
	}
	
	//lhe-판매자 리뷰 관리 페이지 복수 리뷰 삭제
	@RequestMapping("/seller/deleteReviewByIdx.do")
	public String deleteReviewByIdxAction (ArrayList<ContentDataVO> requestVO) {
		
		//선택한 리뷰 리스트 지우기
		
		return "redirect:sellerReviewManagePage";
				
	}
	
	//lhe-판매자 QnA 관리 페이지 관련 맵핑
	@RequestMapping("/seller/manageQnA.do")
	public String qnaManagePage(Model model) {
		
		ArrayList<SellerContentVO> qnaDataList = new ArrayList<SellerContentVO>();
		qnaDataList = sellerContentService.getAllQnAList();
		
		model.addAttribute("qnaDataList", qnaDataList);
		
		return "sellerQnAManagePage";		
	}
	
	
	//lhe-판매자 QnA 관리 페이지 복수 항목 삭제
	@RequestMapping("/seller/deleteQnAByIdx.do")
	public String deleteQnAByIdxAction(ArrayList<ContentDataVO> requestVO) {
		
		//선택한 질문글 지우기
		sellerContentService.deleteQnAByIdx(requestVO);
		
		return "redirect:sellerQnAManagePage";
	}
	
	
	//lhe-판매자 
	@RequestMapping("/seller/managePaycheck.do")
	public String paycheckManagePage(Model model) {
		
		ArrayList<SellerContentVO> paycheckDataList = new ArrayList<SellerContentVO>();
		paycheckDataList = sellerContentService.getAllPaycheckList();
		
		return "sellerPaycheckManagePage";		
	}
	
	//lhe-판매자 지급 관리 페이지 복수 항목 변경
	@RequestMapping("/seller/deleteQnAByIdx.do")
	public String updatePaycheckByIdxAction(ArrayList<PaycheckDataVO> requestVO) {
		
		//선택한 지급항목 변경하기
		
		
		
		return "redirect:sellerQnAManagePage";
	}
	
	
	
	//lhe: 상품 등록 페이지 맵핑
	@RequestMapping("/seller/newProduct.do")
	public String newProductPage(){
		
		return "sellerNewProductPage";
	}
	
	
	
	
}
