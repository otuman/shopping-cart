package com.jerotoma.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.ProductAttributeDao;
import com.jerotoma.dao.ProductCategoryDao;
import com.jerotoma.model.ProductAttribute;
import com.jerotoma.services.ProductAttributeService;


@Service
@Transactional
public class ProductAttributeServiceImplementation implements ProductAttributeService {
	
	@Autowired
	ProductAttributeDao productAttributeDao;
	
	@Override
	public ProductAttribute getProductAttribute(int id) {
		// TODO Auto-generated method stub
		return productAttributeDao.getProductAttribute(id);
	}

	@Override
	public List<ProductAttribute> getProductAttributes() {
		// TODO Auto-generated method stub
		return productAttributeDao.getProductAttributes();
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
