package www.uai.com.vo;

public class WishListVO {
   
   private String w_idx;
   private String m_idx;
   private String p_idx;
   private String w_wishdate;
   
   public WishListVO() {}
   
   public WishListVO(String w_idx, String m_idx, String p_idx, String w_wishdate) {
      super();
      this.w_idx = w_idx;
      this.m_idx = m_idx;
      this.p_idx = p_idx;
      this.w_wishdate = w_wishdate;
   }

   public String getW_idx() {
      return w_idx;
   }

   public void setW_idx(String w_idx) {
      this.w_idx = w_idx;
   }

   public String getM_idx() {
      return m_idx;
   }

   public void setM_idx(String m_idx) {
      this.m_idx = m_idx;
   }

   public String getP_idx() {
      return p_idx;
   }

   public void setP_idx(String p_idx) {
      this.p_idx = p_idx;
   }

   public String getW_wishdate() {
      return w_wishdate;
   }

   public void setW_wishdate(String w_wishdate) {
      this.w_wishdate = w_wishdate;
   }
}