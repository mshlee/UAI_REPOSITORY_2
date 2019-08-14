package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import www.uai.com.vo.WishListVO;

public interface WishListSQLMapper {

	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM WISHLIST WHERE M_IDX = #{m_idx} ORDER BY P_IDX DESC) bd) bd2 WHERE rnum BETWEEN #{startPostNum } AND #{endPostNum }") 
	// 페이지 그냥 컨트롤러에서 ADD해서 넘겨주기 //WISHLIST 서비스 객체 따로 만들기
	public ArrayList<WishListVO> selectByIdx();
}
