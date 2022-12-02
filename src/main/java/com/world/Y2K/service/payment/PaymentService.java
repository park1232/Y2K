package com.world.Y2K.service.payment;

import java.util.ArrayList;
import java.util.HashMap;

import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.PayPageInfo;
import com.world.Y2K.model.vo.Payment;
import com.world.Y2K.model.vo.Product;
import com.world.Y2K.model.vo.ProductPhoto;

public interface PaymentService {

	int getPayListCount();

	ArrayList<Product> selectProductList(PayPageInfo pi);

	ArrayList<ProductPhoto> selectPhotoList();

	int insertBoard(Product p);

	int insertPurchaes(ProductPhoto pp);

	int deletePurchaes(Long pNo);

	Product detailPurchaes(Long pNo);

	ProductPhoto selectPhoto(Long pNo);

	int deleteProductPhoto(Long pNo);

	int orderPurchaes(HashMap<String, Long> map);

	int getOrangeCount(HashMap<String, Long> map);

	Member selectLoginUser(Long mNo);

	int paymentRequest(Long mNo);

	int paymentInsert(Payment paymentInsertObject);

	int paymentRequest2(Long mNo);

	int paymentRequest3(Long mNo);

	int mainSkinUpdate(HashMap<String, Object> map2);

	int checkSkinHistory(HashMap<String, Object> map2);
	
}
