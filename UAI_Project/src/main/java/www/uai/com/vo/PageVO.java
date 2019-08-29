package www.uai.com.vo;

public class PageVO {

   private String nowPage;
   private int startOfPageGroup;
   private int endOfPageGroup;
   private int maxPage;
   
   public PageVO() {
	   
   }
   public PageVO(String nowPage, int startOfPageGroup, int endOfPageGroup, int maxPage) {
      super();
      this.nowPage = nowPage;
      this.startOfPageGroup = startOfPageGroup;
      this.endOfPageGroup = endOfPageGroup;
      this.maxPage = maxPage;
   }

   public String getNowPage() {
      return nowPage;
   }

   public void setNowPage(String nowPage) {
      this.nowPage = nowPage;
   }

   public int getStartOfPageGroup() {
      return startOfPageGroup;
   }

   public void setStartOfPageGroup(int startOfPageGroup) {
      this.startOfPageGroup = startOfPageGroup;
   }

   public int getEndOfPageGroup() {
      return endOfPageGroup;
   }

   public void setEndOfPageGroup(int endOfPageGroup) {
      this.endOfPageGroup = endOfPageGroup;
   }
   
   public int getMaxPage() {
      return maxPage;
   }

   public void setMaxPage(int maxPage) {
      this.maxPage = maxPage;
   }

   public void calculatePageGroup(String nowPage, int maxPage, int limit, int pageGroupLimit, String changePage) {
      
      int startPage = pageGroupLimit * ((int)(Math.ceil((double)Integer.parseInt(nowPage)/pageGroupLimit)) - 1) + 1;
      
      // 이전 혹은 다음 버튼을 누른 경우(chagePage에 값이 전달된 경우)
      if(changePage != null && changePage.equals("next")) {
         startPage = startPage + pageGroupLimit;
         nowPage = Integer.toString(startPage);
      }else if(changePage != null && changePage.equals("previous")) {
         startPage = startPage - pageGroupLimit;
         nowPage = Integer.toString(startPage + pageGroupLimit - 1);
      }
      
      int endPage = startPage + (pageGroupLimit -1);                                                                       
      
      if(endPage > maxPage) {                                                                            
          endPage = maxPage;                                          
      }
      
      this.startOfPageGroup = startPage;
      this.endOfPageGroup = endPage;
      this.maxPage = maxPage;
      this.nowPage = nowPage;
   }
   
}