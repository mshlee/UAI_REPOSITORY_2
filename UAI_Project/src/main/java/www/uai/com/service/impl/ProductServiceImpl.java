package www.uai.com.service.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import www.uai.com.mapper.ContentSQLMapper;
import www.uai.com.mapper.ProductSQLMapper;
import www.uai.com.mapper.UploadFileSQLMapper;
import www.uai.com.service.ProductService;
import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.PostnumVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.SessionDataVO;
import www.uai.com.vo.UploadProductFileVO;
import www.uai.com.vo.WishListVO;

@Service
public class ProductServiceImpl implements ProductService{
   
   @Autowired
   private ProductSQLMapper productSQLMapper;
   @Autowired
   private UploadFileSQLMapper uploadFileSQLMapper;
   @Autowired
   private ContentSQLMapper contentSQLMapper;
   
   @Override
   public ArrayList<ProductVO> getProductList(Model model, String nowPage, int limit) {
      
      ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

      if(nowPage == null) {
         nowPage = "1";
      }
      
      int startPost = Integer.parseInt(nowPage)*limit-limit+1;
      int endPost = Integer.parseInt(nowPage)*limit;
      
      PostnumVO postnum = new PostnumVO(startPost, endPost);
      
      productList = productSQLMapper.selectByPageNum(postnum);
      
      return productList;
      
   }

   @Override
   public ProductDataVO readProductPage(Model model, ProductVO productParam) {
      
      String p_idx = productParam.getP_idx();
      
      ProductVO productVO = productSQLMapper.selectByIdx(p_idx);
      
      ArrayList<UploadProductFileVO> fileList = new ArrayList<UploadProductFileVO>();
      fileList = uploadFileSQLMapper.selectByP_idx(p_idx);
      
      ProductDataVO productDataVO = new ProductDataVO(productVO, fileList);
      
      return productDataVO;
   }

   @Override
   public ArrayList<ProductDataVO> readwishlistPage(Model model, HttpSession session, String nowPage) {
      
      ArrayList<ProductDataVO> productData = new ArrayList<ProductDataVO>();

      ArrayList<UploadProductFileVO> fileList = new ArrayList<UploadProductFileVO>();
      
      SessionDataVO sessionData = (SessionDataVO)session.getAttribute("sessionData");
      
      String m_idx = sessionData.getM_idx();
      
      //postnum에 시작점 끝점 정해주기
      int limit = 5;
      
      if(nowPage == null) {
         nowPage = "1";
      }
      
      int startPost = Integer.parseInt(nowPage)*limit-limit+1;
      int endPost = Integer.parseInt(nowPage)*limit;
      
      PostnumVO postnumVO = new PostnumVO(startPost,endPost,m_idx);
      
      ArrayList<WishListVO> wishlists = productSQLMapper.selectByMIdx(postnumVO);
      
      for(WishListVO wishlist : wishlists) {
         
         String p_idx = wishlist.getP_idx();
         
         ProductVO productVO = productSQLMapper.selectByIdx(p_idx);
         
         fileList = uploadFileSQLMapper.selectByP_idx(p_idx);
         
         ProductDataVO productDataVO = new ProductDataVO(productVO, fileList);
         
         productData.add(productDataVO);
         
      }
      
      return productData;
   }

   @Override
   public void buyProductAction(OrderDataVO orderParam , HttpSession session ) {
      
	   SessionDataVO sessionData = (SessionDataVO)session.getAttribute("sessionData");
	      
     String m_idx = sessionData.getM_idx();
	   orderParam.setM_idx(m_idx);
      productSQLMapper.buyProductAction(orderParam);
      
   }

   @Override
   public boolean checkwishlist(Model model, HttpSession session, ProductVO productParam) {
      
      boolean IsWished = false;
      
      // 세션에서 m_idx 가져오기
  SessionDataVO sessionData = (SessionDataVO)session.getAttribute("sessionData");
      
      String m_idx = sessionData.getM_idx();
      
      
      // P_IDX 가져오기
      String p_idx = productParam.getP_idx();
      
      // WishListVO 에 두 값 넣어주기
      WishListVO wishListVO = new WishListVO();
      wishListVO.setM_idx(m_idx);
      wishListVO.setP_idx(p_idx);
      
      // wishlist의 값 가져오기
      ArrayList<WishListVO> wishListdata = productSQLMapper.selectAllByMIdx(wishListVO);
      
      // wishList에 값이 있으면 상품이 wishlist에 담겨있다는 의미니까 IsWished 의 값을 true로 바꿔줄 것
      if(wishListdata.size() != 0){
         IsWished = true;
      }
      
      return IsWished;
   }

   @Override
   public void addWishlist(WishListVO wishlistVO, HttpSession session) {
      
      //세션의 m_idx를 넣어주기
	   SessionDataVO sessionData = (SessionDataVO)session.getAttribute("sessionData");
	      
	      String m_idx = sessionData.getM_idx();
      wishlistVO.setM_idx(m_idx);
      
      productSQLMapper.addWishlist(wishlistVO);
   }

   @Override
   public void removeWishlist(WishListVO wishlistVO, HttpSession session) {
      
      //세션의 m_idx를 넣어주기
	   SessionDataVO sessionData = (SessionDataVO)session.getAttribute("sessionData");
	      
	      String m_idx = sessionData.getM_idx();
	      
      wishlistVO.setM_idx(m_idx);
      
      productSQLMapper.removeWishlist(wishlistVO);
   }

   @Override
   public int getProductListCount() {
      
      int productListCount = productSQLMapper.getProductListCount();
      
      return productListCount;
   }

   @Override
   public int getWishListCount() {
      
      int wishListCount = productSQLMapper.getWishListCount();
      
      return wishListCount;
   }
   

   @Override
   @Transactional
   public void writeNewProduct(ProductVO ProductVOParam, ArrayList<UploadProductFileVO> fileList) {
      // TODO Auto-generated method stub
      
      String key = productSQLMapper.getPKey();
      
      ProductVOParam.setP_idx(key);
      productSQLMapper.insertProduct(ProductVOParam);
      
      for(UploadProductFileVO uploadProductFileVO : fileList) {
         uploadProductFileVO.setP_idx(key);
         uploadFileSQLMapper.insertProductFile(uploadProductFileVO);
      }
   
   }



}