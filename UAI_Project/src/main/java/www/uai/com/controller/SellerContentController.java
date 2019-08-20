package www.uai.com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import www.uai.com.service.SellerContentService;
import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.AdvancedSearchDataVO;
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
	private SellerContentService sellerContentService;
	
	
	//lhe-판매자 관리자 계정 관리에 대한 페이지들...
	@RequestMapping("/sellerManageAdmin.do")

	public String sellerAccountMainPage(SessionDataVO sessionVO) {
	
		return "sellerAccountManageMainPage";
	}
	
	@RequestMapping("/sellerAdminEdit.do")
	public String sellerAccountEditPage(Model model, SessionDataVO sessionVO) {
		
		AdminDataVO adminData = sellerContentService.getAdminDataByIdx(sessionVO.getAd_idx());
		
		model.addAttribute("adminData", adminData);
		
		return "sellerAccountEditPage";
	}
	
	@RequestMapping("/sellerAdminEditAction.do")
	public String sellerAccountEditAction(AdminDataVO requestVO) {
		
		sellerContentService.updateAdminByIdx(requestVO);
		
		return "redirect:sellerMainPage";
	}
	
	@RequestMapping("/sellerNewAdmin.do")
	public String sellerNewAccountPage(SessionDataVO sessionVO) {
		
		return "sellerNewAccountPage";
	}
	
	@RequestMapping("/sellerNewAdminAction.do")
	public String sellerNewAdminAction(AdminDataVO requestVO) {
		
		sellerContentService.insertAdminData(requestVO);
		
		return "redirect:sellerAccountManageMainPage";
		
	}
	
	
	//관리자 메인 페이지
	@RequestMapping ("/sellerIndex.do")
	public String sellerMainPage(HttpSession session){

		if(session!=null) {
			return "sellerMainPage";
		}else {
			
		}
		
		return "mainPage";
		
	}
	
	
	//lhe-판매자 상품 관리 페이지 관련 맵핑
	@RequestMapping ("/sellerManageProduct.do")
	public String productManagePage(Model model, AdvancedSearchDataVO searchDataVO, HttpSession sessionData){
		
		if(sessionData==null){
			
			return "loginForm";
		}
		
		//상품 리스트 불러오기
		ArrayList<ProductVO> productDataList = new ArrayList<ProductVO>();
		productDataList = sellerContentService.getAllProductList(searchDataVO);
		
		model.addAttribute("productDataList", productDataList);
		
		
		return "sellerProductManagePage";
	}
	
	//lhe-판매자 상품 관리 페이지 복수 상품 삭제 명령

	@RequestMapping("/sellerDeleteProductByIdx.do")
	public String deleteProductByIdxAction (ArrayList<ProductVO> productVO) {
		
		//선택한 상품 목록 지우기
		sellerContentService.deleteProductByIdx(productVO);
		
		return "redirect:sellerManageProduct.do";

	}
	
	
	
	//lhe-판매자 주문 관리 페이지 관련 맵핑
	@RequestMapping ("/sellerManageOrder.do")
	public String orderManage(Model model, AdvancedSearchDataVO searchDataVO,  HttpSession sessionData){
		
		if(sessionData==null){
			
			return "loginForm";
		}
		//lhe-주문 리스트 불러오기
		ArrayList<SellerContentVO> orderDataList = new ArrayList<SellerContentVO>();
		orderDataList=sellerContentService.getAllOrderList();
		
		model.addAttribute("orderDataList", orderDataList);
		
		return "sellerOrderManagePage";
	}

	@RequestMapping("/sellerUpdateOrderByIdx.do")
	public String updateOrderByIdxAction(ArrayList<PurchaseDataVO> purchaseVO) {
		
		//선택한 주문 결제 상태 변경
		sellerContentService.updateOrderByIdx(purchaseVO);
		

		return "redirect:sellerOrderManagePage";
	}
	
	
	//lhe-판매자 회원 관리 페이지 관련 맵핑
	@RequestMapping ("/sellerManageMember.do")
	public String memberManage(Model model, HttpSession sessionData){
		
		if(sessionData==null){
			
			return "loginForm";
		}

		//회원 리스트 불러오기
		ArrayList<MemberDataVO> memberDataList = new ArrayList<MemberDataVO>();
		memberDataList=sellerContentService.getAllMemberList();
			
		model.addAttribute("memberDataList", memberDataList);
		return "sellerMemberManagePage";
		
	}
	
	//lhe-판매자 회원 관리 페이지 복수 회원 탈퇴
	@RequestMapping("/sellerDeleteMemberByIdx.do")
		public String deleteMemberByIdxAction (ArrayList<MemberDataVO> memberVO) {
		
		//선택한 회원 리스트 지우기
		sellerContentService.deleteMemberByIdx(memberVO);
			
			return "redirect:sellerMemberManagePage";
		}
	
	//lhe-판매자 리뷰 관리 페이지 관련 맵핑
	@RequestMapping ("/sellerManageReview.do")
	public String reviewManage(Model model, HttpSession sessionData){
		
		if(sessionData==null){
			
			return "loginForm";
		}
		
		//리뷰 리스트 불러오기
		ArrayList<SellerContentVO> reviewDataList = new ArrayList<SellerContentVO>();
		reviewDataList = sellerContentService.getAllReviewList();
		
		model.addAttribute("reviewDataList", reviewDataList);
		

		
		return "sellerReviewManagePage";
	}
	
	//lhe-판매자 리뷰 관리 페이지 복수 리뷰 삭제
	@RequestMapping("/sellerDeleteReviewByIdx.do")
	public String deleteReviewByIdxAction (ArrayList<ContentDataVO> requestVO) {
		
		//선택한 리뷰 리스트 지우기
		sellerContentService.deleteReviewByIdx(requestVO);
		
		return "redirect:sellerReviewManagePage";
				
	}
	

	//lhe-판매자 QnA 관리 페이지 관련 맵핑
	@RequestMapping("/sellerManageQnA.do")
	public String qnaManagePage(Model model, HttpSession sessionData) {
		
		if(sessionData==null){
			
			return "loginForm";
		}

		
		ArrayList<SellerContentVO> qnaDataList = new ArrayList<SellerContentVO>();
		qnaDataList = sellerContentService.getAllQnAList();
		
		model.addAttribute("qnaDataList", qnaDataList);
		
		return "sellerQnAManagePage";		
	}
	
	
	//lhe-판매자 QnA 관리 페이지 복수 항목 삭제
	@RequestMapping("/sellerDeleteQnAByIdx.do")
	public String deleteQnAByIdxAction(ArrayList<ContentDataVO> requestVO) {
		
		//선택한 질문글 지우기
		sellerContentService.deleteQnAByIdx(requestVO);
		
		return "redirect:sellerQnAManagePage";
	}
	
	
	//lhe-판매자 지급관리 페이지 리스트 출력
	@RequestMapping("/sellerManagePaycheck.do")
	public String paycheckManagePage(Model model, HttpSession sessionData) {
		
		
		if(sessionData==null){
			
			return "loginForm";
		}
		
		
		ArrayList<SellerContentVO> paycheckDataList = new ArrayList<SellerContentVO>();
		paycheckDataList = sellerContentService.getAllPaycheckList();
		
		model.addAttribute("paycheckDataList", paycheckDataList);
		
		return "sellerPaycheckManagePage";		
	}
	
	//lhe-판매자 지급 관리 페이지 복수 항목 변경
	@RequestMapping("/sellerDeletePaycheckByIdx.do")
	public String updatePaycheckByIdxAction(ArrayList<PaycheckDataVO> requestVO) {
		
		//선택한 지급항목 변경하기
		sellerContentService.updatePaycheckByIdx(requestVO);
		
		
		return "redirect:sellerPaycheckManagePage";
	}
	
	//lhe: 상품 등록 페이지 맵핑
	@RequestMapping("/sellerNewProduct.do")
	public String newProductPage(){
		
		return "sellerNewProductPage";
	}

	
}
