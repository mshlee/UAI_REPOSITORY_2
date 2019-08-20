package www.uai.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.uai.com.mapper.UserSQLMapper;
import www.uai.com.service.UserService;
import www.uai.com.vo.AdminDataVO;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.SessionDataVO;

@Service
public class UserServiceImpl implements UserService{

   @Autowired
   private UserSQLMapper userSQLMapper;
   
   public void joinMember(MemberDataVO vo) {
      userSQLMapper.insert(vo);
   }

   @Override
   public SessionDataVO memberLoginProcess(MemberDataVO vo) {
      // TODO Auto-generated method stub
      MemberDataVO result = userSQLMapper.selectByMId(vo.getM_id());
      
      SessionDataVO sessionData = null;
      
      if(result != null && result.getM_pw().equals(vo.getM_pw())) {
         //로그인 성공
         sessionData = new SessionDataVO(result.getM_idx(), result.getM_nick(), null, null);
      }else {
         //로그인 실패
      }
      
      return sessionData;
   }
   
   
   @Override
   public SessionDataVO adminLoginProcess(AdminDataVO vo) {
      // TODO Auto-generated method stub
	   AdminDataVO result = userSQLMapper.selectByADId(vo.getAd_id());
      
      SessionDataVO sessionData = null;
      
      if(result != null && result.getAd_pw().equals(vo.getAd_pw())) {
         //로그인 성공
         sessionData = new SessionDataVO(result.getAd_id(), result.getAd_nick(), null, null);
      }else {
         //로그인 실패
      }
      
      return sessionData;
   }


   @Override
   public boolean isExistMID(MemberDataVO requestParam) {
      // TODO Auto-generated method stub
      MemberDataVO memberdata = userSQLMapper.selectByMId(requestParam.getM_id());
      //data가 어떤 값이냐가 중요한게 아니라, 있냐 없냐가 중요
      if(memberdata != null) {
         
         return true;
      }
      
      return false;
   }
   
   @Override
   public boolean isExistADID(AdminDataVO requestParam) {
      // TODO Auto-generated method stub
      AdminDataVO admindata = userSQLMapper.selectByADId(requestParam.getAd_id());
      //data가 어떤 값이냐가 중요한게 아니라, 있냐 없냐가 중요
      if(admindata != null) {
         
         return true;
      }
      
      return false;
   }
   



}
