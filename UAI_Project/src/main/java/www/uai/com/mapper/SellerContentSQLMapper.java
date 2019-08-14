package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductVO;

public interface SellerContentSQLMapper {
	
	//Product 테이블의 모든 행 가져오기
	@Select ("SELECT * FROM Product ORDER BY P_IDX")
	public ArrayList<ProductVO> getAllProductList();

	
	
	

}
