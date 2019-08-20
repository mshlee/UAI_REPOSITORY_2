package www.uai.com.service;

import java.util.ArrayList;

<<<<<<< HEAD
<<<<<<< HEAD
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
=======
=======
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
import www.uai.com.vo.AdvancedSearchDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.PaycheckDataVO;
<<<<<<< HEAD
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
=======
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.PurchaseDataVO;
import www.uai.com.vo.SellerContentVO;

public interface SellerContentService {
	
<<<<<<< HEAD
<<<<<<< HEAD
	//lhe-판매자 관리 페이지 리스트 출력용
=======
=======
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c

	//lhe-판매자 관리 페이지 리스트 출력용
	public ArrayList<ProductVO> getAllProductList(AdvancedSearchDataVO searchDataVO);
	public ArrayList<MemberDataVO> getAllMemberList();
<<<<<<< HEAD
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
=======
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
	public ArrayList<SellerContentVO> getAllOrderList();
	public ArrayList<SellerContentVO> getAllReviewList();
	public ArrayList<SellerContentVO> getAllQnAList();
	public ArrayList<SellerContentVO> getAllPaycheckList();
	
	//lhe-판매자 관리 페이지 복수 항목 삭제용-arrayList 이용
	public void deleteProductByIdx(ArrayList<ProductVO> productVO);
	public void deleteMemberByIdx(ArrayList<MemberDataVO> memberVO);
	public void deleteReviewByIdx(ArrayList<ContentDataVO> reviewVO);
	public void deleteQnAByIdx(ArrayList<ContentDataVO> qnaVO);
<<<<<<< HEAD
<<<<<<< HEAD
	
	//lhe-판매자 관리 페이지 복수 항목 상태 변경용-arrayList 이용
	public void updateOrderByIdx(ArrayList<PurchaseDataVO> requestVO);
	
=======
=======
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c

	//lhe-판매자 관리 페이지 복수 항목 상태 변경용-arrayList 이용
	public void updateOrderByIdx(ArrayList<PurchaseDataVO> requestVO);
	public void updatePaycheckByIdx(ArrayList<PaycheckDataVO> requestVO);

<<<<<<< HEAD
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
=======
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
	
	

}
