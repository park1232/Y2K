package com.world.Y2K.service.payment;

import java.util.ArrayList;

import com.world.Y2K.model.vo.PayPageInfo;
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
	
}
