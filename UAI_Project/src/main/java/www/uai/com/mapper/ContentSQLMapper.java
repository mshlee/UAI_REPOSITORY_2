package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import www.uai.com.vo.*;

public interface ContentSQLMapper {
	@Select("SELECT BOARD_CONTENT_SEQ.nextval FROM Dual")
	public String getKey();
	
	@Select("SELECT B_PW FROM BOARD_CONTENT WHERE b_idx = #{b_idx}")
	public ContentDataVO getPW(String b_idx);
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENT WHERE B_TYPE = ${b_type} ORDER BY b_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectAll(@Param("b_type")String b_type, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	

	/*@Select("SELECT * FROM BOARD_CONTENTS WHERE ${searchTarget} LIKE '%'||#{searchWord}||'%' ORDER BY c_idx DESC")
	public ArrayList<ContentVO> selectBySearchWord(
			@Param("searchWord")String searchWord, 
			@Param("searchTarget")String searchTarget);*/
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENT WHERE B_TYPE = ${b_type} AND B_TITLE LIKE '%'||#{searchWord}||'%'  ORDER BY b_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectBytitle(@Param("b_type")String b_type,@Param("searchWord")String searchWord, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENT WHERE B_TYPE = ${b_type} AND B_CONTENT LIKE '%'||#{searchWord}||'%'  ORDER BY b_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectByContent(@Param("b_type")String b_type,@Param("searchWord")String searchWord, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENT, MEMBERS WHERE B_TYPE = ${b_type} AND BOARD_CONTENT.M_IDX = MEMBERS.M_IDX AND MEMBERS.M_NICK LIKE '%'||#{searchWord}||'%' ORDER BY b_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectByNick(@Param("b_type")String b_type,@Param("searchWord")String searchWord, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENT, MEMBERS WHERE B_TYPE = ${b_type} AND BOARD_CONTENT.AD_IDX = ADMINS.AD_IDX AND ADMINS.AD_NICK LIKE '%'||#{searchWord}||'%' ORDER BY b_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectByADNick(@Param("b_type")String b_type,@Param("searchWord")String searchWord, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	
	@Select("SELECT * FROM BOARD_CONTENT WHERE b_idx=#{b_idx}")
	public ContentDataVO selectByIdx(String b_idx);

	@Insert("INSERT INTO BOARD_CONTENT VALUES(#{b_idx}, 0, 0, #{b_title}, #{b_content}, SYSDATE, 0, 0, 'none_pw', 2, 1, 1, 1, 1)")
	public void insertNoitce(ContentDataVO contentDataVO);
	
	@Insert("INSERT INTO BOARD_CONTENT VALUES(#{b_idx},0, 2, #{b_title}, #{b_content},SYSDATE, 0, #{b_isHidden}, #{b_pw}, #{b_qCategory}, 1, #{m_idx}, #{p_idx}, 0 )")
	public void insertQNA(ContentDataVO contentDataVO);
	
	@Insert("INSERT INTO BOARD_CONTENT(b_referIdx, b_content, b_postdate, b_isPost, m_idx)VALUE (#{b_referIdx} #{b_content},#{b_postdate},#{b_isPost},#{m_idx}))")
	public void insertReply(ContentDataVO ContentDataVO);
	
	@Delete("DELETE FROM BOARD_CONTENT WHERE b_idx = #{b_idx}")
	public void deleteByIdx(String b_idx);
	
	@Update("UPDATE BOARD_CONTENT SET c_title=#{b_title}, c_content=#{b_content} WHERE b_idx=#{b_idx}")
	public void updateByIdx(ContentDataVO vo);
	
	@Update("UPDATE BOARD_CONTENT SET b_count = b_count+1 WHERE b_idx=#{b_idx}")
	public void increaseCount(String b_idx);
	
	@Select("SELECT COUNT(*) FROM BOARD_CONTENT WHERE B_TYPE = 0")
	public int getNoticeListCount();
	
	@Select("SELECT COUNT(*) FROM BOARD_CONTENT WHERE B_TYPE = 1")
	public int getReviewListCount();
	
	@Select("SELECT COUNT(*) FROM BOARD_CONTENT WHERE B_TYPE = 2")
	public int getQnAListCount();
	
	/*b_idx, b_title, b_content, m_idx, p_idx*/
	@Insert("INSERT INTO BOARD_CONTENT VALUES(#{b_idx},0, 1, #{b_title}, #{b_content},SYSDATE, 0, 0, 0, 2, 1, #{m_idx}, #{p_idx}, 0)")
	public void insertReview(ContentDataVO contentDataVO);
	   
}

/*B_IDX NUMBER(8) PRIMARY KEY ,
B_REFERIDX NUMBER(8),       --@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 이름만 변경하였습니다
B_TYPE NUMBER(8),       --B_Type: 0-공지사항, 1-리뷰, 2-qna
B_TITLE VARCHAR2(100),
B_CONTENT VARCHAR2(1000),
B_POSTDATE DATE,
B_COUNT NUMBER(8),
B_ISHIDDEN NUMBER(8),   --ishidden: 0-no(공개글이다), 1-yes(비밀글이다)
B_PW VARCHAR2(40),
B_QCATEGORY NUMBER(8),  --qcategoty: 0-상품문의, 1-결제문의
B_ISPOST NUMBER(8),     --ispost: 0-no(댓글이다), 1-yes(글이다)
M_IDX NUMBER(8),
P_IDX NUMBER(8),
AD_IDX NUMBER(8)*/