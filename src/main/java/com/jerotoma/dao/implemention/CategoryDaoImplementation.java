package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.CategoryDao;
import com.jerotoma.model.Product;
import com.jerotoma.model.Attribute;
import com.jerotoma.model.Category;



@Repository
@Transactional
public class CategoryDaoImplementation implements CategoryDao {

	
	@Autowired
	SessionFactory session;  
	
	
	@Override
	public Category getProductCategory(int id) {
		// TODO Auto-generated method stub
		return (Category)session.getCurrentSession().get(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getProductCategories() {
		// TODO Auto-generated method stub
		return (List<Category>)session.getCurrentSession().createQuery("from Category").list();
	}

	@Override
	public Category update(Category productCategory) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(productCategory);;
		return getProductCategory(productCategory.getId());
	}

	@Override
	public int save(Category productCategory) {
		// TODO Auto-generated method stub
		if(null != productCategory) {
			session.getCurrentSession().save(productCategory);
			return productCategory.getId();
		}
		
		return 0;
	}

	@Override
	public boolean delete(Category productCategory) {
		// TODO Auto-generated method stub
		return false;
	}


}
