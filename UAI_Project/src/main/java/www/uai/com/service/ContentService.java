package www.uai.com.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import www.uai.com.vo.*;

//impl 에서 사용할 메서드들 총 정리
public interface ContentService {

	public ArrayList<BoardDataVO> getContentsList(String searchWord, String searchTarget, String b_type, String nowPage,
			int limit);

	public BoardDataVO readContent(ContentDataVO contentDataVO); // 이거 그냥 string으로 받아도 됨( ?c_idx 방식으로 ) //vo 말고 이름을 좀
																	// 지어주면 편함(param: 넘겨받은 애)

	public void deleteContent(ContentDataVO contentDataVO);

	public void updateNoticeContent(ContentDataVO contentDataVO);

	public void updateQnAContent(ContentDataVO contentDataVO);
	
	public void updateReviewContent(ContentDataVO contentDataVO);
	
	public void writeContent(ContentDataVO contentDataVO, ArrayList<UploadFileVO> fileList);

	public void increaseCount(ContentDataVO contentDataVO);

	public void writeQnAContent(ContentDataVO contentDataVO, ArrayList<UploadFileVO> fileList);

	public BoardDataVO checkedPW(ContentDataVO contentDataVO, String b_pw);

	public void writeReviewContent(ContentDataVO contentDataVO, ArrayList<UploadFileVO> fileList);

	public int getBoardListCount(String b_type);

	public void writeReplyContent(ContentDataVO contentDataVO);

	public int getStarCount(ProductVO productVO);
	
	public int getBoardListCountByTitle(String b_type, String searchWord);
	
	public int getBoardListCountByContent(String b_type, String searchWord);
	
	public int getBoardListCountByNICK(String b_type, String searchWord);
	
	public int getBoardListCountByADNICK(String b_type, String searchWord);
	
	public ArrayList<BoardDataVO> getReplyList(ContentDataVO contentDataVO);
	
	public void updateFileContent(ArrayList<UploadFileVO> fileList, String b_idx);

	public void deleteFile(UploadFileVO uploadFileVO);
	
	public String insertFraktsiya();
}
