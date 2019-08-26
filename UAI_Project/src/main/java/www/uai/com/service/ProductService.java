package www.uai.com.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.UploadProductFileVO;
import www.uai.com.vo.WishListVO;

public interface ProductService {

   public ArrayList<ProductVO> getProductList(Model model, String nowPage, int limit);
   
   public ProductDataVO readProductPage(Model model, ProductVO productParam);
   
   public ArrayList<ProductDataVO> readwishlistPage(Model model, HttpSession session, String nowPage);
   
   public void buyProductAction(OrderDataVO orderParam ,HttpSession session);
   
   public boolean checkwishlist(Model model, HttpSession session, ProductVO productParam);

   public void addWishlist(WishListVO wishlistVO, HttpSession session);
   
   public void removeWishlist(WishListVO wishlistVO, HttpSession session);
   
   public int getProductListCount();
   
   public int getWishListCount();
   
   public void writeNewProduct(ProductVO ProductVOParam, ArrayList<UploadProductFileVO> fileList);
   


}