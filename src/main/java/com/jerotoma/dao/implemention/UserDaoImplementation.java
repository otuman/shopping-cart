package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.UserDao;
import com.jerotoma.model.User;

@Repository
@Transactional
public class UserDaoImplementation implements UserDao{
	
	@Autowired
	SessionFactory session;

	public List<User> users() {
		return session.getCurrentSession().createQuery("from User").list();
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		
		try {
			session.getCurrentSession().delete(user);
			
		}catch(Exception ex){
			return false;
		}
		return true;
	}

	public boolean save(User user) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().save(user);
		return true;
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(user);
		return true;
	}

}
