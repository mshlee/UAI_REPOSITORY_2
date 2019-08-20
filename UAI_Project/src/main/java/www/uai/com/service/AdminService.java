package www.uai.com.service;

import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.SessionDataVO;

public interface AdminService {

   public void joinAdmin(AdminDataVO adminDataVO);
   
   public SessionDataVO loginProcess(AdminDataVO AdminDataVO);
   
   public boolean isExistID(AdminDataVO adminDataVO);
   
   
   
}