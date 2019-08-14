package www.uai.com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.uai.com.mapper.SellerContentSQLMapper;
import www.uai.com.service.SellerContentService;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.SellerContentVO;

@Service
public class SellerContentServiceImpl implements SellerContentService {
	
	@Autowired
	private SellerContentSQLMapper sellerContentSQLMapper;
	
	public ArrayList<SellerContentVO> getProductList(){
		ArrayList<SellerContentVO> productList = new ArrayList<SellerContentVO>();
		ArrayList<ProductVO> productVO= new ArrayList<ProductVO>();
		ArrayList<ProductDataVO> productDataVO = new ArrayList<ProductDataVO>();
		
		productVO = sellerContentSQLMapper.getAllProductList();
		productDataVO = sellerContentSQLMapper.getAllProductContentList();
		
		for(ProductVO product : productVO) {
		ProductDataVO productData = sellerContentSQLMapper.selectProductContentByIdx(product.getP_idx());
		
		SellerContentVO sconData = new SellerContentVO(product, null, null, null, productData);
		
		productList.add(sconData);
		
		}
		
		return productList;
	}
	
	
	

}
