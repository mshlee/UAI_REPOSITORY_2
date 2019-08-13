package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import www.uai.com.vo.*;

public interface ContentSQLMapper {
	@Select("SELECT B_IDX.NEXTVAL FROM Dual")
	public String getKey();
	
	@Select("SELECT * FROM BOARD_CONTENT WHERE B_TYPE=#{b_type} ORDER BY b_idx DESC ")
	public ArrayList<ContentDataVO> selectAll();
	
	@Select("SELECT * FROM BOARD_CONTENT WHERE B_TITLE LIKE '%'||#{searchWord}||'%' AND b_type=#{b_type} ORDER BY b_idx DESC")
	public ArrayList<ContentDataVO> selectBytitle(String searchWord,String b_type);
	
	@Select("SELECT * FROM BOARD_CONTENT WHERE B_CONTENT LIKE '%'||#{searchWord}||'%' AND b_type=#{b_type} ORDER BY b_idx DESC")
	public ArrayList<ContentDataVO> selectByContent(String searchWord);
	
	@Select("SELECT * FROM BOARD_CONTENT, MEMBERS WHERE BOARD_CONTENT.M_IDX = MEMBERS.M_IDX AND MEMBERS.M_NICK LIKE '%'||#{searchWord}||'%' ORDER BY m_idx DESC")
	public ArrayList<ContentDataVO> selectByNick(String searchWord);
	
	@Select("SELECT * FROM BOARD_CONTENT WHERE m_idx=#{m_idx}")
	public ContentDataVO selectByIdx(String c_idx);
	
	@Insert("INSERT INTO BOARD_CONTENT VALUES (#{b_idx}, #{m_idx}, #{c_title}, #{c_content}, 0, SYSDATE)")
	public void insert(ContentDataVO vo);
	
	@Delete("DELETE FROM BOARD_CONTENTS WHERE b_idx = #{b_idx}")
	public void deleteByIdx(String c_idx);
	
	@Update("UPDATE BOARD_CONTENTS SET c_title=#{c_title}, c_content=#{c_content} WHERE c_idx=#{c_idx}")
	public void updateByIdx(ContentDataVO vo);
	
	@Update("UPDATE BOARD_CONTENTS SET c_count = c_count+1 WHERE c_idx=#{c_idx}")
	public void increaseCount(String c_idx);
}
