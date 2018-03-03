package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.ProductCategoryDao;
import com.jerotoma.model.ProductCategory;

@Repository
@Transactional
public class ProductCategoryDaoImplementation implements ProductCategoryDao {

	@Autowired
	SessionFactory session;
	@Override
	public ProductCategory getProductCategory(int id) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().get(ProductCategory.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCategory> getProductCategories() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from ProductAttribute").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCategory> getProductCategories(int product_id) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from ProductAttribute where product_id='"+product_id+"'").list();
	}

	@Override
	public ProductCategory update(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().update(productCategory);
		return getProductCategory(productCategory.getId());
	}

	@Override
	public int save(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(productCategory);
		return getProductCategory(productCategory.getId()).getId();
	}

	@Override
	public boolean delete(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(productCategory);
		return true;
	}

}
