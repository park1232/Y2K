package com.world.Y2K.service.payment;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.payment.PaymentDAO;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.PayPageInfo;
import com.world.Y2K.model.vo.Product;
import com.world.Y2K.model.vo.ProductPhoto;

@Service("payService")
public class PaymentImpl implements PaymentService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PaymentDAO payDAO;
	
	@Override
	public int getPayListCount() {
		return payDAO.getPayListCount(sqlSession);
	}
	
	@Override
	public ArrayList<Product> selectProductList(PayPageInfo pi) {
		return payDAO.selectProductList(sqlSession, pi);
	}
	
	@Override
	public ArrayList<ProductPhoto> selectPhotoList() {
		return payDAO.selectPhotoList(sqlSession);
	}
	
	@Override
	public int insertBoard(Product p) {
		return payDAO.insertBoard(sqlSession, p);
	}
	
	@Override
	public int insertPurchaes(ProductPhoto pp) {
		return payDAO.insertPurchaes(sqlSession, pp);
	}
	
	@Override
	public int deletePurchaes(Long pNo) {
		return payDAO.deletePurchaes(sqlSession, pNo);
	}
	
	@Override
	public Product detailPurchaes(Long pNo) {
		return payDAO.detailPurchaes(sqlSession, pNo);
	}
	
	@Override
	public ProductPhoto selectPhoto(Long pNo) {
		return payDAO.selectPhoto(sqlSession, pNo);
	}
	
	@Override
	public int deleteProductPhoto(Long pNo) {
		return payDAO.deleteProductPhoto(sqlSession, pNo);
	}
	
	@Override
	public int orderPurchaes(HashMap<String, Long> map) {
		return payDAO.orderPurchaes(sqlSession, map);
	}
	
	@Override
	public int getOrangeCount(HashMap<String, Long> map) {
		return payDAO.getOrangeCount(sqlSession, map);
	}
	
	@Override
	public Member selectLoginUser(Long mNo) {
		return payDAO.selectLoginUser(sqlSession, mNo);
	}
	
	@Override
	public int paymentRequest(Long mNo) {
		return payDAO.paymentRequest(sqlSession, mNo);
	}
}
