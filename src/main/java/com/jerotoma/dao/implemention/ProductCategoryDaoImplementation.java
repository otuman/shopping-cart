package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.ProductCategoryDao;
import com.jerotoma.model.Product;
import com.jerotoma.model.ProductAttribute;
import com.jerotoma.model.ProductCategory;



@Repository
@Transactional
public class ProductCategoryDaoImplementation implements ProductCategoryDao {

	
	@Autowired
	SessionFactory session;  
	
	
	@Override
	public ProductCategory getProductCategory(int id) {
		// TODO Auto-generated method stub
		return (ProductCategory)session.getCurrentSession().get(ProductCategory.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCategory> getProductCategories() {
		// TODO Auto-generated method stub
		return (List<ProductCategory>)session.getCurrentSession().createQuery("from ProductCategory").list();
	}

	@Override
	public ProductCategory update(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(productCategory);;
		return getProductCategory(productCategory.getId());
	}

	@Override
	public int save(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		if(null != productCategory) {
			session.getCurrentSession().save(productCategory);
			return productCategory.getId();
		}
		
		return 0;
	}

	@Override
	public boolean delete(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		return false;
	}


}
