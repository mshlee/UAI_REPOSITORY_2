package www.uai.com.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.MemberDataVO;

public interface AdminSQLMapper {

	@Insert("INSERT INTO ADMINS VALUES(ADMINS_SEQ.NEXTVAL,#{ad_idx},#{ad_id},#{ad_nick})")
	public void insert(AdminDataVO adminDataVO);
	
	@Select("SELECT * FROM ADMINS WHERE ad_id = #{ad_id}")
	public AdminDataVO selectById(String ad_id);
	
	@Select("SELECT * FROM ADMINS WHERE ad_idx = #{ad_idx}")
	public AdminDataVO selectByIdx(String ad_idx);


	//회원정보 수정...
	@Update("UPDATE ADMINS SET ad_nick = #{ad_nick} WHERE ad_idx = #{ad_idx}")
	public void update(AdminDataVO adminDataVO);

}


