package www.uai.com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import www.uai.com.service.UserService;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.SessionDataVO;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/loginAction")
	public String loginAction(MemberDataVO vo, HttpSession session) {
		SessionDataVO sessionData = userService.loginProcess(vo);
		
		if(sessionData != null) {
			//로그인 성공
			session.setAttribute("sessionData", sessionData);
		
			return "redirect:mainPage";
		}else {
			
		}
		return "loginFail";
		}

	
	@RequestMapping("/joinMemberForm")
	public String joinMemberForm() {
		return "joinMemberForm";
	}
	
	@RequestMapping("/joinMemberAction")
	public String joinMemberAction(MemberDataVO vo, HttpSession session) {
		
		userService.joinMember(vo);
		
		return "redirect:joinMemberComplete";
	}
	
	
	@RequestMapping("/logoutAction")
	public String logoutAction(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:mainPage";
	}
	
}
