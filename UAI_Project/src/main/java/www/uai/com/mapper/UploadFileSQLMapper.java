package www.uai.com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import www.uai.com.vo.UploadFileVO;
import www.uai.com.vo.UploadProductFileVO;

public interface UploadFileSQLMapper {

	@Insert("INSERT INTO Files VALUES(Files_Seq.NEXTVAL, #{b_idx},#{f_path},#{f_originalname})")
	public void insert(UploadFileVO vo);

	@Select("SELECT * FROM Files WHERE B_IDX = #{b_idx}")
	public ArrayList<UploadFileVO> selectByB_idx(String b_idx);

	 @Select("SELECT * FROM PRODUCT_FILES WHERE P_IDX = #{p_idx }")
	 public ArrayList<UploadProductFileVO> selectByP_idx(String p_idx);

}
