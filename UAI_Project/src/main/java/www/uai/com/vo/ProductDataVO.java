package www.uai.com.vo;

import java.util.ArrayList;

public class ProductDataVO {
   
   private ProductVO productVO;
   private ArrayList<UploadProductFileVO> fileList;

   public ProductDataVO(ProductVO productVO, ArrayList<UploadProductFileVO> fileList) {
      super();
      this.productVO = productVO;
      this.fileList = fileList;
   }

   public ProductVO getProductVO() {
      return productVO;
   }

   public void setProductVO(ProductVO productVO) {
      this.productVO = productVO;
   }

   public ArrayList<UploadProductFileVO> getFileList() {
      return fileList;
   }

   public void setFileList(ArrayList<UploadProductFileVO> fileList) {
      this.fileList = fileList;
   }

}