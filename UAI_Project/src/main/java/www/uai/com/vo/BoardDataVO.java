package www.uai.com.vo;

import java.util.ArrayList;

public class BoardDataVO {
   
      private AdminDataVO adminDataVO;
      private ContentDataVO contentDataVO;
      private MemberDataVO memberDataVO;
      private OrderDataVO orderDataVO;
      private ArrayList<UploadFileVO> fileList;
      private ProductVO productVO;
      
      
    public BoardDataVO() {
    	super();
    }

    

      
	public BoardDataVO(AdminDataVO adminDataVO, ContentDataVO contentDataVO, MemberDataVO memberDataVO,
			OrderDataVO orderDataVO, ArrayList<UploadFileVO> fileList,ProductVO productVO) {
		super();
		this.adminDataVO = adminDataVO;
		this.contentDataVO = contentDataVO;
		this.memberDataVO = memberDataVO;
		this.orderDataVO = orderDataVO;
		this.fileList = fileList;
		this.productVO = productVO;
	}


	public AdminDataVO getAdminDataVO() {
		return adminDataVO;
	}


	public void setAdminDataVO(AdminDataVO adminDataVO) {
		this.adminDataVO = adminDataVO;
	}


	public ContentDataVO getContentDataVO() {
		return contentDataVO;
	}


	public void setContentDataVO(ContentDataVO contentDataVO) {
		this.contentDataVO = contentDataVO;
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

	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}
      
}