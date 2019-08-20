package www.uai.com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import www.uai.com.service.ContentService;
import www.uai.com.service.PageService;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.PageVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.SessionDataVO;
import www.uai.com.vo.UploadFileVO;

@Controller
public class ContentController {

	//사용할 메서드들 가져오기 
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private PageService pageService;
	
	// "/"이 붙으면 여기로!
	@RequestMapping("/")
	public String home() {
		
		return "mainPage";
	}
	
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "mainPage";
	}
	
	@RequestMapping("/myPage")
	public String myPage() {
		return "myPage";
	}

//보드 페이지 불러오기
	@RequestMapping("/boardNoticePage")
	public String boardNoticePage(Model model, String searchWord, String searchTarget, String nowPage, String changePage) { 
      
      // 페이지 처리한 거 여기다 분리해서 적어주기
      int limit = 10;
      int pageGroupLimit = 5;
      
      //전체글 개수 가져오기 
      int listCount = contentService.getNoticeListCount();
      
      PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
      
      //페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
      nowPage = pageVO.getNowPage();

		
		String b_type = "0";
		ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage, limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
		model.addAttribute("boardDataList", dataList);
	    model.addAttribute("pageVO", pageVO);
		System.out.println(dataList.size());
		return "boardNoticePage";
	}
	@RequestMapping("/boardReviewPage")
	public String boardReviewPage(Model model, String searchWord, String searchTarget, String nowPage, String changePage) { // 여러 개가 넘어올 경우 VO를 또 생성하여 받아올 수 있음. 싫으면 ContentVO에 string searchWord를 추가하던가.
		
		      
		      // 페이지 처리한 거 여기다 분리해서 적어주기
		      int limit = 10;
		      int pageGroupLimit = 5;
		      
		      //전체글 개수 가져오기 
		      int listCount = contentService.getNoticeListCount();
		      
		      PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
		      
		      //페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
		      nowPage = pageVO.getNowPage();
		
		String b_type = "1";
		ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage, limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
		model.addAttribute("boardDataList", dataList);
	    model.addAttribute("pageVO", pageVO);
		System.out.println(dataList.size());
		return "boardReviewPage";
	}
	@RequestMapping("/boardQnAPage")
	public String boardQnAPage(Model model, String searchWord, String searchTarget, String nowPage, String changePage) { // 여러 개가 넘어올 경우 VO를 또 생성하여 받아올 수 있음. 싫으면 ContentVO에 string searchWord를 추가하던가.
		
		      
		      // 페이지 처리한 거 여기다 분리해서 적어주기
		      int limit = 10;
		      int pageGroupLimit = 5;
		      
		      //전체글 개수 가져오기 
		      int listCount = contentService.getNoticeListCount();
		      
		      PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
		      
		      //페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
		      nowPage = pageVO.getNowPage();
		
		String b_type = "2";
		ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage, limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
		model.addAttribute("boardDataList", dataList);
	    model.addAttribute("pageVO", pageVO);
		System.out.println(dataList.size());
		return "boardQnAPage";
	}



//글쓰기 페이지 불러오기
	@RequestMapping("/writeNoticeForm")
	public String writeNoticeForm() {
		
		return "writeNoticeForm";
	}
	@RequestMapping("/writeQnAForm")
	public String writeQNAForm() {
		return "writeQnAForm";
	}
	@RequestMapping("/writeReviewForm")
	public String writeReviewForm() {
	    return "writeReviewForm";   
	}
	
//글쓰기 액션
	@RequestMapping("/writeNoticeAction")
	public String writeNoticeAction(MultipartFile [] files, ContentDataVO contentDataVO, HttpServletRequest request) { // request는 위치 받아오기 용도
		
		// 파일 받아서 DB에 넣어주기 전 작업 (db에 넣어주려면 db의 열에 맞게 조정해야함)
		ArrayList<UploadFileVO> fileList = new ArrayList<UploadFileVO>();
		
		// 파일 업로드 처리(파일 받아서 저장하기)
		//String uploadRootFolderName = "C:\\dev_tools\\apache-tomcat-8.5.42\\wtpwebapps\\SpringMVC"; // 이렇게 해도 되지만 위치가 변할때마다 수정해주어야함
		String uploadRootFolderName = request.getSession().getServletContext().getRealPath("/uploadimg/"); // window 기준으로는 자동으로 역슬래쉬로 들어감 //servletContext는 application 저장공간 
			//파일 처리하기(파일 이름 받아오기)
		for(MultipartFile file: files) {
			
			if(file.getSize()==0) //넘어온 값이 없을 때는 그냥 루프 빠져나가기
				continue;
			
			String oriFilename = file.getOriginalFilename();
			
			//중복된 이름으로 저장하는 것 피하기(랜덤한 이름으로 저장하기)
			String randomFilename = UUID.randomUUID().toString();
			
			//파일 확장자명 원본 그대로 받아오기(확장자명 가져오기)
			randomFilename += oriFilename.substring(oriFilename.lastIndexOf('.')); //원본 이름에서 .을 뒤에서부터 찾아서 잘라내어 확장자명을 얻어내고 랜덤하게 설정된 이름에다가 붙인다.
			
			System.out.println("저장될 파일명 : " + uploadRootFolderName + randomFilename);
			
			//저장하기
			try {
				file.transferTo(new File(uploadRootFolderName + randomFilename)); //파일 위치 지정해주기
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//DATA 생성
			//경로 구성
			String link = request.getContextPath(); //springMVC/ 위치까지
			link += "/uploadimg/";
			link += randomFilename;
			
			//담아주기
			UploadFileVO fileVO = new UploadFileVO();
			fileList.add(fileVO);
			
		}
		
		contentService.writeContent(contentDataVO,fileList);
		
		return "redirect:boardNoticePage";
	}
	@RequestMapping("/writeQnAAction")
	public String writeQnAAction(MultipartFile [] files, ContentDataVO contentDataVO, HttpServletRequest request) {

		// 파일 받아서 DB에 넣어주기 전 작업 (db에 넣어주려면 db의 열에 맞게 조정해야함)
		ArrayList<UploadFileVO> fileList = new ArrayList<UploadFileVO>();
		
		// 파일 업로드 처리(파일 받아서 저장하기)
			//파일을 넣는 폴더를 지정해주기
		//String uploadRootFolderName = "C:\\dev_tools\\apache-tomcat-8.5.42\\wtpwebapps\\SpringMVC"; // 이렇게 해도 되지만 위치가 변할때마다 수정해주어야함
		String uploadRootFolderName = request.getSession().getServletContext().getRealPath("/uploadimg/"); // window 기준으로는 자동으로 역슬래쉬로 들어감 //servletContext는 application 저장공간 
			//파일 처리하기(파일 이름 받아오기)
		for(MultipartFile file: files) {
			
			if(file.getSize()==0) //넘어온 값이 없을 때는 그냥 루프 빠져나가기
				continue;
			
			String oriFilename = file.getOriginalFilename();
			
			//중복된 이름으로 저장하는 것 피하기(랜덤한 이름으로 저장하기)
			String randomFilename = UUID.randomUUID().toString();
			
			//파일 확장자명 원본 그대로 받아오기(확장자명 가져오기)
			randomFilename += oriFilename.substring(oriFilename.lastIndexOf('.')); //원본 이름에서 .을 뒤에서부터 찾아서 잘라내어 확장자명을 얻어내고 랜덤하게 설정된 이름에다가 붙인다.
			
			System.out.println("저장될 파일명 : " + uploadRootFolderName + randomFilename);
			
			//저장하기
			try {
				file.transferTo(new File(uploadRootFolderName + randomFilename)); //파일 위치 지정해주기
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//DATA 생성
			//경로 구성
			String link = request.getContextPath(); //springMVC/ 위치까지
			link += "/uploadimg/";
			link += randomFilename;
			
			//담아주기
			UploadFileVO fileVO = new UploadFileVO();
			fileList.add(fileVO);
			
		}
		
		contentService.writeQnAContent(contentDataVO,fileList);
		
		return "redirect:boardQnAPage";
	}
	@RequestMapping("/writeReviewAction")
	public String writeReviewAction(ContentDataVO requestReviewParam, HttpSession httpsession) {
	      
	   System.out.println(requestReviewParam.getB_title());
	   SessionDataVO sessionDataVO = (SessionDataVO)httpsession.getAttribute("sessionData");
	   String m_idx = sessionDataVO.getM_idx();
	   requestReviewParam.setM_idx(m_idx);
	   contentService.writeReview(requestReviewParam);
	      

	   return "redirect: boardReviewPage";
	   }
	   
	
//글 읽기 페이지
	
	@RequestMapping("/readNoticePage")
	public String readNoticePage(ContentDataVO contentDataVO, Model model) {
		
		contentService.increaseCount(contentDataVO);
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);
		
		return "readNoticePage";
	}
	@RequestMapping("/readQnAPage")
	public String readQnAPage(ContentDataVO contentDataVO, Model model) {
		
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		String contentPW = boardData.getContentDataVO().getB_pw();
		String contentHidden = boardData.getContentDataVO().getB_isHidden();
		
		
		if(contentHidden.equals("0")) {
			
			contentService.increaseCount(contentDataVO);
			
			model.addAttribute("boardDataVO", boardData);
			
			return "readQnAPage";
	}else if(contentHidden.equals("1")){
		
		boardData = contentService.checkedPW(contentDataVO, contentHidden);
		
		System.out.println(boardData.getContentDataVO());
		if(boardData.getContentDataVO() == null) {
			return "falsePW";
		
		}else {
			contentService.increaseCount(contentDataVO);
			
			model.addAttribute("boardDataVO", boardData);
			
			return "readQnAPage";
		}
	}
		
		return "falsePW";
	}
	
	@RequestMapping("/falsePW")
	public String falsePW() {
		return "falsePW";
	}

	@RequestMapping("/readReviewPage")
	public String readReviewPage(ContentDataVO contentDataVO, Model model) {
		contentService.increaseCount(contentDataVO);
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);
		
		return "readReviewPage";
	}
	
	//삭제로직
	@RequestMapping("/deleteContentAction")
	public String deleteContentAction(ContentDataVO contentDataVO, String b_type) {
		
		contentService.deleteContent(contentDataVO);
		
		return "redirect:boardPage";
	}
	//업데이트 페이지
	@RequestMapping("/updateContentForm")
	public String updateContentForm(ContentDataVO contentDataVO, Model model) { //parameter에 c_idx의 정보가 아직 담겨 있음 ( ${param.c_idx} )로 jsp에서 받아와도 됨. )
		
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		
		model.addAttribute("boardData", boardData);
		
		return "updateContentForm";
	}
	//업데이트 액션
	@RequestMapping("/updateContentAction")
	public String updateContentAction(ContentDataVO contentDataVO) {
		
		String b_idx = contentDataVO.getB_idx();
		
		contentService.updateContent(contentDataVO);
		
		return "redirect:readContentPage?b_idx=" + b_idx;
	}

	   

}