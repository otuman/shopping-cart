package com.jerotoma.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerotoma.dao.ProductAttributeDao;
import com.jerotoma.model.ProductAttribute;
import com.jerotoma.services.ProductAttributeService;

@Service
@Transactional
public class ProductAttributeServiceImplementation implements  ProductAttributeService {
	
	@Autowired
	ProductAttributeDao  productAttributeDao;

	@Override
	public ProductAttribute getProductCategory(int id) {
		// TODO Auto-generated method stub
		return productAttributeDao.getProductCategory(id);
	}

	@Override
	public List<ProductAttribute> getProductCategories() {
		// TODO Auto-generated method stub
		return productAttributeDao.getProductCategories();
	}

	@Override
	public List<ProductAttribute> getProductCategories(int product_id) {
		// TODO Auto-generated method stub
		return productAttributeDao.getProductCategories(product_id);
	}

	@Override
	public ProductAttribute update(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		return productAttributeDao.update(productAttribute);
	}

	@Override
	public int save(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		return productAttributeDao.save(productAttribute);
	}

	@Override
	public boolean delete(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		return productAttributeDao.delete(productAttribute);
	}

}
