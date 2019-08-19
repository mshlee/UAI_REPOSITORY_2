package www.uai.com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.uai.com.mapper.AdminSQLMapper;
import www.uai.com.mapper.ContentSQLMapper;
import www.uai.com.mapper.UploadFileSQLMapper;
import www.uai.com.mapper.UserSQLMapper;
import www.uai.com.service.ContentService;
import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.UploadFileVO;

@Service
public class ContentServiceImpl implements ContentService{

   //dao 사용할 수 있게
   @Autowired
   private ContentSQLMapper contentSQLMapper;
   @Autowired
   private UserSQLMapper userSQLMapper;
   @Autowired
   private UploadFileSQLMapper uploadFileSQLMapper;
   @Autowired
   private AdminSQLMapper adminSQLMapper;
   
   @Override
   public ArrayList<BoardDataVO> getContentsList(String searchWord, String searchTarget, String b_type) {
      // TODO Auto-generated method stub
      
      ArrayList<BoardDataVO> dataList = new ArrayList<BoardDataVO>();
      
      ArrayList<ContentDataVO> contentList = null;
   
      
      
      
      ///////////////
      
      if(searchWord == null) {
         contentList = contentSQLMapper.selectAll(b_type);
      }else if(searchTarget == "title"){
         contentList = contentSQLMapper.selectBytitle(searchWord,b_type);
      }else if(searchTarget == "content") {
         contentList = contentSQLMapper.selectByContent(searchWord,b_type);
      }else {
         contentList = contentSQLMapper.selectByNick(searchWord, b_type);
      }
         
      for(ContentDataVO content : contentList) {
         
         AdminDataVO admin = adminSQLMapper.selectByIdx(content.getAd_idx());
         
         MemberDataVO member = userSQLMapper.selectByMIdx(content.getM_idx()); 
            
         BoardDataVO data = new BoardDataVO(content, member, admin);
            
         dataList.add(data);
      }
      
      return dataList;
   }

   @Override
   public BoardDataVO readContent(ContentDataVO contentDataVO) {
      // TODO Auto-generated method stub
      String b_idx = contentDataVO.getB_idx();
      
      ContentDataVO content = contentSQLMapper.selectByIdx(b_idx);
      
      System.out.println(content.getB_title());
      AdminDataVO admin = adminSQLMapper.selectByIdx(content.getAd_idx());
      MemberDataVO member = userSQLMapper.selectByMIdx(content.getM_idx());
      ArrayList<UploadFileVO> fileList = new ArrayList<UploadFileVO>();
      fileList = uploadFileSQLMapper.selectByB_idx(b_idx);
      
      //for loop는...? jsp에서 돌리기
      
      return new BoardDataVO(admin,content,member,null,fileList);
      
   }
   @Override
   public void deleteContent(ContentDataVO contentDataVO) {
      // TODO Auto-generated method stub
      
      String b_idx = contentDataVO.getB_idx();
      
      contentSQLMapper.deleteByIdx(b_idx);
      
   }

   @Override
   public void updateContent(ContentDataVO contentDataVO) {
      // TODO Auto-generated method stub

      contentSQLMapper.updateByIdx(contentDataVO);
   
   }

   @Override
   @Transactional //도중에 한 과정에서 오류가 발생하면 rollback 시킨다(atomicity)
   public void writeContent(ContentDataVO contentDataVO, ArrayList<UploadFileVO> fileList) {
      // TODO Auto-generated method stub
      
      // 키 가져오기(c_idx)
      String key = contentSQLMapper.getKey();
      
      // 키 넣어주기(c_idx)
      contentDataVO.setB_idx(key);
      
      //db에 넣기
      contentSQLMapper.insertQNA(contentDataVO);
      
      // 파일 업로드 시키기(파일은 여러 개일 수 있음)
      for(UploadFileVO vo : fileList) {
         
         vo.setB_idx(key);
         
         uploadFileSQLMapper.insert(vo);
         
      }

      
   }

   @Override
   public void increaseCount(ContentDataVO contentDataVO) {
      // TODO Auto-generated method stub
      
      String b_idx = contentDataVO.getB_idx();
      
      
      contentSQLMapper.increaseCount(b_idx);
   }
}