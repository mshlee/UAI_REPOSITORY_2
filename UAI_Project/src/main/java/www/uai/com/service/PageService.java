package www.uai.com.service;

import www.uai.com.vo.PageVO;

public interface PageService {

   public PageVO showPage(String nowPage, int limit, int pageGroupLimit, String changePage, int listCount);
   
}