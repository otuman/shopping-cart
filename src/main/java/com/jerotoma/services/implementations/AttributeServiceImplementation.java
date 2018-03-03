package com.jerotoma.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.AttributeDao;
import com.jerotoma.dao.CategoryDao;
import com.jerotoma.model.Attribute;
import com.jerotoma.services.AttributeService;


@Service
@Transactional
public class AttributeServiceImplementation implements AttributeService {
	
	@Autowired
	AttributeDao productAttributeDao;
	
	@Override
	public Attribute getProductAttribute(int id) {
		// TODO Auto-generated method stub
		return productAttributeDao.getProductAttribute(id);
	}

	@Override
	public List<Attribute> getProductAttributes() {
		// TODO Auto-generated method stub
		return productAttributeDao.getProductAttributes();
	}

	@Override
	public Attribute update(Attribute productAttribute) {
		// TODO Auto-generated method stub
		return productAttributeDao.update(productAttribute);
	}

	@Override
	public int save(Attribute productAttribute) {
		// TODO Auto-generated method stub
		return productAttributeDao.save(productAttribute);
	}

	@Override
	public boolean delete(Attribute productAttribute) {
		// TODO Auto-generated method stub
		return productAttributeDao.delete(productAttribute);
	}

}
