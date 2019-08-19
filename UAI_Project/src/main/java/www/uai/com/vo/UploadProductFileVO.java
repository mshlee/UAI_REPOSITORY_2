package www.uai.com.vo;

public class UploadProductFileVO {

   private String f_idx;
   private String p_idx;
   private String f_path;
   private String f_originalname;
   
   public UploadProductFileVO(String f_idx, String p_idx, String f_path, String f_originalname) {
      super();
      this.f_idx = f_idx;
      this.p_idx = p_idx;
      this.f_path = f_path;
      this.f_originalname = f_originalname;
   }

   public String getF_idx() {
      return f_idx;
   }

   public void setF_idx(String f_idx) {
      this.f_idx = f_idx;
   }

   public String getP_idx() {
      return p_idx;
   }

   public void setP_idx(String p_idx) {
      this.p_idx = p_idx;
   }

   public String getF_path() {
      return f_path;
   }

   public void setF_path(String f_path) {
      this.f_path = f_path;
   }

   public String getF_originalname() {
      return f_originalname;
   }

   public void setF_originalname(String f_originalname) {
      this.f_originalname = f_originalname;
   }
}