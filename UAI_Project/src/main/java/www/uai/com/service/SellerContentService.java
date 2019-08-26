package www.uai.com.service;

import java.util.ArrayList;

import www.uai.com.vo.AdminDataVO;
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
	
	//lhe-판매자 관리 페이지 단일 항목 삭제 및 상태 변경용
	public void deleteProductByIdx(String p_idx);
	public void deleteMemberByIdx(String m_idx);
	public void deletePostByIdx(String b_referIdx);
	public void updateOrderByIdx(String o_idx);
	public void updatePaycheckByIdx(String o_idx);
	
	
	public AdminDataVO getAdminDataByIdx(String ad_idx);
	public void updateAdminByIdx(AdminDataVO requestVO);
	public void insertAdminData(AdminDataVO requestVO);
	
	//lhe-판매자 관리 페이지 복수 항목 삭제 및 상태 변경용 (arrayList 이용)
	public void deleteProductsByIdx(ArrayList<ProductVO> productVO);
	

	
	

}
