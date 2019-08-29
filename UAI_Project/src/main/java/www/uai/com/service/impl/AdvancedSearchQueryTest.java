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
		
		
		String startDate = "2018-01-01";
		String endDate = "";
		String minPrice = "";
		String maxPrice = "";
		String radioboxValue = "on";
		String checkboxValue = "0";
		String keyword = "P_IDX";
		String value = "tie";
		
		
		if (true) {
			
			
			if(startDate.length()==0) {
				startDate=null;
			}if(endDate.length()==0) {
				endDate=null;
			}if (minPrice.length() == 0) {
				minPrice = null;
			}if (maxPrice.length() == 0) {
				maxPrice = null;
			}
			if(radioboxValue=="on") {
				radioboxValue=null;
			}/*if(checkboxValue=="on") {
				checkboxValue=null;
			}
			*/
			if(keyword.length()==0) {
				keyword=null;
			}if(value.length()==0) {
				value=null;
			}
			

		
			String query = "";
			String andPhrase = " AND ";
		
			if (startDate != null || endDate != null) {
				
				if(startDate==null || endDate ==null){
				
				}else {
					//query = query.substring(0, query.length() - 5);
					query += "PD_PAIDDATE BETWEEN " + "'" + startDate + "'" + " AND " + "'" + endDate + "'";
					query += andPhrase;
				}
				
			}
			
			if (minPrice != null && maxPrice != null) {
				
				//query = query.substring(0, query.length() - 5);
				query += "PD_TOTALPAYMENTTOTEACHER BETWEEN " + minPrice + " AND " + maxPrice;
				query += andPhrase;
				
			}
			
			
			if (radioboxValue != null) {
				//query = query.substring(0, query.length() - 5);
				query += "PD_ISPAIDTOTEACHER= " + radioboxValue;
				query += andPhrase;
			}
			/*
			if (checkboxValue != null) {
				//query = query.substring(0, query.length() - 5);
				query += "O_PAYMENTMETHOD= " + checkboxValue;
				query += andPhrase;
			}
			*/
			if (keyword != null && value != null) {
				//query = query.substring(0, query.length() - 5);
				
				if(keyword=="O_IDX") {
					query += "M_IDX= " + value;
					query += andPhrase;
				}else if(keyword=="P_IDX") {
					query += "P_IDX= " + value;
					query += andPhrase;
				}else {
					query += keyword.toUpperCase() + " LIKE " + "'%" + value + "%'";
					query += andPhrase;
				}					
				
			}

			query = query.substring(0, query.length() - 5);
		
			System.out.println(query);

		}

	}
}
