package www.uai.com.service;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;

import www.uai.com.vo.AdvancedSearchDataVO;
=======
import org.springframework.stereotype.Service;

import www.uai.com.vo.AdminDataVO;
>>>>>>> master
=======
import org.springframework.stereotype.Service;

import www.uai.com.vo.AdminDataVO;
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.SessionDataVO;

@Service
public interface UserService {
<<<<<<< HEAD
<<<<<<< HEAD
	public void joinMember(MemberDataVO vo);
	
	public SessionDataVO loginProcess(MemberDataVO vo);
	
	public boolean isExistID(MemberDataVO requestParam);
	
	public ArrayList<MemberDataVO> getAllUserList();
}
=======
=======
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
   public void joinMember(MemberDataVO vo);
   
   public SessionDataVO memberLoginProcess(MemberDataVO vo);
   
   public SessionDataVO adminLoginProcess(AdminDataVO vo);
   
   public boolean isExistMID(MemberDataVO requestParam);
   
   public boolean isExistADID(AdminDataVO requestParam);
<<<<<<< HEAD
}
>>>>>>> master
=======
}
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
