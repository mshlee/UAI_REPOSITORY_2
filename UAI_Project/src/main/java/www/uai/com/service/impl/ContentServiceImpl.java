package www.uai.com.service.impl;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import www.uai.com.mapper.AdminSQLMapper;
import www.uai.com.mapper.ContentSQLMapper;
import www.uai.com.mapper.ProductSQLMapper;
import www.uai.com.mapper.UploadFileSQLMapper;
import www.uai.com.mapper.UserSQLMapper;
import www.uai.com.service.ContentService;
import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.PostnumVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.SessionDataVO;
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
	@Autowired
	private ProductSQLMapper productSQLMapper;
	@Override
	public ArrayList<BoardDataVO> getContentsList(String searchWord, String searchTarget, String b_type, String nowPage, int limit) {
		// TODO Auto-generated method stub
		
		ArrayList<BoardDataVO> dataList = new ArrayList<BoardDataVO>();
		
		ArrayList<ContentDataVO> contentList = null;
	
		if(nowPage == null) {
	         nowPage = "1";
		 }
	         int startPostNum = Integer.parseInt(nowPage)*limit-limit+1;
	         int endPostNum = Integer.parseInt(nowPage)*limit;
	         
		
		
		if(searchWord == null) {
			contentList = contentSQLMapper.selectAll(b_type, startPostNum, endPostNum);
		}else if(searchTarget.equals("b_title")){
			contentList = contentSQLMapper.selectBytitle(b_type,searchWord, startPostNum, endPostNum);
			System.out.println(contentList);
		}else if(searchTarget.equals("b_content")) {
			contentList = contentSQLMapper.selectByContent(b_type,searchWord, startPostNum, endPostNum);
		}else if(searchTarget.equals("ad_nick")) {
			contentList = contentSQLMapper.selectByADNick(b_type, searchWord, startPostNum, endPostNum);
		}else {
			contentList = contentSQLMapper.selectByNick(b_type,searchWord, startPostNum, endPostNum);
		}
			
		for(ContentDataVO content : contentList) {
			AdminDataVO admin = userSQLMapper.selectByADIdx(content.getAd_idx());
			MemberDataVO member = userSQLMapper.selectByMIdx(content.getM_idx()); 
			ProductVO product = productSQLMapper.selectByIdx(content.getP_idx());
			BoardDataVO data = new BoardDataVO(admin, content, member, null, null, product);
			dataList.add(data);
		}
		
		return dataList;
	}
	@Override
	public BoardDataVO readContent(ContentDataVO contentDataVO) {
		// TODO Auto-generated method stub
		String b_idx = contentDataVO.getB_idx();
		String b_isHidden = contentDataVO.getB_isHidden();
		String b_pw = contentDataVO.getB_pw();
		ContentDataVO content = contentSQLMapper.selectByIdx(b_idx);

		AdminDataVO admin = userSQLMapper.selectByADIdx(content.getAd_idx());
		MemberDataVO member = userSQLMapper.selectByMIdx(content.getM_idx());
		ProductVO product = productSQLMapper.selectByIdx(content.getP_idx());
		ArrayList<UploadFileVO> fileList = new ArrayList<UploadFileVO>();
		fileList = uploadFileSQLMapper.selectByB_idx(b_idx);
		//for loop는...? jsp에서 돌리기
		return new BoardDataVO(admin,content,member,null,fileList, product);
		
	}
	@Override
	public void deleteContent(ContentDataVO contentDataVO) {
		String b_idx = contentDataVO.getB_idx();
		contentSQLMapper.deleteByIdx(b_idx);
		
	}

	@Override
	public void updateNoticeContent(ContentDataVO contentDataVO) {
		contentSQLMapper.updateNoticeByIdx(contentDataVO);
	}
	
	public void updateQnAContent(ContentDataVO contentDataVO) {
		contentSQLMapper.updateQnAByIdx(contentDataVO);
	}

	@Override
	public void updateReviewContent(ContentDataVO contentDataVO) {
		contentSQLMapper.updateReviewByIdx(contentDataVO);
	}

	@Override
	@Transactional 
	public void writeContent(ContentDataVO contentDataVO, ArrayList<UploadFileVO> fileList) {
		// TODO Auto-generated method stub
		// 키 가져오기(c_idx)
		String key = contentSQLMapper.getKey();
		// 키 넣어주기(c_idx)
		contentDataVO.setB_idx(key);
		//db에 넣기
		contentSQLMapper.insertNoitce(contentDataVO);
		// 파일 업로드 시키기(파일은 여러 개일 수 있음)
		for(UploadFileVO vo : fileList) {
			uploadFileSQLMapper.insert(vo);	
		}
	}

	@Override
	public void increaseCount(ContentDataVO contentDataVO) {
		// TODO Auto-generated method stub
		String b_idx = contentDataVO.getB_idx();
		contentSQLMapper.increaseCount(b_idx);
	}
	@Override
	@Transactional 
	public void writeReviewContent(ContentDataVO contentDataVO, ArrayList<UploadFileVO> fileList) {
		// 키 가져오기(c_idx)
		String key = contentSQLMapper.getKey();
		// 키 넣어주기(c_idx)
		contentDataVO.setB_idx(key);
		//db에 넣기
		contentSQLMapper.insertReview(contentDataVO);
		// 파일 업로드 시키기(파일은 여러 개일 수 있음)
		for(UploadFileVO vo : fileList) {
			vo.setB_idx(key);
			uploadFileSQLMapper.insert(vo);	
		}
	}
	@Override
	@Transactional 
	public void writeQnAContent(ContentDataVO contentDataVO, ArrayList<UploadFileVO> fileList) {
		
				// 키 가져오기(c_idx)
				String key = contentSQLMapper.getKey();
				
				// 키 넣어주기(c_idx)
				contentDataVO.setB_idx(key);
				
				if(contentDataVO.getB_pw().equals(null)) {
					String b_pw = "nonePW";
					contentDataVO.setB_pw(b_pw);
					contentSQLMapper.insertQNA(contentDataVO);
				}else {
					
				}
				//db에 넣기
				contentSQLMapper.insertQNA(contentDataVO);
				// 파일 업로드 시키기(파일은 여러 개일 수 있음)
				for(UploadFileVO vo : fileList) {
					vo.setB_idx(key);
					uploadFileSQLMapper.insert(vo);
				}
	}
	
	public void writeReplyContent(ContentDataVO contentDataVO) {
		contentSQLMapper.insertReply(contentDataVO);
	}

	@Override
	public BoardDataVO checkedPW(ContentDataVO contentDataVO, String b_pw) {
		
		ContentDataVO result = contentSQLMapper.getPW(contentDataVO.getB_idx());
		String b_idx = contentDataVO.getB_idx();
		contentSQLMapper.getPW(b_idx);
		
		 if(result != null && result.getB_pw().equals(contentDataVO.getB_pw())) {
	         //접근성공
			 ContentDataVO content = contentSQLMapper.selectByIdx(b_idx);
				
				System.out.println(content.getB_title());
				AdminDataVO admin = adminSQLMapper.selectByIdx(content.getAd_idx());
				MemberDataVO member = userSQLMapper.selectByMId(content.getM_idx());
				ArrayList<UploadFileVO> fileList = new ArrayList<UploadFileVO>();
				fileList = uploadFileSQLMapper.selectByB_idx(b_idx);
				ProductVO product = productSQLMapper.selectByIdx(content.getP_idx());
				
				return new BoardDataVO(admin,content,member,null,fileList, product);
	      }else {
	         //접근실패
	      }
		 
		return new BoardDataVO(null, null, null, null, null, null);
	}

	   public void writeReview(ContentDataVO contentDataVO){
		      contentSQLMapper.insertReview(contentDataVO);
		   }

	@Override
	public int getBoardListCount(String b_type) {
	      int boardListCount = contentSQLMapper.getBoardListCount(b_type);
	   return boardListCount;
}

	   public int getStarCount(ProductVO productVO) {
		      int starNumber = contentSQLMapper.getStarCount(productVO) ;  
		      return starNumber;
		   }
	@Override
	public int getBoardListCountByTitle(String b_type, String searchWord) {
	      int boardListCount = contentSQLMapper.getBoardListCountByTitle(b_type, searchWord);
	   return boardListCount;
	}

	@Override
	public int getBoardListCountByContent(String b_type, String searchWord) {
	      int boardListCount = contentSQLMapper.getBoardListCountByContent(b_type, searchWord);
	   return boardListCount;
	}

	@Override
	public int getBoardListCountByNICK(String b_type, String searchWord) {
	      int boardListCount = contentSQLMapper.getBoardListCountByNICK(b_type, searchWord);
	   return boardListCount;
	}

	@Override
	public int getBoardListCountByADNICK(String b_type, String searchWord) {
	      int boardListCount = contentSQLMapper.getBoardListCountByADNICK(b_type, searchWord);
	   return boardListCount;
	}

	@Override
	public ArrayList<BoardDataVO> getReplyList(ContentDataVO contentDataVO) {
				
		ArrayList<BoardDataVO> dataList = new ArrayList<BoardDataVO>();
		ArrayList<ContentDataVO> contentList = null;
		
		contentList = contentSQLMapper.getReplyList();
		
		for(ContentDataVO content : contentList) {
			AdminDataVO admin = userSQLMapper.selectByADIdx(content.getAd_idx());
			MemberDataVO member = userSQLMapper.selectByMIdx(content.getM_idx()); 
			BoardDataVO data = new BoardDataVO(admin, content, member, null, null, null);
				
			dataList.add(data);
		}
		return dataList;
	}

	@Override
	public void updateFileContent(ArrayList<UploadFileVO> fileList, String b_idx) {
		// 파일 업로드 시키기(파일은 여러 개일 수 있음)
		for(UploadFileVO uploadFileVO : fileList) {
			
			uploadFileVO.setB_idx(b_idx);
			uploadFileSQLMapper.insert(uploadFileVO);
		}
	}

	@Override
	public void deleteFile(UploadFileVO uploadFileVO) {		
		String f_idx = uploadFileVO.getF_idx();

		uploadFileSQLMapper.deleteFileForm(f_idx);
	}

	@Override
	public String insertFraktsiya() {
		contentSQLMapper.insertNoticeFraktsiya();	
		String b_idx = contentSQLMapper.selectNoticeFraktsiya();
		
		return b_idx;
	}
}