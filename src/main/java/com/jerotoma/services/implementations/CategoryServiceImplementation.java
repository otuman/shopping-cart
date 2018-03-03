package com.jerotoma.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.CategoryDao;
import com.jerotoma.model.Category;
import com.jerotoma.services.CategoryService;

@Service
@Transactional
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	CategoryDao productCategoryDao;
	
	@Override
	public Category getProductCategory(int id) {
		// TODO Auto-generated method stub
		return productCategoryDao.getProductCategory(id);
	}

	@Override
	public List<Category> getProductCategories() {
		// TODO Auto-generated method stub
		return productCategoryDao.getProductCategories();
	}

	@Override
	public Category update(Category productCategory) {
		// TODO Auto-generated method stub
		return productCategoryDao.update(productCategory);
	}

	@Override
	public int save(Category productCategory) {
		// TODO Auto-generated method stub
		return productCategoryDao.save(productCategory);
	}

	@Override
	public boolean delete(Category productCategory) {
		// TODO Auto-generated method stub
		return productCategoryDao.delete(productCategory);
	}

}
