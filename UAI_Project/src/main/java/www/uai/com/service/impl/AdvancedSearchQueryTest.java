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



		} else */
		
		
		String startDate = "";
		String endDate = "";
		String radiobox = "";
		String radioboxValue = "";
		String keyword = "";
		String value = "";
		
		
		if (true) {
			
			/*
			if(startDate.length()==0) {
				startDate=null;
			}if(endDate.length()==0) {
				startDate=null;
			}if(radioboxValue.length()==0) {
				radioboxValue=null;
			}if(keyword.length()==0) {
				keyword=null;
			}if(value.length()==0) {
				value=null;
			}
			*/

		
			String query = "";
		
			String andPhrase = " AND ";
		
			if (startDate != null && endDate != null) {
				//query = query.substring(0, query.length() - 5);
				query += "M_JOINDATE BETWEEN " + "'" + startDate + "'" + " AND " + "'" + endDate + "'";
				query += andPhrase;
			}
			if (radiobox != null && radioboxValue != null) {
				//query = query.substring(0, query.length() - 5);
				query += "M_GENDER= " + radioboxValue;
				query += andPhrase;
			}
			if (keyword != null && value != null) {
				//query = query.substring(0, query.length() - 5);
				
				if(keyword=="M_IDX") {
					query += "M_IDX= " + value;
					query += andPhrase;
				}else {
					query += keyword.toUpperCase() + " LIKE " + "'%'" + "'" + value + "'" + "'%'";
					query += andPhrase;
				}
					
					
				
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
