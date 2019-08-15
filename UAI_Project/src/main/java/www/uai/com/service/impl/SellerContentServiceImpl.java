package www.uai.com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.uai.com.mapper.SellerContentSQLMapper;
import www.uai.com.service.SellerContentService;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.PaycheckDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.PurchaseDataVO;
import www.uai.com.vo.SellerContentVO;

@Service
public class SellerContentServiceImpl implements SellerContentService {
	
	@Autowired
	private SellerContentSQLMapper sellerContentSQLMapper;

	
	//lhe-판매자 상품 관리 목록 복수 항목 삭제
	@Override
	public void deleteProductByIdx(ArrayList<ProductVO> productVO) {
		// TODO Auto-generated method stub
		
		for(ProductVO product : productVO) {
			sellerContentSQLMapper.deleteProductByIdx(product.getP_idx());
		}
		
	}

	
	//lhe-판매자 회원 관리 목록 복수 항목 삭제
	@Override
	public void deleteMemberByIdx(ArrayList<MemberDataVO> memberVO) {
		// TODO Auto-generated method stub
		
		for(MemberDataVO members : memberVO) {
			sellerContentSQLMapper.deleteMembersByIdx(members.getM_idx());
		}

	}

	
	//lhe-판매자 주문 관리 목록 출력
	@Override
	public ArrayList<SellerContentVO> getAllOrderList() {
		// TODO Auto-generated method stub
		ArrayList<SellerContentVO> dataList = new ArrayList<SellerContentVO>();
		ArrayList<OrderDataVO> orderDataList = new ArrayList<OrderDataVO>();
		orderDataList = sellerContentSQLMapper.getAllOrderList();
		
		for(OrderDataVO orders : orderDataList) {
		ProductVO productVO = new ProductVO();
		MemberDataVO memberVO = new MemberDataVO();
		PurchaseDataVO purchaseVO = new PurchaseDataVO();
		
		productVO = sellerContentSQLMapper.getProductListByIdx(orders.getP_idx());
		memberVO = sellerContentSQLMapper.getMemberListByIdx(orders.getM_idx());
		purchaseVO = sellerContentSQLMapper.getPurchaseListByIdx(orders.getO_idx());
		
		SellerContentVO sellerVO = new SellerContentVO(productVO, orders, memberVO, purchaseVO,null);
		dataList.add(sellerVO);
		}
		
		
		return dataList;
	}

	//lhe-판매자 주문 관리 목록 복수 항목의 결제 상태 변경
	@Override
	public void updateOrderByIdx(ArrayList<PurchaseDataVO> requestVO) {
		// TODO Auto-generated method stub
		
		for(PurchaseDataVO purchaseVO : requestVO) {
			sellerContentSQLMapper.updatePurchaseByIdx(purchaseVO.getPch_isPaid(), purchaseVO.getO_idx());
		}
	
	}

	
	//lhe-판매자 리뷰 관리 목록 출력
	@Override
	public ArrayList<SellerContentVO> getAllReviewList() {
		// TODO Auto-generated method stub
		ArrayList<SellerContentVO> reviewDataList = new ArrayList<SellerContentVO>();
		ArrayList<ContentDataVO> reviewVO = new ArrayList<ContentDataVO>();
		
		
		for(ContentDataVO review : reviewVO) {
			MemberDataVO member = sellerContentSQLMapper.getMemberListByIdx(review.getM_idx());
			ProductVO product = sellerContentSQLMapper.getProductListByIdx(review.getP_idx());
			
			SellerContentVO sellerVO = new SellerContentVO(product, null, member, null, review);
			
			reviewDataList.add(sellerVO);
		}
		
		return reviewDataList;
	}

	//lhe-판매자 리뷰 관리 목록 복수 항목 삭제
	@Override
	public void deleteReviewByIdx(ArrayList<ContentDataVO> reviewVO) {
		// TODO Auto-generated method stub
		
		for (ContentDataVO review : reviewVO) {
			sellerContentSQLMapper.deletePostByIdx(review.getB_referidx());
		}
	}


	//lhe-판매자 qna 관리 목록 출력
	@Override
	public ArrayList<SellerContentVO> getAllQnAList() {
		// TODO Auto-generated method stub
		
		ArrayList<SellerContentVO> qnaDataList = new ArrayList<SellerContentVO>();
		ArrayList<ContentDataVO> qnaVO = new ArrayList<ContentDataVO>();
		
		for(ContentDataVO qna : qnaVO) {
			MemberDataVO member = sellerContentSQLMapper.getMemberListByIdx(qna.getM_idx());
			ProductVO product = sellerContentSQLMapper.getProductListByIdx(qna.getP_idx());
			
			SellerContentVO sellerVO = new SellerContentVO(product, null, member, null, qna);
			
			qnaDataList.add(sellerVO);
		}
		
		return qnaDataList;
	}

	//lhe-판매자 qna 관리 목록 복수 항목 삭제
	@Override
	public void deleteQnAByIdx(ArrayList<ContentDataVO> qnaVO) {
		// TODO Auto-generated method stub
		
		for (ContentDataVO qna : qnaVO) {
			sellerContentSQLMapper.deletePostByIdx(qna.getB_referidx());
		}
		
	}

	//lhe-판매자 지급 관리 목록 페이지 출력 (미완)
	@Override
	public ArrayList<SellerContentVO> getAllPaycheckList() {
		// TODO Auto-generated method stub
		
		ArrayList<PaycheckDataVO> paycheckVO = new ArrayList<PaycheckDataVO>();
		paycheckVO = sellerContentSQLMapper.getAllPaycheckList();
		
	
		
		return null;
	}
	
	
	
	
	
	
	

}
