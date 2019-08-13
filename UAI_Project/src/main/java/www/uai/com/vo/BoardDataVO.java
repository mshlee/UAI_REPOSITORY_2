package www.uai.com.vo;

import java.util.ArrayList;

public class BoardDataVO {
   
      private AdminDataVO adminDataVO;
      private BoardDataVO boardDataVO;
      private MemberDataVO memberDataVO;
      private OrderDataVO orderDataVO;
      private ArrayList<UploadFileVO> fileList;
      
   public BoardDataVO(AdminDataVO adminDataVO, BoardDataVO boardDataVO, MemberDataVO memberDataVO,
         OrderDataVO orderDataVO, ArrayList<UploadFileVO> fileList) {
      super();
      this.adminDataVO = adminDataVO;
      this.boardDataVO = boardDataVO;
      this.memberDataVO = memberDataVO;
      this.orderDataVO = orderDataVO;
      this.fileList = fileList;
   }
   public AdminDataVO getAdminDataVO() {
      return adminDataVO;
   }
   public void setAdminDataVO(AdminDataVO adminDataVO) {
      this.adminDataVO = adminDataVO;
   }
   public BoardDataVO getBoardDataVO() {
      return boardDataVO;
   }
   public void setBoardDataVO(BoardDataVO boardDataVO) {
      this.boardDataVO = boardDataVO;
   }
   public MemberDataVO getMemberDataVO() {
      return memberDataVO;
   }
   public void setMemberDataVO(MemberDataVO memberDataVO) {
      this.memberDataVO = memberDataVO;
   }
   public OrderDataVO getOrderDataVO() {
      return orderDataVO;
   }
   public void setOrderDataVO(OrderDataVO orderDataVO) {
      this.orderDataVO = orderDataVO;
   }
   public ArrayList<UploadFileVO> getFileList() {
      return fileList;
   }
   public void setFileList(ArrayList<UploadFileVO> fileList) {
      this.fileList = fileList;
   }

}