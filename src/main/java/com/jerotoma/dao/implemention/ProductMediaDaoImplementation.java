package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.ProductMediaDao;
import com.jerotoma.model.ProductMedia;

@Repository
@Transactional
public class ProductMediaDaoImplementation implements ProductMediaDao {

	@Autowired
	SessionFactory session;
	
	
	public ProductMedia getProductMedia(int id) {
		// TODO Auto-generated method stub
	    ProductMedia productMedia = null;
		@SuppressWarnings("unchecked")
		List<ProductMedia> productMediaList = session.getCurrentSession().createQuery("from ProductMedia where id='"+id+"'").list();
		if(!productMediaList.isEmpty() && productMediaList.size() == 1) {
			for(ProductMedia p : productMediaList) {
				productMedia = p;
			}
		}
		return productMedia;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductMedia> getProductMediaList(int product_id) {
		return session.getCurrentSession().createQuery("from ProductMedia where product_id='"+product_id+"'").list();
	}

	@SuppressWarnings("unchecked")
	public List<ProductMedia> getProductMediaList() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from ProductMedia").list();
	}

	public ProductMedia update(ProductMedia productMedia) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(productMedia);
		return getProductMedia(productMedia.getId());
	}

	public int save(ProductMedia productMedia) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(productMedia);
		return productMedia.getId();
	}

	public boolean delete(ProductMedia productMedia) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(productMedia);
		return true;
	}

}
