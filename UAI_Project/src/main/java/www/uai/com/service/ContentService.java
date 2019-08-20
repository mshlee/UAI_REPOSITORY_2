package www.uai.com.service;

import java.util.ArrayList;


import www.uai.com.vo.*;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.UploadFileVO;



//impl 에서 사용할 메서드들 총 정리
public interface ContentService {

   public ArrayList<BoardDataVO> getContentsList(String searchWord, String searchTarget, String b_type); 
   
   public BoardDataVO readContent(ContentDataVO contentDataVO); //이거 그냥 string으로 받아도 됨( ?c_idx 방식으로 ) //vo 말고 이름을 좀 지어주면 편함(param: 넘겨받은 애)
   
   public void deleteContent(ContentDataVO contentDataVO);
   
   public void updateContent(ContentDataVO contentDataVO);
   
   public void writeContent(ContentDataVO contentDataVO, ArrayList<UploadFileVO> fileList);
   
   public void increaseCount(ContentDataVO contentDataVO);
   
   public void writeQnAContent(ContentDataVO contentDataVO, ArrayList<UploadFileVO> fileList);
   
   public BoardDataVO checkedPW(ContentDataVO contentDataVO, String b_pw);

   public void writeReview(ContentDataVO requestReviewParam);
}