package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.AttributeDao;
import com.jerotoma.model.Product;
import com.jerotoma.model.Attribute;

@Repository
@Transactional
public class AttributeDaoImplementation implements AttributeDao {

	
	@Autowired
	SessionFactory session; 
	
	@Override
	public Attribute getProductAttribute(int id) {
		// TODO Auto-generated method stub
		
		
		return (Attribute)session.getCurrentSession().get(Attribute.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attribute> getProductAttributes() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Attribute").list();
	}

	@Override
	public Attribute update(Attribute productAttribute) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(productAttribute);;
		return getProductAttribute(productAttribute.getId());
	}

	@Override
	public int save(Attribute productAttribute) {
		if(null != productAttribute) {
			session.getCurrentSession().save(productAttribute);
			return productAttribute.getId();
		}
		
		return 0;
	}

	@Override
	public boolean delete(Attribute productAttribute) {
		if(null != productAttribute) {
			session.getCurrentSession().delete(productAttribute);
			return true;
		}
		
		return false;
	}

}
