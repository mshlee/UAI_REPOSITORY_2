package www.uai.com.service;

import java.util.ArrayList;

import www.uai.com.vo.BoardDataPageVO;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.UploadFileVO;



//impl 에서 사용할 메서드들 총 정리
public interface ContentService {

	public BoardDataPageVO getContentsList(String searchWord, String searchTarget, int nowPage, String b_type); 
	
	public BoardDataVO readContent(ContentDataVO requestParam); //이거 그냥 string으로 받아도 됨( ?c_idx 방식으로 ) //vo 말고 이름을 좀 지어주면 편함(param: 넘겨받은 애)
	
	public void deleteContent(ContentDataVO requestParam);
	
	public void updateContent(ContentDataVO requestParam);
	
	public void writeContent(ContentDataVO requestParam, ArrayList<UploadFileVO> fileList);
	
	public void increaseCount(ContentDataVO requestParam);
	
}
