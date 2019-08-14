package www.uai.com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import www.uai.com.mapper.ProductSQLMapper;
import www.uai.com.service.ProductService;
import www.uai.com.vo.AdvancedSearchDataVO;
import www.uai.com.vo.PageVO;
import www.uai.com.vo.PostnumVO;
import www.uai.com.vo.ProductContentVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductNPageDataVO;
import www.uai.com.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductSQLMapper productSQLMapper;

	@Override
	public ProductNPageDataVO getProductList(Model model, int nowPage) {

		ProductNPageDataVO productDataList = new ProductNPageDataVO();

		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

		ArrayList<ProductDataVO> dataList = new ArrayList<ProductDataVO>();

		PageVO pageData = new PageVO(0, 0, 0);

		// 페이징 처리 구현

		pageData.setNowPage(nowPage);
		System.out.println(nowPage);

		// 한 페이지에 보여줄 게시글 개수 설정
		int limit = 10;

		// 한 페이지에 보여줄 페이지의 개수 설정
		int pageGroupLimit = 5;

		// 게시글 총 개수 가져오기
		int listCount = productSQLMapper.getListCount();
		System.out.println("리스트 총 개수 : " + listCount);

		// 끝페이지 설정
		int maxPage = (int) (Math.ceil((double) listCount / limit));
		System.out.println("끝 페이지 : " + maxPage);

		// 각 페이지 별 첫페이지&끝페이지 설정
		int startPage = (int) (Math.ceil((double) pageData.getNowPage() / pageGroupLimit));
		System.out.println("첫 페이지 : " + startPage);
		pageData.setStartOfPageGroup(startPage);
		int endPage = startPage + (pageGroupLimit - 1);
		if (endPage > maxPage) {
			pageData.setEndOfPageGroup(maxPage);
		} else {
			pageData.setEndOfPageGroup(endPage);
		}

		// 각 페이지 별 시작 게시글 번호와 끝 번호 설정
		int startPost = nowPage * limit - limit + 1;
		int endPost = nowPage * limit;
		PostnumVO postnum = new PostnumVO(startPost, endPost);

		///////////////

		productList = productSQLMapper.selectByPageNum(postnum);

		for (ProductVO product : productList) {

			ProductContentVO productContent = productSQLMapper.selectByIdx(product.getP_idx());

			ProductDataVO data = new ProductDataVO(product, productContent);

			dataList.add(data);
		}

		productDataList.setPageVO(pageData);
		productDataList.setProductDataList(dataList);

		return productDataList;

	}

	// lhe-상품전체리스트 출력용
	public ArrayList<ProductVO> getAllProductList(AdvancedSearchDataVO searchDataVO) {
		// TODO Auto-generated method stub
		/* 변수 확인용
		System.out.println(searchDataVO.getP_type());
		System.out.println(searchDataVO.getStartDate());
		System.out.println(searchDataVO.getEndDate());
		System.out.println(searchDataVO.getMinPrice());
		System.out.println(searchDataVO.getMaxPrice());
		System.out.println(searchDataVO.getKeyword());
		System.out.println(searchDataVO.getValue());
		System.out.println("---------------------");
			 */
		
		String p_type = searchDataVO.getP_type();
		String startDate = searchDataVO.getStartDate();
		String endDate = searchDataVO.getEndDate();
		String minPrice = searchDataVO.getMinPrice();
		String maxPrice = searchDataVO.getMaxPrice();
		String keyword = searchDataVO.getKeyword();
		String value = searchDataVO.getValue();
	
		
		//vo 객체 null값 여부 확인
		boolean isEmpty=false;
		
		if(p_type==null && startDate == null && minPrice == null && keyword == null) {
			isEmpty=true;
		}
		
		// lhe-상세검색기능 추가 (다중 조건 정렬 이용)
		ArrayList<ProductVO> dataList = new ArrayList<ProductVO>();
		
		if (isEmpty==true) {

			dataList = productSQLMapper.getAllProduct();


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
			
			dataList = productSQLMapper.getProductListBySearchWord(query);
			

		
	
			}
			return dataList;
		}
	}