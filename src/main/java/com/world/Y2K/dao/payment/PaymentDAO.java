package com.world.Y2K.dao.payment;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.PayPageInfo;
import com.world.Y2K.model.vo.Product;
import com.world.Y2K.model.vo.ProductPhoto;

@Repository("payDAO")
public class PaymentDAO {

	public int getPayListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("paymentMapper.getPayListCount");
	}

	public ArrayList<Product> selectProductList(SqlSessionTemplate sqlSession, PayPageInfo pi) {
		int offset = (pi.getPayCurrentPage() -1) * pi.getPayBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getPayBoardLimit());
		return (ArrayList)sqlSession.selectList("paymentMapper.selectProductList", null, rowBounds);
	}

	public ArrayList<ProductPhoto> selectPhotoList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("paymentMapper.selectAttmList");
	}

	public int insertBoard(SqlSessionTemplate sqlSession, Product p) {
		return sqlSession.insert("paymentMapper.insertBoard", p);
	}
	
}
