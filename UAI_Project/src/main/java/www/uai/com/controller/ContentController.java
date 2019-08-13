package www.uai.com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import www.uai.com.service.ContentService;
import www.uai.com.vo.BoardDataPageVO;
import www.uai.com.vo.BoardDataVO;
import www.uai.com.vo.ContentDataVO;
import www.uai.com.vo.UploadFileVO;

@Controller
public class ContentController {

	//사용할 메서드들 가져오기 
	@Autowired
	private ContentService contentService;

	// "/"이 붙으면 여기로!
	@RequestMapping("/")
	public String home() {
		
		return "mainPage";
	}
	
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "";
	}
	
	
	@RequestMapping("/boardPage")
	public String boardPage(Model model, String searchWord, String searchTarget, int nowPage, String b_type) { // 여러 개가 넘어올 경우 VO를 또 생성하여 받아올 수 있음. 싫으면 ContentVO에 string searchWord를 추가하던가.
		
		BoardDataPageVO list = contentService.getContentsList(searchWord, searchTarget, nowPage, b_type); // getContentsList 내부에서 검색어 있음/없음 분기를 나누던가, 아니면 또다른 메서드를 한 개 더 만들던가.
		
		//model 객체에 넣어서 전달해주기
		model.addAttribute("boardDataList", list);
		
		return "boardPage";
	}
	
	//MultipartFile 사용하기 위한 요구 조건
	//1. pon.xml 파일 관련 라이브러리 있어야 함
	//2. servlet xml에 annotation-driven 이 있어야 함
	//3. servlet xml에 multipartResolver id로 된 bean 등록이 되어야 함.
	//4. jsp 파일 폼태그 안에 enctype="multipart/form-data" 가 있어야 파일로 인식함
	
	// 주의할 것 : publish 할 때마다 uploadimg에 올라간 이미지들이 날아감
	
	@RequestMapping("/writeContentForm")
	public String writeContentForm() {
		
		return "writeContentForm";
	}
	
	@RequestMapping("/writeContentAction")
	public String writeContentAction(MultipartFile [] files, ContentDataVO requestParam, HttpServletRequest request) { // request는 위치 받아오기 용도
		
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
		
		contentService.writeContent(requestParam,fileList);
		
		return "redirect:boardPage";
	}
	
	@RequestMapping("/readContentPage")
	public String readContentPage(ContentDataVO requestParam,Model model) { //직접 전달해준 거 이외에 추가적으로 넣고 싶은 애가 있을 때 : model 사용하기!(request와 동일한 쓰임)
		
		contentService.increaseCount(requestParam);
		
		BoardDataVO boardData = contentService.readContent(requestParam);
		
		model.addAttribute("boardData", boardData);
		
		return "readContentPage";
	}
	
	@RequestMapping("/deleteContentAction")
	public String deleteContentAction(ContentDataVO requestParam) {
		
		contentService.deleteContent(requestParam);
		
		return "redirect:boardPage";
	}
	
	@RequestMapping("/updateContentForm")
	public String updateContentForm(ContentDataVO requestParam,Model model) { //parameter에 c_idx의 정보가 아직 담겨 있음 ( ${param.c_idx} )로 jsp에서 받아와도 됨. )
		
		BoardDataVO boardData = contentService.readContent(requestParam);
		
		model.addAttribute("boardData", boardData);
		
		return "updateContentForm";
	}
	
	@RequestMapping("/updateContentAction")
	public String updateContentAction(ContentDataVO requestParam) {
		
		String b_idx = requestParam.getB_idx();
		
		contentService.updateContent(requestParam);
		
		return "redirect:readContentPage?c_idx=" + b_idx;
	}
}