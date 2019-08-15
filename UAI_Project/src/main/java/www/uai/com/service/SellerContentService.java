package www.uai.com.service;

import java.util.ArrayList;

import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.ProductVO;

public interface SellerContentService {
	
	//lhe-판매자 관리 페이지 리스트 출력용
	public ArrayList<OrderDataVO> getAllOrderList();
	
	//lhe-판매자 관리 페이지 복수 항목 삭제용-arrayList 이용
	public void deleteProductByIdx(ArrayList<ProductVO> productVO);
	public void deleteMemberByIdx(ArrayList<MemberDataVO> memberVO);
	

}
