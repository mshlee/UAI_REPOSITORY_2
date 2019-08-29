package www.uai.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.UploadProductFileVO;
import www.uai.com.vo.WishListVO;

public interface ProductService {

//dy
	   public ArrayList<ProductVO> getProductList(Model model, String nowPage, int limit, String p_type, String p_location, String searchWord, String order);
	   
	   public ProductDataVO readProductPage(Model model, ProductVO productParam);
	   
	   public ArrayList<ProductDataVO> readwishlistPage(Model model, HttpSession session, String nowPage);
	   
	   public void buyProductAction(OrderDataVO orderParam, HttpSession session);
	   
	   public boolean checkwishlist(Model model, HttpSession session, ProductVO productParam);

	   public void addWishlist(WishListVO wishlistVO, HttpSession session);
	   
	   public void removeWishlist(WishListVO wishlistVO, HttpSession session);
	   
	   public int getProductListCount(String p_type, String p_location, String searchWord);
	   
	   public int getWishListCount();
	   
	   public void increaseBuyCount(String p_idx);
	   
	   public List<ProductVO> autoSearchWord(String keyword);
	   
	   public ArrayList<String> getLocationList(String p_type, String p_location, String searchWord);
	   
	   public String getProductThumbnail(String p_idx);
	   
   
   //ys
   public void writeNewProduct(ProductVO ProductVOParam, ArrayList<UploadProductFileVO> fileList);
   


}