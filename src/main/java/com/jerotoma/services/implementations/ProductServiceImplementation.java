package com.jerotoma.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerotoma.dao.ProductDao;
import com.jerotoma.model.Product;
import com.jerotoma.services.ProductService;



@Service
@Transactional
public class ProductServiceImplementation implements ProductService {

	
	@Autowired
	ProductDao productDao;
	
	
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.getProduct(id);
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.getProducts();
	}

	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productDao.update(product);
	}

	public int save(Product product){
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return productDao.delete(product);
	}

}
