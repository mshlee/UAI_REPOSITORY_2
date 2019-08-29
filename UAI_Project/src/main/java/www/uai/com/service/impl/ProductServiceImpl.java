package www.uai.com.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public ArrayList<ProductVO> getProductList(Model model, String nowPage, int limit, String p_type, String p_location, String searchWord, String order) {

		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

		if (nowPage == null) {
			nowPage = "1";
		}

		int startPost = Integer.parseInt(nowPage) * limit - limit + 1;
		int endPost = Integer.parseInt(nowPage) * limit;

		PostnumVO postnum = new PostnumVO();
		postnum.setStartPostNum(startPost);
		postnum.setEndPostNum(endPost);

		//조건 검색 쿼리문 만들기

		//""으로 넘어온 경우 null 처리
		if(p_type != null) {
			if(p_type.length()==0) { p_type=null; }
			if(p_location.length()==0) { p_location=null; }
			if(searchWord.length()==0) { searchWord=null; }
			if(order.length()==0) { order=null; }
		} 

		boolean isEmpty = false;

		if (p_type == null && p_location == null && searchWord == null && order == null ) {
			isEmpty = true;
		}

		if (isEmpty == true) {

			productList = productSQLMapper.selectByPageNum(postnum);

		} else if (isEmpty == false) {

			//정렬
			if(order == null || order.equals("latest")) { order = "P_TYPE DESC"; }
			else if( order.equals("lowPrice") ) { order = "P_NOWPRICE"; }
			else if( order.equals("highPrice") ) { order = "P_NOWPRICE DESC"; }
			else if( order.equals("highSaleCount") ) { order = "P_TOTALSALECOUNT DESC"; }
			else if( order.equals("highStarRate") ) { order = "P_STARRATE DESC"; }
			///
			
			
			String searchQuery = "";
			String andPhrase = " AND ";
			String orPhrase = " OR ";

			if(p_type != null || p_location != null || searchWord != null) {
				searchQuery += "WHERE ";
			}
			
			if (p_type != null) {
				searchQuery += "P_TYPE=" + p_type;
				if (p_location != null || searchWord != null) {
					searchQuery += andPhrase;
				}
			}
			if (p_location != null) {
				searchQuery += "P_LOCATION LIKE " + "'%" + p_location + "%'";
				if (searchWord != null) {
					searchQuery += andPhrase;
				}
			}
			if (searchWord != null) {
				searchQuery += "(" + "P_NAME LIKE " + "'%" + searchWord + "%'" + orPhrase + "P_TEACHER LIKE " + "'%"
						+ searchWord + "%'" + orPhrase + "P_LECTUREINFO LIKE" + "'%" + searchWord + "%'" + orPhrase
						+ "P_TEACHERINFO LIKE" + "'%" + searchWord + "%'" + orPhrase + "P_OTHERINFO LIKE" + "'%" + searchWord
						+ "%'" + ")";
			}

			searchQuery += " ORDER BY " + order;
			
			productList = productSQLMapper.selectByCondition(searchQuery, startPost, endPost);

		}

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
   public int getProductListCount(String p_type, String p_location, String searchWord) {

      int productListCount = 0; 
      
      //""으로 넘어온 경우 null 처리
      if(p_type != null) {
         if(p_location != null || searchWord != null) {
            if(p_type.length()==0) { p_type=null; }
            if(p_location.length()==0) { p_location=null; }
            if(searchWord.length()==0) { searchWord=null; }
         } 
      }
      
      if ((p_type == null || p_type.length() == 0) && (p_location == null || p_location.length() == 0)
            && (searchWord == null || searchWord.length() == 0)) {
         productListCount = productSQLMapper.getProductListCount();
      } else {

         String searchQuery = "";
         String andPhrase = " AND ";
         String orPhrase = " OR ";

         if (p_type != null) {
            searchQuery += "P_TYPE=" + p_type;
            if (p_location != null || searchWord != null) {
               searchQuery += andPhrase;
            }
         }
         if (p_location != null) {
            searchQuery += "P_LOCATION LIKE " + "'%" + p_location + "%'";
            if (searchWord != null) {
               searchQuery += andPhrase;
            }
         }
         if (searchWord != null) {
            searchQuery += "(" + "P_NAME LIKE " + "'%" + searchWord + "%'" + orPhrase + "P_TEACHER LIKE " + "'%"
                  + searchWord + "%'" + orPhrase + "P_LECTUREINFO LIKE " + "'%" + searchWord + "%'" + orPhrase
                  + "P_TEACHERINFO LIKE " + "'%" + searchWord + "%'" + orPhrase + "P_OTHERINFO LIKE " + "'%" + searchWord
                  + "%'" + ")";
         } 
         
         productListCount = productSQLMapper.getListCountByCondition(searchQuery); 
         
      }
      
      return productListCount;
   }

   @Override
   public int getWishListCount() {
      
      int wishListCount = productSQLMapper.getWishListCount();
      
      return wishListCount;
   }
   @Override
   public void increaseBuyCount(String p_idx) {

      ProductVO productVO = productSQLMapper.selectByIdx(p_idx);

      productSQLMapper.increaseBuyCount(productVO);

   }

   @Override
   public List<ProductVO> autoSearchWord(String keyword) {

      List<ProductVO> nameList = productSQLMapper.searchByKeyword(keyword);

      return nameList;
   }

	@Override
	public ArrayList<String> getLocationList(String p_type, String p_location, String searchWord) {

		ArrayList<String> locationList = new ArrayList<String>();
		
		if(p_type != null) {
			if(p_location != null || searchWord != null) {
				if(p_type.length()==0) { p_type=null; }
				if(p_location.length()==0) { p_location=null; }
				if(searchWord.length()==0) { searchWord=null; }
			} 
		}
		
		if ((p_type == null || p_type.length() == 0) && (p_location == null || p_location.length() == 0)
				&& (searchWord == null || searchWord.length() == 0)) {
			locationList = productSQLMapper.selectAllDistinctLocation();
		} else {

			String searchQuery = "";
			String andPhrase = " AND ";
			String orPhrase = " OR ";

			if (p_type != null) {
				searchQuery += "P_TYPE=" + p_type;
				if (p_location != null || searchWord != null) {
					searchQuery += andPhrase;
				}
			}
			if (p_location != null) {
				searchQuery += "P_LOCATION LIKE " + "'%" + p_location + "%'";
				if (searchWord != null) {
					searchQuery += andPhrase;
				}
			}
			if (searchWord != null) {
				searchQuery += "(" + "P_NAME LIKE " + "'%" + searchWord + "%'" + orPhrase + "P_TEACHER LIKE " + "'%"
						+ searchWord + "%'" + orPhrase + "P_LECTUREINFO LIKE " + "'%" + searchWord + "%'" + orPhrase
						+ "P_TEACHERINFO LIKE " + "'%" + searchWord + "%'" + orPhrase + "P_OTHERINFO LIKE " + "'%" + searchWord
						+ "%'" + ")";
			} 
			
			locationList = productSQLMapper.selectDistinctLocation(searchQuery);
			
		}

		return locationList;
	}

   @Override
   public String getProductThumbnail(String p_idx) {
      
      String thumbnail = productSQLMapper.getProductThumbnail(p_idx);
      
      return thumbnail;
   }

   
   //ys
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