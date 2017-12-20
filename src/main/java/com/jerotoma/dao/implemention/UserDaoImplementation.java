package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.UserDao;
import com.jerotoma.model.users.User;

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

	public User getCurrentUser(int id) {
		// TODO Auto-generated method stub
		User user = null;
		List<User> users = session.getCurrentSession().createQuery("from User where id='"+id+"'").list();
		if(!users.isEmpty() && users.size() == 1) {
			for(User u : users) {
				user = u;
			}
		}
		return user;
	}
	
	public User getCurrentUser(String username) {
		// TODO Auto-generated method stub
		
		User user = null;
		List<User> users = session.getCurrentSession().createQuery("from User where username='"+username+"'").list();
		if(!users.isEmpty() && users.size() == 1) {
			for(User u : users) {
				user = u;
			}
		}
		return user;	
	}

}
