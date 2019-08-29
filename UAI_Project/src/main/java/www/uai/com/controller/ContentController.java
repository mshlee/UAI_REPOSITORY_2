package www.uai.com.controller;

import java.awt.Image;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import www.uai.com.service.ContentService;
import www.uai.com.service.PageService;
import www.uai.com.service.ProductService;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.PageVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.SessionDataVO;
import www.uai.com.vo.UploadFileVO;

@Controller
public class ContentController {
	// 사용할 메서드들 가져오기
	@Autowired
	private ContentService contentService;
	@Autowired
	private PageService pageService;
	@Autowired
	private ProductService productService;

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
	public String boardNoticePage(Model model, String searchWord, String searchTarget, String nowPage,
			String changePage) {
		String b_type = "0";
		// 페이지 처리한 거 여기다 분리해서 적어주기
		int limit = 10;
		int pageGroupLimit = 5;
		// Target과 searchWord로 결과 나누기
		if (searchWord == null) {
			int listCount = contentService.getBoardListCount(b_type);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();

			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardNoticePage";
		} else if (searchTarget.equals("b_title")) {
			int listCount = contentService.getBoardListCountByTitle(b_type, searchWord);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardNoticePage";
		} else if (searchTarget.equals("b_content")) {
			int listCount = contentService.getBoardListCountByContent(b_type, searchWord);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardNoticePage";
		} else if (searchTarget.equals("ad_nick")) {
			int listCount = contentService.getBoardListCountByADNICK(b_type, searchWord);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardNoticePage";
		} else {
			int listCount = contentService.getBoardListCountByNICK(b_type, searchWord);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardNoticePage";

		}
	}

	@RequestMapping("/boardReviewPage")
	public String boardReviewPage(Model model, String searchWord, String searchTarget, String nowPage,
			String changePage) { // 여러 개가 넘어올 경우 VO를 또 생성하여 받아올 수 있음. 싫으면 ContentVO에 string searchWord를 추가하던가.
		String b_type = "1";
		// 페이지 처리한 거 여기다 분리해서 적어주기
		int limit = 10;
		int pageGroupLimit = 5;
		if (searchWord == null) {
			int listCount = contentService.getBoardListCount(b_type);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardReviewPage";
		} else if (searchTarget.equals("b_title")) {
			int listCount = contentService.getBoardListCountByTitle(b_type, searchWord);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardReviewPage";
		} else if (searchTarget.equals("b_content")) {
			int listCount = contentService.getBoardListCountByContent(b_type, searchWord);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardReviewPage";
		} else {
			int listCount = contentService.getBoardListCountByNICK(b_type, searchWord);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardReviewPage";
		}
	}

	@RequestMapping("/boardQnAPage")
	public String boardQnAPage(Model model, String searchWord, String searchTarget, String nowPage, String changePage) { 
		String b_type = "2";
		// 전체글 개수 가져오기
		if (searchWord == null) {
			int limit = 10;
			int pageGroupLimit = 5;
			int listCount = contentService.getBoardListCount(b_type);
			System.out.println("전체 글 갯수는 : " + listCount);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardQnAPage";
		} else if (searchTarget.equals("b_title")) {
			int limit = 10;
			int pageGroupLimit = 5;
			int listCount = contentService.getBoardListCountByTitle(b_type, searchWord);
			System.out.println("전체 글 갯수는 : " + listCount);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardQnAPage";
		} else if (searchTarget.equals("b_content")) {
			int limit = 10;
			int pageGroupLimit = 5;
			int listCount = contentService.getBoardListCountByContent(b_type, searchWord);
			System.out.println("전체 글 갯수는 : " + listCount);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardQnAPage";
		} else {
			int limit = 10;
			int pageGroupLimit = 5;
			int listCount = contentService.getBoardListCountByNICK(b_type, searchWord);
			System.out.println("전체 글 갯수는 : " + listCount);
			PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
			// 페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
			nowPage = pageVO.getNowPage();
			ArrayList<BoardDataVO> dataList = contentService.getContentsList(searchWord, searchTarget, b_type, nowPage,
					limit); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
			model.addAttribute("boardDataList", dataList);
			model.addAttribute("pageVO", pageVO);
			System.out.println(dataList.size());
			return "boardQnAPage";
		}
	}

//글쓰기 페이지 불러오기
	//공지사항 글쓰기 로직
	@RequestMapping("/writeNoticeForm")
	public String writeNoticeForm() {
		String b_idx = contentService.insertFraktsiya();

		return "redirect:writeNoticePage?b_idx="+b_idx;
	}
	
	@RequestMapping("/writeNoticePage")
	public String writeNoticePage(ContentDataVO contentDataVO, Model model) {
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);
		
		return "writeNoticePage";
	}
	//QnA글쓰기 로직
	@RequestMapping("/writeQnAForm")
	public String writeQNAForm() {
		String b_idx = contentService.insertFraktsiya();
		
		return "redirect:writeQnAPage?b_idx="+b_idx;
	}
	@RequestMapping("/writeQnAPage")
	public String writeQnAPage(ContentDataVO contentDataVO, Model model) {

		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);
		int limit= 5000;
		ArrayList<ProductVO> productVO = productService.getProductList(null, null, limit, null, null, null, null);
		model.addAttribute("productVO", productVO);
		
		
		return "writeQnAPage";
	}
	//리뷰 글쓰기 로직
	@RequestMapping("/writeReviewForm")
	public String writeReviewForm() {
		String b_idx = contentService.insertFraktsiya();
		
		return "redirect:writeReviewPage?b_idx="+b_idx;
	}
	@RequestMapping("/writeReviewPage")
	public String writeReviewPage(ContentDataVO contentDataVO, Model model) {
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);
		
		return "writeReviewPage";
	}

//글쓰기 액션
	//공지사항 액션
	@RequestMapping("/writeNoticeAction")
	public String writeNoticeAction(ContentDataVO contentDataVO) { // request는

		contentService.updateNoticeContent(contentDataVO);

		return "redirect:boardNoticePage";
	}
	//QnA액션
	@RequestMapping("/writeQnAAction")
	public String writeQnAAction(ContentDataVO contentDataVO) {

		contentService.updateQnAContent(contentDataVO);

		return "redirect:boardQnAPage";
	}
	//리뷰액션
	@RequestMapping("/writeReviewAction")
	public String writeReviewAction(ContentDataVO contentDataVO) {

		contentService.updateReviewContent(contentDataVO);

		return "redirect: boardReviewPage";
	}
	//댓글액션
	@RequestMapping("/writeReplyAction")
	public String writeReplyAction(ContentDataVO contentDataVO, String b_idx, String b_type) {

		contentService.writeReplyContent(contentDataVO);
		if(b_type.equals("0")){
			return "redirect:readNoticePage?b_idx="+b_idx;
		}else if(b_type.equals("1")) {
			return "redirect:readReviewPage?b_idx="+b_idx;
		}else {
			return "redirect:readQnAPageByAdmin?b_idx="+b_idx;
		}
	}
//글 읽기 페이지
	//공지사항 읽기
	@RequestMapping("/readNoticePage")
	public String readNoticePage(ContentDataVO contentDataVO, Model model) {

		contentService.increaseCount(contentDataVO);
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);

		ArrayList<BoardDataVO> boardDataReply = contentService.getReplyList(contentDataVO);
		model.addAttribute("boardDataReplyList", boardDataReply);
		return "readNoticePage";
	}
	//QnA운영자가 읽기
	@RequestMapping("/readQnAPageByAdmin")
	public String readQnAPageByAdmin(ContentDataVO contentDataVO, Model model) {

		contentService.increaseCount(contentDataVO);
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);

		ArrayList<BoardDataVO> boardDataReply = contentService.getReplyList(contentDataVO);
		model.addAttribute("boardDataReplyList", boardDataReply);
		return "readQnAPage";

	}
	//QnA 일반 회원들이 읽기
	@RequestMapping("/readQnAPage")
	public String readQnAPage(ContentDataVO contentDataVO, Model model) {

		BoardDataVO boardData = contentService.readContent(contentDataVO);
		String contentHidden = boardData.getContentDataVO().getB_isHidden();

		if (contentHidden.equals("0")) {

			contentService.increaseCount(contentDataVO);

			model.addAttribute("boardDataVO", boardData);
			ArrayList<BoardDataVO> boardDataReply = contentService.getReplyList(contentDataVO);
			model.addAttribute("boardDataReplyList", boardDataReply);
			return "readQnAPage";
		} else if (contentHidden.equals("1")) {

			boardData = contentService.checkedPW(contentDataVO, contentHidden);

			System.out.println(boardData.getContentDataVO());
			if (boardData.getContentDataVO() == null) {
				return "falsePW";

			} else {
				contentService.increaseCount(contentDataVO);

				model.addAttribute("boardDataVO", boardData);
				ArrayList<BoardDataVO> boardDataReply = contentService.getReplyList(contentDataVO);
				model.addAttribute("boardDataReplyList", boardDataReply);

				return "readQnAPage";
			}
		}

		return "falsePW";
	}
	//QnA비밀글 비밀번호 확인 실패 페이지
	@RequestMapping("/falsePW")
	public String falsePW() {
		return "falsePW";
	}
	//리뷰 읽기
	@RequestMapping("/readReviewPage")
	public String readReviewPage(ContentDataVO contentDataVO, Model model) {
		contentService.increaseCount(contentDataVO);
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);

		ArrayList<BoardDataVO> boardDataReply = contentService.getReplyList(contentDataVO);
		model.addAttribute("boardDataReplyList", boardDataReply);
		return "readReviewPage";
	}

	// 삭제로직
	@RequestMapping("/deleteContentAction")
	public String deleteContentAction(ContentDataVO contentDataVO, String b_type) {

		contentService.deleteContent(contentDataVO);

		return "redirect:boardNoticePage";
	}

	// 업데이트 페이지
	@RequestMapping("/updateNoticeForm")
	public String updateNoticeForm(ContentDataVO contentDataVO, Model model) {
																				
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);

		return "updateNoticePage";
	}
	@RequestMapping("/updateQnAForm")
	public String updateQnAForm(ContentDataVO contentDataVO, Model model) {
		
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);
		int limit= 5000;
		ArrayList<ProductVO> productVO = productService.getProductList(null, null, limit, null, null, null, null);
		model.addAttribute("productVO", productVO);
		return "updateQnAPage";
	}
	@RequestMapping("updateReviewForm")
	public String updateReviewForm(ContentDataVO contentDataVO, Model model) {
		
		BoardDataVO boardData = contentService.readContent(contentDataVO);
		model.addAttribute("boardDataVO", boardData);

		return "updateReviewPage";
	}
	
	// 업데이트 액션
	@RequestMapping("/updateNoticeAction")
	public String updateNoticeAction(ContentDataVO contentDataVO) {
		contentService.updateNoticeContent(contentDataVO);
		return "redirect:boardNoticePage";
	}
	
	@RequestMapping("/updateQnAAction")
	public String updateQnAAction(ContentDataVO contentDataVO) {
		contentService.updateQnAContent(contentDataVO);
		return "redirect:boardQnAPage";
	}
	
	@RequestMapping("/updateReviewAction")
	public String updateReviewAction(ContentDataVO contentDataVO) {
		contentService.updateReviewContent(contentDataVO);
		return "redirect:boardReviewPage";
	}

//보드에서 파일을 사용하는 곳은 총 6곳, 각각의 보드 writePage와 updatePage... b_type으로 묶을 수 있으니 업로드 로직과 삭제 로직을 넣어 총 4개를 만든다.
	//글쓰기 페이지에서 사용하는 파일 업로드 로직
	@RequestMapping("/fileUploadActionByWritePage")
	public String fileUploadActionByWritePage(MultipartFile[] files, HttpServletRequest request, String b_idx, Model model, String b_type) {
		ArrayList<UploadFileVO> fileList = new ArrayList<UploadFileVO>();

		String uploadRootFolderName = request.getSession().getServletContext().getRealPath("/uploadimg/");

		for (MultipartFile file : files) {
			if (file.getSize() == 0) //
				continue;

			String oriFilename = file.getOriginalFilename();			
			String randomFilename = UUID.randomUUID().toString();
			randomFilename += oriFilename.substring(oriFilename.lastIndexOf('.'));
			System.out.println("저장된 파일명 : " + uploadRootFolderName + randomFilename);
			// 저장하기
			try {
				file.transferTo(new File(uploadRootFolderName + randomFilename)); // 파일 위치 지정해주기
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 경로 구성
			String link = request.getContextPath(); // springMVC/ 위치까지
			link += "/uploadimg/";
			link += randomFilename;
			//세션 뽑기

			// 담아주기
			UploadFileVO fileVO = new UploadFileVO(null, null, link, oriFilename);
			fileList.add(fileVO);
			
		}
		model.addAttribute("fileList", fileList);
		contentService.updateFileContent(fileList, b_idx);
		if(b_type.equals("0")) {
		
		return "redirect:writeNoticePage?b_idx=" + b_idx;
		}else if(b_type.equals("1")) {
			return "redirect:writeReviewPage?b_idx=" + b_idx;
		}else {
			return "redirect:writeQnAPage?b_idx=" + b_idx;
		}
			
	}
	//글쓰기 페이지에서 사용하는 파일 삭제 로직
	@RequestMapping("/fileDeleteActionByWritePage")
	public String fileDeleteActionByWritePage(UploadFileVO uploadFileVO, ContentDataVO contentDataVO, String b_type) {
		
		String b_idx = contentDataVO.getB_idx();
		
		contentDataVO.setB_idx(b_idx);
		
		contentService.deleteFile(uploadFileVO);
		
		if(b_type.equals("0")) {
			return "redirect:writeNoticePage?b_idx=" + b_idx;
		}else if(b_type.equals("1")) {
			return "redirect:writeReviewPage?b_idx="+b_idx;
		}else {
			return "redirect:writeQnAPage?b_idx="+b_idx;
		}
			
	}
	//수정 페이지에서 사용하는 파일 업로드 로직
	@RequestMapping("/fileUploadActionByUpdatePage")
	public String fileUploadActionByUpdatePage(MultipartFile[] files, HttpServletRequest request, String b_idx, Model model, String b_type) {
		ArrayList<UploadFileVO> fileList = new ArrayList<UploadFileVO>();

		String uploadRootFolderName = request.getSession().getServletContext().getRealPath("/uploadimg/");

		for (MultipartFile file : files) {
			if (file.getSize() == 0) //
				continue;

			String oriFilename = file.getOriginalFilename();			
			String randomFilename = UUID.randomUUID().toString();
			randomFilename += oriFilename.substring(oriFilename.lastIndexOf('.'));
			System.out.println("저장된 파일명 : " + uploadRootFolderName + randomFilename);
			// 저장하기
			try {
				file.transferTo(new File(uploadRootFolderName + randomFilename)); // 파일 위치 지정해주기
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 경로 구성
			String link = request.getContextPath(); // springMVC/ 위치까지
			link += "/uploadimg/";
			link += randomFilename;
			//세션 뽑기

			// 담아주기
			UploadFileVO fileVO = new UploadFileVO(null, null, link, oriFilename);
			fileList.add(fileVO);
			
		}
		model.addAttribute("fileList", fileList);
		contentService.updateFileContent(fileList, b_idx);
		if(b_type.equals("0")) {
		return "redirect:updateNoticeForm?b_idx=" + b_idx;
		}else if(b_type.equals("1")) {
			return "redirect:updateReviewForm?b_idx=" + b_idx;
		}else {
			return "redirect:updateQnAForm?b_idx=" + b_idx;
		}
			
	}
	//수정 페이지에서 사용하는 파일 삭제 로직
	@RequestMapping("/fileDeleteActionByUpdatePage")
	public String fileDeleteActionByUpdatePage(UploadFileVO uploadFileVO, ContentDataVO contentDataVO, String b_type) {
		
		String b_idx = contentDataVO.getB_idx();
		
		contentDataVO.setB_idx(b_idx);
		
		contentService.deleteFile(uploadFileVO);
		
		if(b_type.equals("0")) {
			return "redirect:updateNoticePage?b_idx=" + b_idx;
		}else if(b_type.equals("1")) {
			return "redirect:updateReviewPage?b_idx="+b_idx;
		}else {
			return "redirect:updateQnAPage?b_idx="+b_idx;
		}			
	}

	//jsp 테스트 용도로 만듬...
	@RequestMapping("/test")
	public String test() {
		return "test";
	}


	
}