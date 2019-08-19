package www.uai.com.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.MemberDataVO;


public interface UserSQLMapper {

   @Insert("INSERT INTO MEMBERS VALUES(MEMBERS_SEQ.NEXTVAL,#{m_id},#{m_pw},#{m_name},#{m_nick},#{m_phone},#{m_address},#{m_gender},#{m_birth},SYSDATE,#{m_interest1},#{m_interest2},#{m_interest3},#{m_education},#{m_major},#{m_job},#{m_maritalstatus})")
   public void insert(MemberDataVO memberDataVO);
   
   @Select("SELECT * FROM MEMBERS WHERE M_ID = #{m_id}")
   public MemberDataVO selectByMId(String id);
   
   @Select("SELECT * FROM MEMBERS WHERE M_IDX = #{m_idx}")
   public MemberDataVO selectByMIdx(String idx);

   @Select("SELECT * FROM ADMINS WHERE AD_ID = #{ad_id}")
   public AdminDataVO selectByADId(String id);
   
   @Select("SELECT * FROM ADMINS WHERE AD_IDX = #{ad_idx}")
   public AdminDataVO selectByADIdx(String idx);

   //회원정보 수정...
   @Update("UPDATE MEMBERS SET m_nick = #{m_nick} WHERE m_idx = #{m_idx}")
   public void update(MemberDataVO vo);

}