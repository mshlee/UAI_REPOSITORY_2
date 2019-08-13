package www.uai.com.service.impl;

import java.util.ArrayList;

import org.springframework.ui.Model;

import www.uai.com.mapper.ProductSQLMapper;
import www.uai.com.service.ProductService;
import www.uai.com.vo.PageVO;
import www.uai.com.vo.PostnumVO;
import www.uai.com.vo.ProductContentVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductNPageDataVO;
import www.uai.com.vo.ProductVO;

public class ProductServiceImpl implements ProductService{
	
	private ProductSQLMapper productSQLMapper;

	@Override
	public ProductNPageDataVO getProductList(Model model, int nowPage) {
		
		ProductNPageDataVO productDataList = new ProductNPageDataVO();
		
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		
		ArrayList<ProductDataVO> dataList = new ArrayList<ProductDataVO>();
		
		PageVO pageData = new PageVO(0,0,0,0,0);
		
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
		int maxPage = (int)(Math.ceil((double) listCount/limit));       
		System.out.println("끝 페이지 : "+ maxPage);
		
		// 각 페이지 별 첫페이지&끝페이지 설정
		int startPage = (int)(Math.ceil((double) pageData.getNowPage()/pageGroupLimit));
		System.out.println("첫 페이지 : " +startPage);
		pageData.setStartOfPageGroup(startPage);
		int endPage = startPage + (pageGroupLimit -1);                                                                       
		if(endPage > maxPage) {                                                                            
		    pageData.setEndOfPageGroup(maxPage);                                           
		}else {
			pageData.setEndOfPageGroup(endPage);
		}
		
		// 각 페이지 별 시작 게시글 번호와 끝 번호 설정
		int startPost = nowPage*limit-limit+1;
		int endPost = nowPage*limit;
		PostnumVO postnum = new PostnumVO(startPost, endPost);
		
		///////////////
		
		productList = productSQLMapper.selectByPageNum(postnum);
		
		for(ProductVO product : productList) {
			
			ProductContentVO productContent = productSQLMapper.selectByIdx(product.getP_idx());
			
			ProductDataVO data = new ProductDataVO(product,productContent);
			
			dataList.add(data);
		}
		
		productDataList.setPageVO(pageData);
		productDataList.setProductDataList(dataList);
		
		return productDataList;
		
	}

}
