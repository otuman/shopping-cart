package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.MediaDao;
import com.jerotoma.model.Media;

@Repository
@Transactional
public class MediaDaoImplementation implements MediaDao {
     
	@Autowired
	SessionFactory session;
	
	@SuppressWarnings("unchecked")
	public List<Media> media() {
		// TODO Auto-generated method stub
		
		return session.getCurrentSession().createQuery("from Media").list();
	}

	public Media getMedia(int id) {
		
		return (Media)session.getCurrentSession().get(Media.class, id);
	}

	public boolean delete(Media media) {
		// TODO Auto-generated method stub
		if(null != media) {
			session.getCurrentSession().delete(media);
			return true;
		}
		
		return false;
	}

	public int save(Media media) {
		
		if(null != media) {
			session.getCurrentSession().save(media);
			return media.getId();
		}
		return 0;
	}

	public int update(Media media) {
		
		if(null != media) {
			session.getCurrentSession().update(media);
			return media.getId();
		}
		return 0;
	}

}
