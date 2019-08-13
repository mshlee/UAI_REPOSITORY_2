package www.uai.com.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Select;

import www.uai.com.vo.PostnumVO;
import www.uai.com.vo.ProductContentVO;
import www.uai.com.vo.ProductVO;


public interface ProductSQLMapper {

	@Select("SELECT COUNT(*) FROM BOARD_CONTENTS")
	public int getListCount();
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENTS ORDER BY C_IDX DESC) bd) bd2 WHERE rnum BETWEEN #{startPost} AND #{endPost}")
	public ArrayList<ProductVO> selectByPageNum(PostnumVO vo);
	
	@Select("SELECT * FROM PRODUCT_CONTENT WHERE P_IDX = #{idx}")
	public ProductContentVO selectByIdx(String idx);

}
