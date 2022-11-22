package com.world.Y2K.service.payment;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.payment.PaymentDAO;
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
}
