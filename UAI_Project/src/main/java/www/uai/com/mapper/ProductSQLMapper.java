package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.PostnumVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.WishListVO;

public interface ProductSQLMapper {

   @Select("SELECT COUNT(*) FROM PRODUCT")
   public int getProductListCount();
   
   @Select("SELECT COUNT(*) FROM WISHLIST")
   public int getWishListCount();
   
   @Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM PRODUCT ORDER BY P_IDX DESC) bd) bd2 WHERE rnum BETWEEN #{startPostNum } AND #{endPostNum }")
   public ArrayList<ProductVO> selectByPageNum(PostnumVO vo);
   
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
   
   @Delete("DELETE FROM WISHLIST WHERE M_IDX=${m_idx} AND P_IDX=${p_idx}")
   public void removeWishlist(WishListVO wishlistVO);

}