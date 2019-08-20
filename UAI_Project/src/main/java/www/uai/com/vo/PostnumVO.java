package www.uai.com.vo;

public class PostnumVO {

   private int startPostNum, endPostNum;
   private String m_idx;

   public PostnumVO() {}
   
   public PostnumVO(int startPostNum, int endPostNum) {
      super();
      this.startPostNum = startPostNum;
      this.endPostNum = endPostNum;
   }

   public PostnumVO(int startPostNum, int endPostNum, String m_idx) {
      super();
      this.startPostNum = startPostNum;
      this.endPostNum = endPostNum;
      this.m_idx = m_idx;
   }

   public int getStartPostNum() {
      return startPostNum;
   }

   public void setStartPostNum(int startPostNum) {
      this.startPostNum = startPostNum;
   }

   public int getEndPostNum() {
      return endPostNum;
   }

   public void setEndPostNum(int endPostNum) {
      this.endPostNum = endPostNum;
   }

   public String getM_idx() {
      return m_idx;
   }

   public void setM_idx(String m_idx) {
      this.m_idx = m_idx;
   }
   
}