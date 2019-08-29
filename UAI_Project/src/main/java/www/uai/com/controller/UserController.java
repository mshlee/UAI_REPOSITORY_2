package www.uai.com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import www.uai.com.service.UserService;
import www.uai.com.vo.AdminDataVO;
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
   
   @RequestMapping("/memberLoginAction")
   public String memberLoginAction(MemberDataVO vo, HttpSession session) {
      SessionDataVO sessionData = userService.memberLoginProcess(vo);
      
      if(sessionData != null) {
         //로그인 성공
         session.setAttribute("sessionData", sessionData);
      
         return "redirect:mainPage";
      }else {
         
      }
      return "loginFail";
      }
   
   @RequestMapping("/adminLoginAction")
   public String adminLoginAction(AdminDataVO vo, HttpSession session) {
      SessionDataVO sessionData = userService.adminLoginProcess(vo);
      
      if(sessionData != null) {
         //로그인 성공
         session.setAttribute("sessionData", sessionData);
      
         return "redirect:sellerIndex.do";
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
      
      return "joinMemberComplete";
   }
   
   
   
   @RequestMapping("/logoutAction")
   public String logoutAction(HttpSession session) {
      
      session.invalidate();
      
      return "redirect:mainPage";
   }
   
}