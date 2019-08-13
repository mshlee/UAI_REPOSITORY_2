package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import www.uai.com.vo.UploadFileVO;

public interface UploadFileSQLMapper {

	@Insert("INSERT INTO BOARD_UPLOADFILES VALUES(BOARD_UPLOADFILES_SEQ.NEXTVAL,#{c_idx},#{f_linkname},#{f_orifilename})")
	public void insert(UploadFileVO vo);

	@Select("SELECT * FROM BOARD_UPLOADFILES WHERE B_IDX = #{b_idx}")
	public ArrayList<UploadFileVO> selectByB_idx(String b_idx);

}
