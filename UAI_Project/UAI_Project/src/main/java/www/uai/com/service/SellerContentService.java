package www.uai.com.service;

import java.util.ArrayList;

import www.uai.com.vo.AdvancedSearchDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.PaycheckDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.PurchaseDataVO;
import www.uai.com.vo.SellerContentVO;

public interface SellerContentService {
	
	//lhe-판매자 관리 페이지 리스트 출력용
	public ArrayList<ProductVO> getAllProductList(AdvancedSearchDataVO searchDataVO);
	public ArrayList<MemberDataVO> getAllMemberList();
	public ArrayList<SellerContentVO> getAllOrderList();
	public ArrayList<SellerContentVO> getAllReviewList();
	public ArrayList<SellerContentVO> getAllQnAList();
	public ArrayList<SellerContentVO> getAllPaycheckList();
	
	//lhe-판매자 관리 페이지 복수 항목 삭제용-arrayList 이용
	public void deleteProductByIdx(ArrayList<ProductVO> productVO);
	public void deleteMemberByIdx(ArrayList<MemberDataVO> memberVO);
	public void deleteReviewByIdx(ArrayList<ContentDataVO> reviewVO);
	public void deleteQnAByIdx(ArrayList<ContentDataVO> qnaVO);

	//lhe-판매자 관리 페이지 복수 항목 상태 변경용-arrayList 이용
	public void updateOrderByIdx(ArrayList<PurchaseDataVO> requestVO);
	public void updatePaycheckByIdx(ArrayList<PaycheckDataVO> requestVO);

	
	
	
	

}
