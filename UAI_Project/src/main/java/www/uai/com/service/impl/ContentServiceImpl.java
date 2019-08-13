package www.uai.com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.uai.com.mapper.ContentSQLMapper;
import www.uai.com.mapper.UploadFileSQLMapper;
import www.uai.com.mapper.UserSQLMapper;
import www.uai.com.service.ContentService;
import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.BoardDataPageVO;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.PageVO;
import www.uai.com.vo.PostnumVO;
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
	
	@Override
	public BoardDataPageVO getContentsList(String searchWord, String searchTarget, int nowPage, String b_type) {
		// TODO Auto-generated method stub
		
		BoardDataPageVO boardDataList = new BoardDataPageVO();
		
		ArrayList<BoardDataVO> dataList = new ArrayList<BoardDataVO>();
		
		ArrayList<ContentDataVO> contentList = null;
		
		PageVO pageData = new PageVO(0,0,0,0,0);
		
		
		
		// 페이징 처리 구현

		pageData.setNowPage(nowPage);
		System.out.println(nowPage);
		
		// 한 페이지에 보여줄 게시글 개수 설정
		int limit = 10;
		pageData.setLimit(limit);
		
		// 한 페이지에 보여줄 페이지의 개수 설정
		int pageLimit = 5;
		                                                                                             
		// 게시글 총 개수 가져오기
		int listCount = contentSQLMapper.getListCount();                                                                 
		                                                                                                   
		System.out.println("리스트 총 개수 : " + listCount);

		// 끝페이지 설정
		int maxPage = (int)(Math.ceil((double) listCount / pageData.getLimit()));                                      
		pageData.setMaxPage(maxPage);
		System.out.println("끝 페이지 : "+ maxPage);
		
		// 각 페이지 별 첫페이지&끝페이지 설정
		int startPage = (int)(Math.ceil((double) pageData.getNowPage()/pageLimit));
		System.out.println("첫 페이지 : " +startPage);
		pageData.setStartOfPageGroup(startPage);
		int endPage = startPage + (pageLimit -1);                                                                       
		if(endPage > maxPage) {                                                                            
		    pageData.setEndPage(maxPage);                                           
		}else {
			pageData.setEndPage(endPage);
		}
		
		// 각 페이지 별 시작 게시글 번호와 끝 번호 설정
		int startPost = nowPage*limit-limit+1;
		int endPost = nowPage*limit;
		PostnumVO postnum = new PostnumVO(startPost, endPost);
		
		///////////////
		
		if(searchWord == null) {
			contentList = contentSQLMapper.selectAll();
			
		}else if(searchTarget == "title"){
		
			contentList = contentSQLMapper.selectBytitle(searchWord,b_type);
		}else if(searchTarget == "content") {
			contentList = contentSQLMapper.selectByContent(searchWord,b_type);
		}else {
			contentList = contentSQLMapper.selectByNick(searchWord, b_type);
		}
			
		for(ContentDataVO content : contentList) {
		
			MemberDataVO member = userSQLMapper.selectByIdx(content.getM_idx()); 
				
			BoardDataVO data = new BoardDataVO(null, content, member, null, null);
				
			dataList.add(data);
		}

		boardDataList.setPagevo(pageData);
		boardDataList.setDataList(dataList);
		
		return boardDataList;
	}

	@Override
	public BoardDataVO readContent(ContentDataVO requestParam) {
		// TODO Auto-generated method stub
		String b_idx = requestParam.getB_idx();
		
		ContentDataVO content = contentSQLMapper.selectByIdx(b_idx);
		
		System.out.println(content.getB_title());
		
		MemberDataVO member = userSQLMapper.selectByIdx(content.getM_idx());
		ArrayList<UploadFileVO> fileList = new ArrayList<UploadFileVO>();
		fileList = uploadFileSQLMapper.selectByB_idx(b_idx);
		
		//for loop는...? jsp에서 돌리기
		
		return new BoardDataVO(null,content,member,null,fileList);
		
	}

	@Override
	public void deleteContent(ContentDataVO requestParam) {
		// TODO Auto-generated method stub
		
		String b_idx = requestParam.getB_idx();
		
		contentSQLMapper.deleteByIdx(b_idx);
		
	}

	@Override
	public void updateContent(ContentDataVO requestParam) {
		// TODO Auto-generated method stub

		contentSQLMapper.updateByIdx(requestParam);
	
	}

	@Override
	@Transactional //도중에 한 과정에서 오류가 발생하면 rollback 시킨다(atomicity)
	public void writeContent(ContentDataVO requestParam, ArrayList<UploadFileVO> fileList) {
		// TODO Auto-generated method stub
		
		// 키 가져오기(c_idx)
		String key = contentSQLMapper.getKey();
		
		// 키 넣어주기(c_idx)
		requestParam.setB_idx(key);
		
		//db에 넣기
		contentSQLMapper.insert(requestParam);
		
		// 파일 업로드 시키기(파일은 여러 개일 수 있음)
		for(UploadFileVO vo : fileList) {
			
			vo.setB_idx(key);
			
			uploadFileSQLMapper.insert(vo);
			
		}

		
	}

	@Override
	public void increaseCount(ContentDataVO requestParam) {
		// TODO Auto-generated method stub
		
		String b_idx = requestParam.getB_idx();
		
		
		contentSQLMapper.increaseCount(b_idx);
	}
}