package www.uai.com.service;

import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.SessionDataVO;

public interface UserService {
	public void joinMember(MemberDataVO vo);
	
	public SessionDataVO loginProcess(MemberDataVO vo);
	
	public boolean isExistID(MemberDataVO requestParam);
}
