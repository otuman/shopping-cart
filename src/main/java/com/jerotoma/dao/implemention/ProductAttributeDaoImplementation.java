package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.ProductAttributeDao;
import com.jerotoma.model.Media;
import com.jerotoma.model.ProductAttribute;


@Repository
@Transactional
public class ProductAttributeDaoImplementation implements ProductAttributeDao {

	@Autowired
	SessionFactory session;
	
	
	@Override
	public ProductAttribute getProductCategory(int id) {
		// TODO Auto-generated method stub
		return (ProductAttribute)session.getCurrentSession().get(ProductAttribute.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductAttribute> getProductCategories() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from ProductAttribute").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductAttribute> getProductCategories(int product_id) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from ProductAttribute where product_id='"+product_id+"'").list();
	}

	@Override
	public ProductAttribute update(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(productAttribute);
		return getProductCategory(productAttribute.getId());
	}

	@Override
	public int save(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(productAttribute);
		return productAttribute.getId();
	}

	@Override
	public boolean delete(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		return true;
	}

}
