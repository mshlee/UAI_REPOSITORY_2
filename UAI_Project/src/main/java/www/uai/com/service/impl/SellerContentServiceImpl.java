package www.uai.com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.uai.com.mapper.SellerContentSQLMapper;
import www.uai.com.service.SellerContentService;
import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.AdvancedSearchDataVO;
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
	
	
	//lhe-어드민 계정 생성
	@Override
	public void insertAdminData(AdminDataVO requestVO) {
		// TODO Auto-generated method stub
		String ad_idx = sellerContentSQLMapper.newAdIdx();
		sellerContentSQLMapper.insertAdminData(ad_idx, requestVO.getAd_id(), requestVO.getAd_pw(), requestVO.getAd_nick());
		
	}
	
	
	//lhe-어드민 계정 정보 수정
	@Override
	public AdminDataVO getAdminDataByIdx(String ad_idx) {
		// TODO Auto-generated method stub
		
		AdminDataVO adminData = sellerContentSQLMapper.getAdminDataByIdx(ad_idx);
	
		return adminData;
	}

	@Override
	public void updateAdminByIdx(AdminDataVO requestVO) {
		// TODO Auto-generated method stub
		sellerContentSQLMapper.updateAdminByIdx(requestVO.getAd_pw(), requestVO.getAd_nick(), requestVO.getAd_idx());
		
	}

	//판매자 상품 리스트 출력
	@Override
	public ArrayList<ProductVO> getAllProductList(AdvancedSearchDataVO searchDataVO) {
		// TODO Auto-generated method stub

		String p_type = searchDataVO.getP_type();
		String startDate = searchDataVO.getStartDate();
		String endDate = searchDataVO.getEndDate();
		String minPrice = searchDataVO.getMinPrice();
		String maxPrice = searchDataVO.getMaxPrice();
		String keyword = searchDataVO.getKeyword();
		String value = searchDataVO.getValue();

		// vo 객체 null값 여부 확인
		boolean isEmpty = false;

		if (p_type == null && startDate == null && minPrice == null && keyword == null) {
			isEmpty = true;
		}
		

		// lhe-상세검색기능 추가 (다중 조건 정렬 이용)
		ArrayList<ProductVO> productDataList = new ArrayList<ProductVO>();
		

		if (isEmpty==true) {


		productDataList = sellerContentSQLMapper.getAllProductList();

	
			
		} else if (isEmpty==false) {
			
			
			//empty string 예외처리
			if(p_type.length()==0) {
				p_type=null;
			}if(startDate.length()==0) {
				startDate=null;
			}if(minPrice.length()==0) {
				minPrice=null;
			}if(keyword.length()==0) {
				keyword=null;
			}if(value.length()==0) {
				value=null;
			}
			
			String query = "";
			String andPhrase = " AND ";

			if (p_type != null) {
				query += "P_TYPE=" + p_type;
				query += andPhrase;
			}if (startDate != null && endDate != null) {
				query += "P_POSTDATE BETWEEN " + "'"+startDate +"'"+ " AND " + "'"+endDate+"'";
				query += andPhrase;
			}if (minPrice != null && maxPrice != null) {
				query += "P_ORIGINALPRICE BETWEEN " + minPrice + " AND " + maxPrice;
				query += andPhrase;
			}if (keyword != null && value != null) {
				query += keyword.toUpperCase() + " LIKE "+ "'%'" + "'"+value +"'"+ "'%'" ;
				query += andPhrase;
			}
			
			
			query = query.substring(0, query.length() - 4);
			System.out.println(query);
			
			productDataList = sellerContentSQLMapper.getProductListBySearchWord(query);
			
			}

	
		return productDataList;
	}

	// lhe-판매자 상품 관리 목록 단일 항목 삭제
	@Override
	public void deleteProductByIdx(String p_idx) {
		// TODO Auto-generated method stub
		
		sellerContentSQLMapper.deleteProudctByIdx(p_idx);

	}
	
	// lhe-판매자 상품 관리 목록 복수 항목 삭제
	@Override
	public void deleteProductsByIdx(ArrayList<ProductVO> productVO) {
		// TODO Auto-generated method stub
		
		for(ProductVO product : productVO) {
		
		sellerContentSQLMapper.deleteProudctByIdx(product.getP_idx());
		}
		
	}


	
	//lhe-판매자 회원 관리 리스트 출력
	@Override
	public ArrayList<MemberDataVO> getAllMemberList() {
		// TODO Auto-generated method stub
		
		ArrayList<MemberDataVO> memberDataList = new ArrayList<MemberDataVO>();
		
		memberDataList = sellerContentSQLMapper.getAllMemberList();

		
		return memberDataList;
		
	}


	// lhe-판매자 회원 관리 목록 단일 항목 삭제
	@Override
	public void deleteMemberByIdx(String m_idx) {
		// TODO Auto-generated method stub

		sellerContentSQLMapper.deleteMemberByIdx(m_idx);
	}

	// lhe-판매자 주문 관리 목록 출력
	@Override
	public ArrayList<SellerContentVO> getAllOrderList() {
		// TODO Auto-generated method stub
		ArrayList<SellerContentVO> dataList = new ArrayList<SellerContentVO>();
		ArrayList<OrderDataVO> orderDataList = new ArrayList<OrderDataVO>();
		orderDataList = sellerContentSQLMapper.getAllOrderList();

		for (OrderDataVO orders : orderDataList) {
			ProductVO productVO = new ProductVO();
			MemberDataVO memberVO = new MemberDataVO();
			PurchaseDataVO purchaseVO = new PurchaseDataVO();

			productVO = sellerContentSQLMapper.getProductListByIdx(orders.getP_idx());
			memberVO = sellerContentSQLMapper.getMemberListByIdx(orders.getM_idx());
			purchaseVO = sellerContentSQLMapper.getPurchaseListByIdx(orders.getO_idx());

			SellerContentVO sellerVO = new SellerContentVO(productVO, orders, memberVO, purchaseVO, null, null);
			dataList.add(sellerVO);
		}

		return dataList;
	}

	// lhe-판매자 주문 관리 목록 단일 항목의 결제 상태 변경
	@Override
	public void updateOrderByIdx(String o_idx) {
		// TODO Auto-generated method stub

			sellerContentSQLMapper.updatePurchaseByIdx(o_idx);
	
	}
	
	

	// lhe-판매자 리뷰 관리 목록 출력
	@Override
	public ArrayList<SellerContentVO> getAllReviewList() {
		// TODO Auto-generated method stub
		ArrayList<SellerContentVO> reviewDataList = new ArrayList<SellerContentVO>();
		ArrayList<ContentDataVO> reviewVO = sellerContentSQLMapper.getAllReviewList();

		for (ContentDataVO review : reviewVO) {
			MemberDataVO member = sellerContentSQLMapper.getMemberListByIdx(review.getM_idx());
			ProductVO product = sellerContentSQLMapper.getProductListByIdx(review.getP_idx());

			SellerContentVO sellerVO = new SellerContentVO(product, null, member, null, review, null);

			reviewDataList.add(sellerVO);
		}

		return reviewDataList;
	}

	// lhe-판매자 리뷰&Qna 관리 목록 단일 항목 삭제
	@Override
	public void deletePostByIdx(String b_referIdx) {
		// TODO Auto-generated method stub

			sellerContentSQLMapper.deletePostByIdx(b_referIdx);
		
	}

	// lhe-판매자 qna 관리 목록 출력
	@Override
	public ArrayList<SellerContentVO> getAllQnAList() {
		// TODO Auto-generated method stub

		ArrayList<SellerContentVO> qnaDataList = new ArrayList<SellerContentVO>();
		ArrayList<ContentDataVO> qnaVO = sellerContentSQLMapper.getAllQnAList();

		for (ContentDataVO qna : qnaVO) {
			MemberDataVO member = sellerContentSQLMapper.getMemberListByIdx(qna.getM_idx());
			ProductVO product = sellerContentSQLMapper.getProductListByIdx(qna.getP_idx());

			SellerContentVO sellerVO = new SellerContentVO(product, null, member, null, qna, null);

			qnaDataList.add(sellerVO);
		}

		return qnaDataList;
	}


	// lhe-판매자 지급 관리 목록 페이지 출력
	@Override
	public ArrayList<SellerContentVO> getAllPaycheckList() {
		// TODO Auto-generated method stub

		ArrayList<SellerContentVO> paycheckDataList = new ArrayList<SellerContentVO>();
		ArrayList<PaycheckDataVO> paycheckVO = sellerContentSQLMapper.getAllPaycheckList();

		for (PaycheckDataVO paycheck : paycheckVO) {

			OrderDataVO order = sellerContentSQLMapper.getOrderListByIdx(paycheck.getO_idx());
			ProductVO product = sellerContentSQLMapper.getProductListByIdx(order.getP_idx());

			SellerContentVO sellerVO = new SellerContentVO(product, order, null, null, null, paycheck);

			paycheckDataList.add(sellerVO);
		}

		return paycheckDataList;
	}

	// lhe-판매자 지급 관리 목록 단일 항목 지급완료 처리
	@Override
	public void updatePaycheckByIdx(String o_idx) {
		// TODO Auto-generated method stub
		

		sellerContentSQLMapper.updatePaycheckByIdx(o_idx);
	
		
	}


		
	
	

}
