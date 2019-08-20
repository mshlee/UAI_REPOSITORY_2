package www.uai.com.service.impl;

public class AdvancedSearchQueryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//lhe-상세검색기능 추가 (다중 조건 정렬 이용)
			
			/*
			String p_type = searchDataVO.getP_type();
			String startDate = searchDataVO.getStartDate();
			String endDate = searchDataVO.getEndDate();
			String minPrice = searchDataVO.getMinPrice();
			String maxPrice = searchDataVO.getMaxPrice();
			String keyword = searchDataVO.getKeyword();
			String value = searchDataVO.getValue();
			*/
			
			String p_type="0";
			String startDate=null;
			String endDate="2019-01-01";
			String minPrice ="5000";
			String maxPrice = "10000";
			String keyword = "p_name";
			String value="강의";
			
			/*
			//변수 확인용
			System.out.println(p_type);
			System.out.println(startDate);
			System.out.println(endDate);
			System.out.println(minPrice);
			System.out.println(maxPrice);
			System.out.println(keyword);
			System.out.println(value);
			*/
			
			String query="";
			String andPhrase=" AND ";
			
				if(p_type!=null) {
					query+="P_TYPE="+p_type;
					query+=andPhrase;
				}
				if(startDate!=null && endDate!=null) {
					query+="P_POSTDATE BETWEEN "+startDate+" AND "+endDate;
					query+=andPhrase;
					}
				if(minPrice!=null && maxPrice!=null) {
					query+="P_ORIGINALPRICE BETWEEN "+minPrice+ " AND "+maxPrice;
					query+=andPhrase;
				}
				if(keyword!=null && value!=null) {
					query+=keyword.toUpperCase()+" LIKE %"+value+"%";
					query+=andPhrase;
				}
				
				
				query = query.substring(0, query.length()-5);		
				System.out.println(query);

	}

}
