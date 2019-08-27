package www.uai.com.service;

import org.springframework.stereotype.Service;

import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.SessionDataVO;


public interface UserService {
   public void joinMember(MemberDataVO vo);
   
   public SessionDataVO memberLoginProcess(MemberDataVO vo);
   
   public SessionDataVO adminLoginProcess(AdminDataVO vo);
   
   public boolean isExistMID(MemberDataVO requestParam);
   
   public boolean isExistADID(AdminDataVO requestParam);
}