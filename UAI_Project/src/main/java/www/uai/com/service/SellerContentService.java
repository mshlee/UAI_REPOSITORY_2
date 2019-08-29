package www.uai.com.service;

import java.util.ArrayList;

import org.json.JSONObject;

import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.AdvancedSearchDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.DashboardVO;
import www.uai.com.vo.IdxVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.SellerContentVO;

public interface SellerContentService {
	
	//lhe-판매자 관리 페이지 메인 리스트 출력용
	public ArrayList<ProductVO> getProductListForMain();
	public ArrayList<OrderDataVO> getOrderListForMain();
	public ArrayList<ContentDataVO> getQnaListForMain();
	public ArrayList<ContentDataVO> getReviewListForMain();


	//lhe-판매자 관리 페이지 리스트 출력용
	public ArrayList<ProductVO> getAllProductList(AdvancedSearchDataVO searchDataVO);
	public ArrayList<MemberDataVO> getAllMemberList(AdvancedSearchDataVO searchDataVO);
	public ArrayList<SellerContentVO> getAllOrderList(AdvancedSearchDataVO searchDataVO);
	public ArrayList<SellerContentVO> getAllReviewList(AdvancedSearchDataVO searchDataVO);
	public ArrayList<SellerContentVO> getAllQnAList(AdvancedSearchDataVO searchDataVO);
	public ArrayList<SellerContentVO> getAllPaycheckList(AdvancedSearchDataVO searchDataVO);
	
	//lhe-판매자 관리 페이지 단일 항목 삭제 및 상태 변경용
	public void deleteProductByIdx(String p_idx);
	public void deleteMemberByIdx(String m_idx);
	public void deletePostByIdx(String b_referIdx);
	public void updateOrderByIdx(String o_idx);
	public void updatePaycheckByIdx(String o_idx);
	
	//lhe-판매자 계정 생성/수정 관리용
	public AdminDataVO getAdminDataByIdx(String ad_idx);
	public void updateAdminByIdx(AdminDataVO requestVO);
	public void insertAdminData(AdminDataVO requestVO);
	
	//lhe-판매자 관리 페이지 복수 항목 삭제 및 상태 변경용 (arrayList 이용)
	public void deleteProductsByIdx(ArrayList<IdxVO> IdxVO);
	public void deleteMembersByIdx(ArrayList<IdxVO> IdxVO);
	public void deletePostsByIdx(ArrayList<IdxVO> IdxVO);
	public void updateOrdersByIdx(ArrayList<IdxVO> IdxVO);
	public void updatePaychecksByIdx(ArrayList<IdxVO> IdxVO);
	
	//lhe-판매자 대시보드 관리용
	public ArrayList<DashboardVO> getOrderStatList();
	

	
	

}
