package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import www.uai.com.vo.*;

public interface ContentSQLMapper {
   @Select("SELECT BOARD_CONTENT_SEQ.NEXTVAL FROM Dual")
   public String getKey();
   
   @Select("SELECT * FROM BOARD_CONTENT WHERE b_type = #{b_type} ORDER BY B_IDX DESC")
   public ArrayList<ContentDataVO> selectAll(String b_type);
   
   @Select("SELECT * FROM BOARD_CONTENT WHERE B_TYPE = #{b_type} AND B_TITLE LIKE '%'||#{searchWord}||'%' ORDER BY b_idx DESC")
   public ArrayList<ContentDataVO> selectBytitle(String searchWord,String b_type);
   
   @Select("SELECT * FROM BOARD_CONTENT WHERE B_TYPE = #{b_type} AND B_CONTENT LIKE '%'||#{searchWord}||'%' ORDER BY b_idx DESC")
   public ArrayList<ContentDataVO> selectByContent(String searchWord, String b_type);
   
   @Select("SELECT * FROM BOARD_CONTENT, MEMBERS WHERE B_TYPE = #{b_type} AND BOARD_CONTENT.M_IDX = MEMBERS.M_IDX AND MEMBERS.M_NICK LIKE '%'||#{searchWord}||'%' ORDER BY m_idx DESC")
   public ArrayList<ContentDataVO> selectByNick(String searchWord, String b_type);
   
   @Select("SELECT * FROM BOARD_CONTENT WHERE b_idx=#{b_idx}")
   public ContentDataVO selectByIdx(String b_idx);
   
   @Insert("INSERT INTO BOARD_CONTENT(b_type, b_title, b_content, b_postdate, b_count, b_isHidden, b_pw, b_qCategory, b_isPost, m_idx, p_idx, ad_idx) VALUES (#{b_type},#{b_title},#{b_content},SYSDATE, 0, #{b_isHidden},#{b_pw},#{b_qCategory}, #{b_isPost}, #{m_idx}, #{p_idx}, #{ad_idx})")
   public void insert(ContentDataVO ContentDataVO);
   
   @Insert("INSERT INTO BOARD_CONTENT( b_content, b_postdate, b_isPost, m_idx)VALUE (#{b_content},#{b_postdate},#{b_isPost},#{m_idx}))")
   public void insertReply(ContentDataVO ContentDataVO);
   
   @Delete("DELETE FROM BOARD_CONTENT WHERE b_idx = #{b_idx}")
   public void deleteByIdx(String b_idx);
   
   @Update("UPDATE BOARD_CONTENT SET c_title=#{b_title}, c_content=#{b_content} WHERE b_idx=#{b_idx}")
   public void updateByIdx(ContentDataVO vo);
   
   @Update("UPDATE BOARD_CONTENT SET b_count = b_count+1 WHERE b_idx=#{b_idx}")
   public void increaseCount(String b_idx);
   
   @Select("SELECT COUNT(*) FROM BOARD_CONTENT")
   public int getListCount();
   
   @Insert("INSERT INTO BOARD_CONTENT(B_IDX, B_TYPE, B_TITLE, B_CONTENT, B_POSTDATE, B_COUNT, B_ISHIDDEN, B_PW, B_QCATEGORY, B_ISPOST, M_IDX, P_IDX) VALUES(Board_Content_Seq.nextVal, 2, #{b_title}, #{b_content},SYSDATE, 0, #{b_isHidden}, #{b_pw}, #{b_qCategory}, 1, #{m_idx}, #{p_idx})")
   public void insertQNA(ContentDataVO contentDataVO);
   
   
}