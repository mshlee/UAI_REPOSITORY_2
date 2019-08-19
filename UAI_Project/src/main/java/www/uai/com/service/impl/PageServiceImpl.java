package www.uai.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.uai.com.mapper.ProductSQLMapper;
import www.uai.com.service.PageService;
import www.uai.com.vo.PageVO;

@Service
public class PageServiceImpl implements PageService{

   @Autowired
   private ProductSQLMapper productSQLMapper;
   
   @Override
   public PageVO showPage(String nowPage, int limit, int pageGroupLimit, String changePage, int listCount) {
      
      if(changePage == null && nowPage == null) {
         nowPage = "1";
      }
      
      PageVO pageData = new PageVO(nowPage,0,0,0);
                                                                                                                                              
      int maxPage = (int)(Math.ceil((double) listCount/limit));
      
      pageData.calculatePageGroup(nowPage, maxPage, limit, pageGroupLimit, changePage);
      
      return pageData;
   }
}