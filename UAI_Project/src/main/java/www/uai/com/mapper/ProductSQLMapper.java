package www.uai.com.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.PostnumVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.WishListVO;

public interface ProductSQLMapper {

	
//dy--08.28	
	   @Select("SELECT COUNT(*) FROM PRODUCT")
	   public int getProductListCount();

	   @Select("SELECT COUNT(*) FROM WISHLIST")
	   public int getWishListCount();

	   @Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM PRODUCT ORDER BY P_IDX DESC) bd) bd2 WHERE rnum BETWEEN #{startPostNum} AND #{endPostNum}")
	   public ArrayList<ProductVO> selectByPageNum(PostnumVO vo);

	   // 검색용
		@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM PRODUCT ${searchQuery}) bd) bd2 WHERE rnum BETWEEN ${startPostNum} AND ${endPostNum}")
		public ArrayList<ProductVO> selectByCondition(
												@Param("searchQuery") String searchQuery,
												@Param("startPostNum") int startPost,
												@Param("endPostNum") int endPost);

	   @Select("SELECT * FROM PRODUCT WHERE P_IDX = #{p_idx}")
	   public ProductVO selectByIdx(String p_idx);

	   @Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM WISHLIST WHERE M_IDX =${m_idx} ORDER BY W_IDX) bd) bd2 WHERE rnum BETWEEN #{startPostNum } AND #{endPostNum }")
	   public ArrayList<WishListVO> selectByMIdx(PostnumVO vo);

	   @Insert("INSERT INTO ORDERS VALUES(Orders_Seq.nextval, #{o_totalPrice}, SYSDATE, #{o_paymentMethod}, #{p_idx}, #{m_idx})")
	   public void buyProductAction(OrderDataVO orderParam);

	   @Select("SELECT * FROM WISHLIST WHERE M_IDX = ${m_idx} AND P_IDX =${p_idx}")
	   public ArrayList<WishListVO> selectAllByMIdx(WishListVO wishListVO);

	   @Insert("INSERT INTO WISHLIST VALUES(Wishlist_Seq.nextval, #{m_idx}, #{p_idx}, SYSDATE)")
	   public void addWishlist(WishListVO wishlistVO);

	   @Delete("DELETE FROM WISHLIST WHERE M_IDX=#{m_idx} AND P_IDX=#{p_idx}")
	   public void removeWishlist(WishListVO wishlistVO);

	   @Update("UPDATE PRODUCT SET P_TOTALSALECOUNT = #{p_totalSaleCount } +1 WHERE P_IDX = #{p_idx}")
	   public void increaseBuyCount(ProductVO productVO);

	   @Select("SELECT P_NAME FROM PRODUCT WHERE P_NAME LIKE '%'||#{keyword}||'%' and ROWNUM BETWEEN 1 AND 5")
	   public List<ProductVO> searchByKeyword(String keyword);

		@Select("SELECT DISTINCT P_LOCATION FROM PRODUCT WHERE ${searchQuery}")
		public ArrayList<String> selectDistinctLocation(@Param("searchQuery") String searchQuery);

	   @Select("SELECT DISTINCT P_LOCATION FROM PRODUCT")
	   public ArrayList<String> selectAllDistinctLocation();

	   @Select("SELECT COUNT(*) FROM PRODUCT WHERE ${searchQuery}")
	   public int getListCountByCondition(@Param("searchQuery") String searchQuery);
	   
	   @Select("SELECT F_PATH FROM Product_Files WHERE P_IDX = #{p_idx} AND ROWNUM = 1")
	   public String getProductThumbnail(String p_idx);
	   
	   @Select("SELECT P_IDX FROM PRODUCT WHERE P_NAME = #{p_name} AND ROWNUM = 1")
		public String getP_Idx(ProductVO productParam);

	   //jys-상품 등록
	   @Insert("INSERT INTO PRODUCT VALUES(#{p_idx},#{p_name},#{p_type},#{p_originalPrice},#{p_nowPrice},#{p_teacher},#{p_maxStudent},#{p_startDate},#{p_lastDate},#{p_location},#{p_lectureDay},#{p_lectureTime},#{p_lectureInfo},#{p_teacherInfo},#{p_otherInfo},0,SYSDATE,0)")
	   public void insertProduct(ProductVO ProductVOParam);
	   
	   @Select("SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL")
	   public String getPKey();

}