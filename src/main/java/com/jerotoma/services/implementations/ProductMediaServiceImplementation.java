package com.jerotoma.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerotoma.dao.ProductMediaDao;
import com.jerotoma.model.ProductMedia;
import com.jerotoma.services.ProductMediaService;

@Service
@Transactional
public class ProductMediaServiceImplementation implements ProductMediaService {
	
	@Autowired
	ProductMediaDao productMediaDao;

	public ProductMedia getProductMedia(int id) {
		// TODO Auto-generated method stub
		return productMediaDao.getProductMedia(id);
	}

	public List<ProductMedia> getProductMediaList() {
		// TODO Auto-generated method stub
		return productMediaDao.getProductMediaList();
	}

	public ProductMedia update(ProductMedia productMedia) {
		// TODO Auto-generated method stub
		return productMediaDao.update(productMedia);
	}

	public int save(ProductMedia productMedia) {
		// TODO Auto-generated method stub
		return productMediaDao.save(productMedia);
	}

	public boolean delete(ProductMedia productMedia) {
		// TODO Auto-generated method stub
		return productMediaDao.delete(productMedia);
	}

	public List<ProductMedia> getProductMediaList(int product_id) {
		// TODO Auto-generated method stub
		return productMediaDao.getProductMediaList(product_id);
	}

}
