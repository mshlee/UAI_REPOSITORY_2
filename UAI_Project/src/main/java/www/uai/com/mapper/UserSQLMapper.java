package www.uai.com.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import www.uai.com.vo.MemberDataVO;


public interface UserSQLMapper {

	@Insert("INSERT INTO BOARD_MEMBERS VALUES(BOARD_MEMBERS_SEQ.NEXTVAL,#{m_id},#{m_pw},#{m_name},#{m_nick},#{m_phone},#{m_address},#{m_gender},#{m_birth},SYSDATE,#{m_interest1},#{m_interest2},#{m_interest3},#{m_education},#{m_major},#{m_job},#{m_maritalstatus})")
	public void insert(MemberDataVO vo);
	
	@Select("SELECT * FROM BOARD_MEMBERS WHERE M_ID = #{m_id}")
	public MemberDataVO selectById(String id);
	
	@Select("SELECT * FROM BOARD_MEMBERS WHERE M_IDX = #{m_idx}")
	public MemberDataVO selectByIdx(String idx);


	//회원정보 수정...
	@Update("UPDATE BOARD_MEMBERS SET m_nick = #{m_nick} WHERE m_idx = #{m_idx}")
	public void update(MemberDataVO vo);

}
