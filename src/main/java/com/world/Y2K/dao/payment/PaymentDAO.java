package com.world.Y2K.dao.payment;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.PayPageInfo;
import com.world.Y2K.model.vo.Payment;
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

	public int insertPurchaes(SqlSessionTemplate sqlSession, ProductPhoto pp) {
		return sqlSession.insert("paymentMapper.insertPurchaes", pp);
	}

	public int deletePurchaes(SqlSessionTemplate sqlSession, Long pNo) {
		return sqlSession.update("paymentMapper.deletePurchaes", pNo);
	}

	public Product detailPurchaes(SqlSessionTemplate sqlSession, Long pNo) {
		return sqlSession.selectOne("paymentMapper.detailPurchaes" ,pNo);
	}

	public ProductPhoto selectPhoto(SqlSessionTemplate sqlSession, Long pNo) {
		return sqlSession.selectOne("paymentMapper.selectPhoto", pNo);
	}

	public int deleteProductPhoto(SqlSessionTemplate sqlSession, Long pNo) {
		return sqlSession.update("paymentMapper.deleteProductPhoto", pNo);
	}

	public int orderPurchaes(SqlSessionTemplate sqlSession, HashMap<String, Long> map) {
		return sqlSession.update("paymentMapper.orderPurchaes", map);
	}

	public int getOrangeCount(SqlSessionTemplate sqlSession, HashMap<String, Long> map) {
		return sqlSession.selectOne("paymentMapper.getOrangeCount", map);
	}

	public Member selectLoginUser(SqlSessionTemplate sqlSession, Long mNo) {
		return sqlSession.selectOne("paymentMapper.selectLoginUser", mNo);
	}

	public int paymentRequest(SqlSessionTemplate sqlSession, Long mNo) {
		return sqlSession.update("paymentMapper.paymentRequest", mNo);
	}

	public int paymentInsert(SqlSessionTemplate sqlSession, Long mNo) {
		return sqlSession.insert("paymentMapper.paymentInsert", mNo);
	}

	public int paymentInsert(SqlSessionTemplate sqlSession, Payment paymentInsertObject) {
		return sqlSession.insert("paymentMapper.paymentInsert", paymentInsertObject);
		
	}

	public int paymentRequest2(SqlSessionTemplate sqlSession, Long mNo) {
		return sqlSession.insert("paymentMapper.paymentRequest2", mNo);
	}

	public int paymentRequest3(SqlSessionTemplate sqlSession, Long mNo) {
		return sqlSession.insert("paymentMapper.paymentRequest3", mNo);
	}

	public int mainSkinUpdate(SqlSessionTemplate sqlSession, HashMap<String, Object> map2) {
		return sqlSession.update("paymentMapper.mainSkinUpdate", map2);
	}

	public int checkSkinHistory(SqlSessionTemplate sqlSession, HashMap<String, Object> map2) {
		return sqlSession.selectOne("paymentMapper.checkSkinHistory", map2);
	}
}
