package www.uai.com.service;

<<<<<<< HEAD
import java.util.ArrayList;

import www.uai.com.vo.AdvancedSearchDataVO;
=======
import org.springframework.stereotype.Service;

import www.uai.com.vo.AdminDataVO;
>>>>>>> master
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.SessionDataVO;

@Service
public interface UserService {
<<<<<<< HEAD
	public void joinMember(MemberDataVO vo);
	
	public SessionDataVO loginProcess(MemberDataVO vo);
	
	public boolean isExistID(MemberDataVO requestParam);
	
	public ArrayList<MemberDataVO> getAllUserList();
}
=======
   public void joinMember(MemberDataVO vo);
   
   public SessionDataVO memberLoginProcess(MemberDataVO vo);
   
   public SessionDataVO adminLoginProcess(AdminDataVO vo);
   
   public boolean isExistMID(MemberDataVO requestParam);
   
   public boolean isExistADID(AdminDataVO requestParam);
}
>>>>>>> master
