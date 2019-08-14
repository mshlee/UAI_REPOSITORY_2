package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import www.uai.com.vo.AdvancedSearchDataVO;
import www.uai.com.vo.PostnumVO;
import www.uai.com.vo.ProductContentVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductVO;


public interface ProductSQLMapper {

	@Select("SELECT COUNT(*) FROM BOARD_CONTENTS")
	public int getListCount();
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENTS ORDER BY C_IDX DESC) bd) bd2 WHERE rnum BETWEEN #{startPost} AND #{endPost}")
	public ArrayList<ProductVO> selectByPageNum(PostnumVO vo);
	
	@Select("SELECT * FROM PRODUCT_CONTENT WHERE P_IDX = #{idx}")
	public ProductContentVO selectByIdx(String idx);
	
	//lhe-상품전체리스트출력용
	@Select ("SELECT * FROM PRODUCT ORDER BY P_IDX")
	public ArrayList<ProductVO> getAllProduct();
	
	//lhe-상품전체리스트출력용
	@Select ("SELECT * FROM product_content ORDER BY P_IDX")
	public ArrayList<ProductContentVO> getAllProductContent();
	
	//lhe-상품번호 기준 상품내용출력용
	@Select ("SELECT * FROM product_content WHERE P_IDX=#{p_idx}")
	public ProductContentVO selectByPIdx(String p_idx);
	
	//lhe-검색키워드 기준 상품내용 출력용
	@Select ("SELECT * FROM PRODUCT WHERE ${value}")
	public ArrayList<ProductVO> getProductListBySearchWord(String query);
	

}
