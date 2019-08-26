package www.uai.com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.uai.com.service.ContentService;
import www.uai.com.service.PageService;
import www.uai.com.service.ProductService;
import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.PageVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.WishListVO;

@Controller
public class ProductController {
	@Autowired
	private ContentService contentService;
	
   @Autowired
   private ProductService productService;
   @Autowired
   private PageService pageService;
   
   @RequestMapping("/productListPage")
   public String productListPage(Model model, String nowPage, String changePage) {
      
      // 페이지 처리한 거 여기다 분리해서 적어주기
      int limit = 3;
      int pageGroupLimit = 5;
      
      //전체글 개수 가져오기 
      int listCount = productService.getProductListCount();
      
      PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
      
      //페이지 이동(이전 or 다음)으로 인한 nowPage의 변화
      nowPage = pageVO.getNowPage();
            
      ArrayList<ProductVO> productDataList= productService.getProductList(model, nowPage, limit);
      model.addAttribute("listCount", listCount);
      model.addAttribute("productDataList", productDataList);
      model.addAttribute("pageVO", pageVO);
      
      return "productListPage";
   }
   
   @RequestMapping("/readProductPage")
   public String readProductPage(Model model, HttpSession session, ProductVO productParam) {
      
      ProductDataVO productDataVO = productService.readProductPage(model, productParam);
      model.addAttribute("productData", productDataVO);
      
      // 찜 목록에 해당 상품이 있는지를 보여주세요
      Boolean IsWished = productService.checkwishlist(model, session, productParam);
      model.addAttribute("IsWished", IsWished);

      //별점 준 리뷰의 수를 보여주세요
      int starCount = contentService.getStarCount(productParam);
      model.addAttribute("starCount",starCount);
      
      return "readProductPage";
   }
   
   @RequestMapping("/readWishlistPage")
   public String wishListPage(Model model, HttpSession session, String nowPage, String changePage) {
      
      ArrayList<ProductDataVO> wishlistData = productService.readwishlistPage(model, session, nowPage);
   
      model.addAttribute("wishlistData", wishlistData );
      
      //페이지 처리
      int limit = 5;
      int pageGroupLimit = 5;
      
      int listCount = productService.getWishListCount();
      
      PageVO pageVO = pageService.showPage(nowPage, limit, pageGroupLimit, changePage, listCount);
      
      model.addAttribute("pageVO", pageVO);
      
      return "readWishlistPage";
   }
   
   @RequestMapping("/buyProductPage")
   public String buyProductPage(Model model, ProductVO productParam) {
      
      ProductDataVO productData = productService.readProductPage(model, productParam);
      
      model.addAttribute("productData", productData);
      
      return "buyProductPage";
   }
   
   @RequestMapping("/buyProductAction")
   public String buyProductAction(OrderDataVO orderParam, HttpSession session ) {
      
      productService.buyProductAction(orderParam,session);
      
      return "buyProductCompletePage";
   }
   
   @RequestMapping("/addWishlist")
   @ResponseBody
   public void addWishlist(@RequestParam String p_idx, HttpSession session) {
      
      WishListVO wishParam = new WishListVO();
      wishParam.setP_idx(p_idx);
      
      productService.addWishlist(wishParam, session);
   }
   
   @RequestMapping("/removeWishlist")
   @ResponseBody
   public void removeWishlist(@RequestParam String p_idx, HttpSession session) {
      
      WishListVO wishParam = new WishListVO();
      wishParam.setP_idx(p_idx);
      
      productService.removeWishlist(wishParam, session);
   }
}