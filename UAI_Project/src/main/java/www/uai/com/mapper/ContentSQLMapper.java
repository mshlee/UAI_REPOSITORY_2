package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import www.uai.com.vo.*;


public interface ContentSQLMapper {
	//파일업로드시 다음 idx 선택
	@Select("SELECT BOARD_CONTENT_SEQ.nextval FROM Dual")
	public String getKey();
	//pw확인
	@Select("SELECT B_PW FROM BOARD_CONTENT WHERE b_idx = #{b_idx}")
	public ContentDataVO getPW(String b_idx);
	//~컨텐트 리스트 가져오기 및 검색
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENT WHERE B_TYPE = ${b_type} ORDER BY b_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectAll(@Param("b_type")String b_type, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENT WHERE B_TYPE = ${b_type} AND B_TITLE LIKE '%'||#{searchWord}||'%'  ORDER BY B_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectBytitle(@Param("b_type")String b_type,@Param("searchWord")String searchWord, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT * FROM BOARD_CONTENT WHERE B_TYPE = ${b_type} AND B_CONTENT LIKE '%'||#{searchWord}||'%'  ORDER BY B_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectByContent(@Param("b_type")String b_type,@Param("searchWord")String searchWord, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT bd3.* FROM (SELECT B_IDX, B_REFERIDX, B_TYPE, b_title, B_CONTENT, B_POSTDATE, B_COUNT, B_ISHIDDEN, B_PW, B_QCATEGORY, B_ISPOST, P_IDX, AD_IDX, M_NICK, BOARD_CONTENT.M_IDX FROM BOARD_CONTENT, MEMBERS WHERE BOARD_CONTENT.M_IDX = MEMBERS.M_IDX) bd3 WHERE b_type = ${b_type} AND m_nick LIKE '%'||#{searchWord}||'%' ORDER BY B_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectByNick(@Param("b_type")String b_type,@Param("searchWord")String searchWord, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	
	@Select("SELECT bd2.* FROM (SELECT bd.*, ROWNUM AS rnum FROM (SELECT bd3.* FROM (SELECT B_IDX, B_REFERIDX, B_TYPE, b_title, B_CONTENT, B_POSTDATE, B_COUNT, B_ISHIDDEN, B_PW, B_QCATEGORY, B_ISPOST, P_IDX, M_IDX, BOARD_CONTENT.AD_IDX, AD_NICK FROM BOARD_CONTENT, ADMINS WHERE BOARD_CONTENT.AD_IDX = ADMINS.AD_IDX) bd3 WHERE B_TYPE = ${b_type} AND AD_NICK LIKE '%'||#{searchWord}||'%' ORDER BY B_IDX DESC) bd) bd2 WHERE rnum BETWEEN ${startPostNum } AND ${endPostNum }")
	public ArrayList<ContentDataVO> selectByADNick(@Param("b_type")String b_type,@Param("searchWord")String searchWord, @Param("startPostNum")int startPostNum, @Param("endPostNum")int endPostNum);
	//읽기 선택
	@Select("SELECT * FROM BOARD_CONTENT WHERE b_idx=#{b_idx}")
	public ContentDataVO selectByIdx(String b_idx);
	//글 쓰기 
	@Insert("INSERT INTO BOARD_CONTENT VALUES(#{b_idx}, 0, 0, #{b_title}, #{b_content},SYSDATE, 0, 0, 'none_pw', 2, 1, 0, 0, #{ad_idx})")
	public void insertNoitce(ContentDataVO contentDataVO);
	
	@Insert("INSERT INTO BOARD_CONTENT VALUES(#{b_idx}, 0, 2, #{b_title}, #{b_content},SYSDATE, 0, #{b_isHidden}, #{b_pw}, #{b_qCategory}, 1, #{m_idx}, #{p_idx}, 0 )")
	public void insertQNA(ContentDataVO contentDataVO);

	@Insert("INSERT INTO BOARD_CONTENT VALUES(#{b_idx}, 0, 1, #{b_title}, #{b_content},SYSDATE, 0, 0, 'none_pw', 2, 1, #{m_idx}, #{p_idx}, 0)")
	public void insertReview(ContentDataVO contentDataVO);

	@Insert("INSERT INTO BOARD_CONTENT VALUES (Board_Content_Seq.nextVal, #{b_referIdx}, 3, 'reply', #{b_content}, SYSDATE, 0, 0, 'nonePW', 2, 0, #{m_idx}, 0, #{ad_idx}, #{m_id}, 0)")
	public void insertReply(ContentDataVO ContentDataVO);
	//삭제
	@Delete("DELETE FROM BOARD_CONTENT WHERE b_idx = #{b_idx}")
	public void deleteByIdx(String b_idx);
	//업데이트
	@Update("UPDATE BOARD_CONTENT SET B_TITLE=#{b_title}, B_CONTENT=#{b_content}, B_TYPE=#{b_type}, B_POSTDATE=SYSDATE, B_COUNT=0, AD_IDX = #{ad_idx} WHERE b_idx=#{b_idx}")
	public void updateNoticeByIdx(ContentDataVO contentDataVO);
	
	@Update("UPDATE BOARD_CONTENT SET B_TITLE=#{b_title}, B_CONTENT=#{b_content}, B_TYPE=#{b_type}, B_POSTDATE=SYSDATE, B_COUNT=0, B_ISHIDDEN=#{b_isHidden}, B_PW=#{b_pw}, B_QCATEGORY=#{b_qCategory}, M_IDX=#{m_idx}, M_ID=#{m_id}, p_name=#{p_name} WHERE B_IDX=#{b_idx}")
	public void updateQnAByIdx(ContentDataVO contentDataVO);
	
	@Update("UPDATE BOARD_CONTENT SET B_TITLE=#{b_title}, B_CONTENT=#{b_content}, B_TYPE=#{b_type}, B_POSTDATE=SYSDATE, B_COUNT=0, M_IDX=#{m_idx}, P_IDX=#{p_idx}")
	public void updateReviewByIdx(ContentDataVO contentDataVO);
	//조회수 증가
	@Update("UPDATE BOARD_CONTENT SET b_count = b_count+1 WHERE b_idx=#{b_idx}")
	public void increaseCount(String b_idx);
	//페이징 처리시 보드 글 갯수 불러오기
	@Select("SELECT COUNT(*) FROM BOARD_CONTENT WHERE B_TYPE = #{b_type}")
	public int getBoardListCount(String b_type);
	
	@Select("SELECT COUNT(*) FROM BOARD_CONTENT WHERE B_TYPE = ${b_type} AND B_TITLE LIKE '%'||#{searchWord}||'%'  ORDER BY B_IDX DESC")
	public int getBoardListCountByTitle(@Param("b_type")String b_type,@Param("searchWord")String searchWord);
	
	@Select("SELECT COUNT(*) FROM BOARD_CONTENT WHERE B_TYPE = ${b_type} AND B_CONTENT LIKE '%'||#{searchWord}||'%'  ORDER BY B_IDX DESC")
	public int getBoardListCountByContent(@Param("b_type")String b_type,@Param("searchWord")String searchWord);
	
	@Select("SELECT COUNT(*) FROM (SELECT * FROM BOARD_CONTENT, MEMBERS WHERE B_TYPE = ${b_type} AND BOARD_CONTENT.M_IDX = MEMBERS.M_IDX AND MEMBERS.M_NICK LIKE '%'||#{searchWord}||'%' ORDER BY B_IDX DESC)bd")
	public int getBoardListCountByNICK(@Param("b_type")String b_type,@Param("searchWord")String searchWord);
	
	@Select("SELECT COUNT(*) FROM (SELECT * FROM BOARD_CONTENT, ADMINS WHERE B_TYPE = ${b_type} AND BOARD_CONTENT.AD_IDX = ADMINS.AD_IDX AND ADMINS.AD_NICK LIKE '%'||#{searchWord}||'%' ORDER BY B_IDX DESC)bd")
	public int getBoardListCountByADNICK(@Param("b_type")String b_type,@Param("searchWord")String searchWord);
	
	@Select("SELECT COUNT(*) FROM StarRate WHERE P_IDX = ${p_idx}")
	public int getStarCount(ProductVO productVO);
	
	@Select("SELECT * FROM BOARD_CONTENT WHERE B_ISPOST = 0")
	public ArrayList<ContentDataVO> getReplyList();
	
	@Insert("INSERT INTO BOARD_CONTENT VALUES(BOARD_CONTENT_Seq.nextVal, 0, 4, '글 제목을 입력해 주세요', '*글을 쓰실 때 사용할 이미지 파일을 먼저 업로드 한 뒤 사용해 주세요*', SYSDATE, 0, 0, 'nonePW', 0, 1, 0, 0, 0,'m_id','p_name')")
	public void insertNoticeFraktsiya();
																				/*B_IDX NUMBER(8) PRIMARY KEY ,
																				B_REFERIDX NUMBER(8),       --@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 이름만 변경하였습니다
																				B_TYPE NUMBER(8),       --B_Type: 0-공지사항, 1-리뷰, 2-qna
																				B_TITLE VARCHAR2(100),
																				B_CONTENT VARCHAR2(1000),
																				B_POSTDATE DATE,
																				B_COUNT NUMBER(8),
																				B_ISHIDDEN NUMBER(8),   --ishidden: 0-no(공개글이다), 1-yes(비밀글이다)
																				B_PW VARCHAR2 (40),
																				B_QCATEGORY NUMBER(8),  --qcategoty: 0-상품문의, 1-결제문의
																				B_ISPOST NUMBER(8),     --ispost: 0-no(댓글이다), 1-yes(글이다)
																				M_IDX NUMBER(8),
																				P_IDX NUMBER(8),
																				AD_IDX NUMBER(8)*/
	@Select("SELECT bd.B_IDX FROM (SELECT * FROM BOARD_CONTENT ORDER BY B_IDX DESC)bd WHERE ROWNUM = 1")
	public String selectNoticeFraktsiya();


	}
