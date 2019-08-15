package www.uai.com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.uai.com.mapper.SellerContentSQLMapper;
import www.uai.com.service.SellerContentService;
import www.uai.com.vo.MemberDataVO;
import www.uai.com.vo.OrderDataVO;
import www.uai.com.vo.ProductDataVO;
import www.uai.com.vo.ProductVO;
import www.uai.com.vo.SellerContentVO;

@Service
public class SellerContentServiceImpl implements SellerContentService {
	
	@Autowired
	private SellerContentSQLMapper sellerContentSQLMapper;

	@Override
	public void deleteProductByIdx(ArrayList<ProductVO> productVO) {
		// TODO Auto-generated method stub
		
		for(ProductVO product : productVO) {
			sellerContentSQLMapper.deleteProductByIdx(product.getP_idx());
		}
		
	}

	@Override
	public void deleteMemberByIdx(ArrayList<MemberDataVO> memberVO) {
		// TODO Auto-generated method stub
		
		for(MemberDataVO members : memberVO) {
			sellerContentSQLMapper.deleteMembersByIdx(members.getM_idx());
		}

	}

	@Override
	public ArrayList<OrderDataVO> getAllOrderList() {
		// TODO Auto-generated method stub
		ArrayList<OrderDataVO> orderList = new ArrayList<OrderDataVO>();
		orderList = sellerContentSQLMapper.getAllOrderList();
		
		return null;
	}
	
	
	
	

}
