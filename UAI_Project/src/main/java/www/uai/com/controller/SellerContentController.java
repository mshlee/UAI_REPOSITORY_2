package www.uai.com.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import www.uai.com.service.ProductService;
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
import www.uai.com.vo.UploadProductFileVO;

//판매자 관리 페이지용 컨트롤러

@Controller
public class SellerContentController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SellerContentService sellerContentService;
	
	
	//lhe-판매자 관리자 계정 관리에 대한 페이지들...
	@RequestMapping("/sellerManageAdmin")

	public String sellerAccountMainPage(SessionDataVO sessionVO) {
	
		return "sellerAccountManageMainPage";
	}
	
	@RequestMapping("/sellerAdminEdit")
	public String sellerAccountEditPage(Model model, String ad_idx) {
		
		//String ad_idx = (String) sessionVO.getAttribute("ad_idx");
		
		//SessionDataVO sessionData = (SessionDataVO) sessionVO;
		
		AdminDataVO adminData = sellerContentService.getAdminDataByIdx(ad_idx);
		
		System.out.println(adminData.getAd_idx());
		System.out.println(adminData.getAd_id());
		System.out.println(adminData.getAd_nick());
		
		model.addAttribute("adminData", adminData);
		
		
		return "sellerAccountEditPage";
	}
	
	@RequestMapping("/sellerAdminEditAction")
	public String sellerAccountEditAction(AdminDataVO requestVO) {
		
		sellerContentService.updateAdminByIdx(requestVO);
		
		return "redirect:sellerMainPage";
	}
	
	@RequestMapping("/sellerNewAdmin")
	public String sellerNewAccountPage(SessionDataVO sessionVO) {
		
		return "sellerNewAccountPage";
	}
	
	@RequestMapping("/sellerNewAdminAction")
	public String sellerNewAdminAction(AdminDataVO requestVO) {
		
		sellerContentService.insertAdminData(requestVO);
		
		return "redirect:sellerAccountManageMainPage";
		
	}
	
	
	//관리자 메인 페이지
	@RequestMapping ("/sellerIndex")
	public String sellerMainPage(HttpSession session){

		if(session!=null) {
			return "sellerMainPage";
		}else {
			
		}
		
		return "mainPage";
		
	}
	
	
	//lhe-판매자 상품 관리 페이지 관련 맵핑
	@RequestMapping ("/sellerManageProduct")
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
	
	//lhe-판매자 단일 상품 삭제 명령
	@RequestMapping("/sellerDeleteProductByIdx")
	public String deleteProductByIdxAction (String p_idx) {
		
		//선택한 상품 목록 지우기
		sellerContentService.deleteProductByIdx(p_idx);
		
		return "redirect:sellerManageProduct";
		
	}
	
	
	/*
	//lhe-판매자 상품 관리 페이지 복수 상품 삭제 명령

	@RequestMapping("/sellerDeleteProductByIdx.do")
	public String deleteProductByIdxAction (ArrayList<ProductVO> productVO) {
		
		//선택한 상품 목록 지우기
		sellerContentService.deleteProductByIdx(productVO);
		
		return "redirect:sellerManageProduct.do";

	}
	*/
	
	
	//lhe-판매자 주문 관리 페이지 관련 맵핑
	@RequestMapping ("/sellerManageOrder")
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

	
	@RequestMapping("/sellerUpdateOrderByIdx")
	public String updateOrderByIdxAction(String pch_ispaid, String o_idx) {
		
		//선택한 주문 결제 상태 변경
		sellerContentService.updateOrderByIdx(pch_ispaid, o_idx);
		

		return "redirect:sellerOrderManagePage";
	}
	
	
	//lhe-판매자 회원 관리 페이지 관련 맵핑
	@RequestMapping ("/sellerManageMember")
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
	@RequestMapping("/sellerDeleteMemberByIdx")
		public String deleteMemberByIdxAction (String m_idx) {
		
		//선택한 회원 리스트 지우기
		sellerContentService.deleteMemberByIdx(m_idx);
			
			return "redirect:sellerMemberManagePage";
		}
	
	//lhe-판매자 리뷰 관리 페이지 관련 맵핑
	@RequestMapping ("/sellerManageReview")
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
	
	//lhe-판매자 리뷰 관리 페이지 단일 리뷰 삭제
	@RequestMapping("/sellerDeleteReviewByIdx")
	public String deleteReviewByIdxAction (String b_type, String b_referidx) {
		
		//선택한 리뷰 리스트 지우기
		sellerContentService.deletePostByIdx(b_type, b_referidx);
		
		return "redirect:sellerReviewManagePage";
				
	}
	

	//lhe-판매자 QnA 관리 페이지 관련 맵핑
	@RequestMapping("/sellerManageQnA")
	public String qnaManagePage(Model model, HttpSession sessionData) {
		
		if(sessionData==null){
			
			return "loginForm";
		}

		
		ArrayList<SellerContentVO> qnaDataList = new ArrayList<SellerContentVO>();
		qnaDataList = sellerContentService.getAllQnAList();
		
		model.addAttribute("qnaDataList", qnaDataList);
		
		return "sellerQnAManagePage";		
	}
	
	
	//lhe-판매자 QnA 관리 페이지 단일 항목 삭제
	@RequestMapping("/sellerDeleteQnAByIdx")
	public String deleteQnAByIdxAction(String b_type, String b_referidx) {
		
		//선택한 질문글 지우기
		sellerContentService.deletePostByIdx(b_type, b_referidx);
		
		return "redirect:sellerQnAManagePage";
	}
	
	
	//lhe-판매자 지급관리 페이지 리스트 출력
	@RequestMapping("/sellerManagePaycheck")
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
	@RequestMapping("/sellerUpdatePaycheckByIdx")
	public String updatePaycheckByIdxAction(String o_idx, String pd_isPaidToTeacher) {
		
		//선택한 지급항목 변경하기
		sellerContentService.updatePaycheckByIdx(pd_isPaidToTeacher, o_idx);
		
		
		return "redirect:sellerPaycheckManagePage";
	}
	
	
	 //lhe: 상품 등록 페이지 맵핑
	 @RequestMapping("/sellerNewProduct")
	 public String newProductPage(){
	  
	  return "sellerNewProductPage";
	 }
	 
	//jys: 상품 등록 기능 맵핑
	 @RequestMapping("/newProductAction")
	 public String newProductAction(MultipartFile [] files, ProductVO ProductVOParam, UploadProductFileVO UploadProductFileVOParam, HttpSession session, HttpServletRequest request) {
	  
	  ArrayList<UploadProductFileVO> fileList = new ArrayList<UploadProductFileVO>();
	      
	      //파일 업로드 처리...
	      String uploadRootFolderName = request.getSession().getServletContext().getRealPath("/uploadimg/");
	      //System.out.println(uploadRootFolderName);
	      
	      for(MultipartFile file : files) {
	         
	         //예외 처리
	         if(file.getSize() ==0)
	            continue;
	         String originalname = file.getOriginalFilename();
	          //중복 파일 명 제거 위해 파일명 바꾸기 - 방법은 많음
	         String randomFileName = UUID.randomUUID().toString();
	          randomFileName += originalname.substring(originalname.lastIndexOf('.'));
	          System.out.println("저장 될 파일 명 : " + uploadRootFolderName + randomFileName );
	          //저장
	        try {
	        file.transferTo(new File(uploadRootFolderName + randomFileName ));
	        }catch(Throwable e) {
	           e.printStackTrace();
	        }
	        //Data 생성 ...
	        String path = request.getContextPath();
	        
	        path += "/uploadimg/";
	        path += randomFileName;
	        
	        UploadProductFileVO productFileVO = new UploadProductFileVO(null,null,path,originalname);
	        
	        fileList.add(productFileVO);
	        
	      }

	    
	    
	  //SessionDataVO sessionData = (SessionDataVO)session.getAttribute("sessionData");
	  
	  //String ad_idx = sessionData.getAd_idx();
	  
	  //테스트
	  String p_originalPrice = ProductVOParam.getP_originalPrice();
	  ProductVOParam.setP_nowPrice(p_originalPrice);
	  
	  productService.writeNewProduct(ProductVOParam, fileList);
	  
	  return "redirect:/sellerManageProduct";
	 }



	
	
	
}
