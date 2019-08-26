package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.PaycheckDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.PurchaseDataVO;

public interface SellerContentSQLMapper {
	

	//lhe-어드민 계정 관리용
	@Select("SELECT Admin_seq.NEXTVAL FROM DUAL")
	public String newAdIdx();
	
	@Insert("INSERT INTO Admins VALUES (#{ad_idx}, #{ad_id}, #{ad_pw}, #{ad_nick}")
	public void insertAdminData(String ad_idx, String ad_id, String ad_pw, String ad_nick);
	
	@Select("SELECT * FROM Admins WHERE ad_idx=#{ad_idx}")
	public AdminDataVO getAdminDataByIdx(String ad_idx);

	@Update ("UPDATE Admins SET AD_PW = #{ad_pw}, AD_NICK=#{ad_nick} WHERE AD_IDX=#{ad_idx}")
	public void updateAdminByIdx(String ad_pw, String ad_nick, String ad_idx);


	//lhe-판매자 상품 관리 페이지 리스트 출력용
	@Select ("SELECT * FROM Product ORDER BY P_IDX")
	public ArrayList<ProductVO> getAllProductList();
	
	//lhe-판매자 주문 관리 페이지 주문 리스트 출력용
	@Select("SELECT * FROM Orders")
	public ArrayList<OrderDataVO> getAllOrderList();
	
	//lhe-판매자 회원 관리 페이지 리스트 출력용
	@Select ("SELECT * FROM Members ORDER BY M_IDX")
	public ArrayList<MemberDataVO> getAllMemberList();
	
	//lhe-판매자 리뷰 관리 페이지 리스트 출력용
	@Select("SELECT * FROM Board_Content WHERE B_TYPE=1 AND B_ISPOST=1 ORDER BY B_IDX")
	public ArrayList<ContentDataVO> getAllReviewList();
		
	//lhe-판매자 qna 관리 페이지 리스트 출력용
	@Select("SELECT * FROM Board_Content WHERE B_TYPE=2 AND B_ISPOST=1 ORDER BY B_IDX")
	public ArrayList<ContentDataVO> getAllQnAList();
	
	//lhe- 판매자 지급 관리 페이지 리스트 출력용
	@Select("SELECT * FROM Paycheck_Data")
	public ArrayList<PaycheckDataVO> getAllPaycheckList();

	
	
	//lhe-인덱스 기준 출력
	@Select ("SELECT * FROM Product WHERE P_IDX=#{p_idx}")
	public ProductVO getProductListByIdx(String p_idx);
	
	@Select("SELECT * FROM Purchase WHERE O_IDX=#{o_idx}")
	public PurchaseDataVO getPurchaseListByIdx(String o_idx);
	
	@Select("SELECT * FROM Members WHERE M_IDX=#{m_idx}")
	public MemberDataVO getMemberListByIdx(String m_idx);
	
	@Select("SELECT * FROM Admins WHERE AD_IDX=#{ad_idx}")
	public AdminDataVO getAdminListByIdx(String ad_idx);

	
	@Select("SELECT * FROM Orders WHERE O_IDX=#{o_idx}")
	public OrderDataVO getOrderListByIdx(String o_idx);

	

	//lhe-판매자 주문 관리 페이지 상세검색 리스트 출력용
	@Select("SELECT * FROM Orders WHERE ${value}")
	public ArrayList<OrderDataVO> getOrderListBySearchWord(String query);
	
	//lhe-판매자 상품 관리 상세검색용
	@Select ("SELECT * FROM PRODUCT WHERE ${value}")
	public ArrayList<ProductVO> getProductListBySearchWord(String query);
	
	
	

	//lhe-판매자 상품 관리 페이지 단일 상품 삭제용
	@Update("DELETE FROM Product WHERE P_IDX=#{p_idx}")
	public void deleteProudctByIdx(String p_idx);
	
	//lhe-판매자 회원 관리 페이지 단일 회원 탈퇴용
	@Update("DELETE FROM Members WHERE M_IDX=#{m_idx}")
	public void deleteMemberByIdx(String m_idx);
	
	//lhe-판매자 리뷰&질문글 관리 페이지 단일 게시물 삭제용
	@Update("DELETE FROM Board_Content WHERE B_TYPE=#{b_type} AND B_REFERIDX=#{b_referidx}")
	public void deletePostByIdx(String b_type, String p_idx);
	
	//lhe-판매자 주문 관리 페이지 복수 주문 결제상태 변경용
	@Update("UPDATE Purchase SET PCH_ISPAID=#{pch_ispaid} WHERE o_idx=#{o_idx}")
	public void updatePurchaseByIdx(String pch_ispaid, String o_idx);

	//lhe-판매자 지급 관리 페이지 복수 건 지급상태 변경용
	@Update("UPDATE Paycheck_Data SET PD_ISPAIDTOTEACHER=#{pd_isPaidToTeacher} WHERE o_idx=#{o_idx}")
	public void updatePaycheckByIdx(String pd_isPaidToTeacher, String o_idx);


	/*
	
	//lhe-판매자 상품 관리 페이지 복수 상품 목록 삭제용
	@Delete("DELETE FROM Product WHERE P_IDX=#{p_idx}")
	public void deleteProductsByIdx(String p_idx);
	
	//lhe-판매자 회원 관리 페이지 복수 목록 삭제용
	@Delete("DELETE FROM Members WHERE M_IDX=#{m_idx}")
	public void deleteMembersByIdx(String m_idx);
	

	//lhe-판매자 리뷰&질문글 관리 페이지 복수 목록 삭제용
	@Delete ("DELETE FROM Board_Content WHERE B_REFERIDX=#{b_referidx}")
	public void deletePostsByIdx(String b_referidx);
	
	//lhe-판매자 주문 관리 페이지 복수 주문 결제상태 변경용
	@Update("UPDATE Purchase SET PCH_ISPAID=#{pch_ispaid} WHERE o_idx=#{o_idx}")
	public void updatePurchasesByIdx(String pch_ispaid, String o_idx);


	//lhe-판매자 지급 관리 페이지 복수 건 지급상태 변경용
	@Update("UPDATE Paycheck_Data SET PD_ISPAIDTOTEACHER=#{pd_isPaidToTeacher} WHERE o_idx=#{o_idx}")
	public void updatePaychecksByIdx(String pd_isPaidToTeacher, String o_idx);

	*/

	


	

}