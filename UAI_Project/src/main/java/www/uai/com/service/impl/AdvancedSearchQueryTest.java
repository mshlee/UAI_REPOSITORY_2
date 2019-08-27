package www.uai.com.service.impl;

import java.util.ArrayList;

import www.uai.com.vo.ProductVO;

public class AdvancedSearchQueryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// lhe-상세검색기능 추가 (다중 조건 정렬 이용)

		/*
		 * String p_type = searchDataVO.getP_type(); String startDate =
		 * searchDataVO.getStartDate(); String endDate = searchDataVO.getEndDate();
		 * String minPrice = searchDataVO.getMinPrice(); String maxPrice =
		 * searchDataVO.getMaxPrice(); String keyword = searchDataVO.getKeyword();
		 * String value = searchDataVO.getValue();
		 */

		String p_type = "";
		String startDate = "";
		String endDate = "";
		String minPrice = "";
		String maxPrice = "";
		String keyword = "";
		String value = "";
		/*
		// empty string 예외처리
		if (p_type.length() == 0) {
			p_type = null;
		}
		if (startDate.length() == 0) {
			startDate = null;
		}
		if (minPrice.length() == 0) {
			minPrice = null;
		}
		if (keyword.length() == 0) {
			keyword = null;
		}
		if (value.length() == 0) {
			value = null;
		}

		// vo 객체 null값 여부 확인
		//boolean isEmpty = false;

		if (p_type == null && startDate == null && minPrice == null && keyword == null) {
			isEmpty = true;
		}
		
		System.out.println("검색조건 null 여부 확인:" + isEmpty);

		// lhe-상세검색기능 추가 (다중 조건 정렬 이용)
		ArrayList<ProductVO> productDataList = new ArrayList<ProductVO>();

		if (isEmpty == true) {

			System.out.println("검색조건없음");

		} else */if (true) {

			String queryHead = "SELECT * FROM PRODUCT WHERE";
			String query = " AND ";
			System.out.println(query.length());
			String andPhrase = " AND ";
			if (p_type != null) {
				query = query.substring(0, query.length() - 5);
				query += "P_TYPE=" + p_type;
				query += andPhrase;
			}
			if (startDate != null && endDate != null) {
				query = query.substring(0, query.length() - 5);
				query += "P_POSTDATE BETWEEN " + "'" + startDate + "'" + " AND " + "'" + endDate + "'";
				query += andPhrase;
			}
			if (minPrice != null && maxPrice != null) {
				query = query.substring(0, query.length() - 5);
				query += "P_ORIGINALPRICE BETWEEN " + minPrice + " AND " + maxPrice;
				query += andPhrase;
			}
			if (keyword != null && value != null) {
				query = query.substring(0, query.length() - 5);
				query += keyword.toUpperCase() + " LIKE " + "'%'" + "'" + value + "'" + "'%'";
				query += andPhrase;
			}

			query = query.substring(0, query.length() - 5);
			/*
			if(query.length()<1) {
				productDataList = sellerContentSQLMapper.getAllProductList();
			}else {
				queryHead += query;
				productDataList = sellerContentSQLMapper.getProductListBySearchWord(query);
			}
			*/
			System.out.println(query);

		}

	}
}
