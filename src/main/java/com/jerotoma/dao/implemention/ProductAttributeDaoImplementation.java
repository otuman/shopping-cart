package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.ProductAttributeDao;
import com.jerotoma.model.Product;
import com.jerotoma.model.ProductAttribute;

@Repository
@Transactional
public class ProductAttributeDaoImplementation implements ProductAttributeDao {

	
	@Autowired
	SessionFactory session; 
	
	@Override
	public ProductAttribute getProductAttribute(int id) {
		// TODO Auto-generated method stub
		
		
		return (ProductAttribute)session.getCurrentSession().get(ProductAttribute.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductAttribute> getProductAttributes() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from ProductAttribute").list();
	}

	@Override
	public ProductAttribute update(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(productAttribute);;
		return getProductAttribute(productAttribute.getId());
	}

	@Override
	public int save(ProductAttribute productAttribute) {
		if(null != productAttribute) {
			session.getCurrentSession().save(productAttribute);
			return productAttribute.getId();
		}
		
		return 0;
	}

	@Override
	public boolean delete(ProductAttribute productAttribute) {
		if(null != productAttribute) {
			session.getCurrentSession().delete(productAttribute);
			return true;
		}
		
		return false;
	}

}
