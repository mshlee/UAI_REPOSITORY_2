package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import www.uai.com.vo.OrderDataVO;

public interface SellerContentSQLMapper {
	
	
	//lhe-판매자 상품 관리 페이지 복수 상품 목록 삭제용
	@Delete("DELETE FROM Product WHERE P_IDX=#{p_idx}")
	public void deleteProductByIdx(String p_idx);
	
	//lhe-판매자 회원 관리 페이지 복수 회원 목록 삭제용
	@Delete("DELETE FROM Members WHERE M_IDX=#{m_idx}")
	public void deleteMembersByIdx(String m_idx);
	
	//lhe-판매자 주문 관리 페이지 주문 리스트 출력용
	@Select("SELECT * FROM Orders")
	public ArrayList<OrderDataVO> getAllOrderList();
	
	//lhe-판매자 주문 관리 페이지 상세검색 리스트 출력용
	@Select("SELECT * FROM Orders WHERE ${value}")
	public ArrayList<OrderDataVO> getOrderListBySearchWord(String query);
	


	
	
	

}
