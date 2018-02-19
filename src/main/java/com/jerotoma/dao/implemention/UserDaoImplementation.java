package com.jerotoma.dao.implemention;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.UserDao;
import com.jerotoma.model.User;

@Repository
@Transactional
public class UserDaoImplementation implements UserDao{
	
	@Autowired
	SessionFactory session;
	@SuppressWarnings("unchecked")
	public List<User> users() {
		List<User> users  = (List<User>)session.getCurrentSession().createQuery("from User").list();
		
		
		return users;
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

	public int save(User user) {
		// TODO Auto-generated method stub
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//PasswordEncoderFactories.createDelegatingPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		session.getCurrentSession().save(user);
		return user.getId();
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(user);
		return user.getId();
	}

	public User getCurrentUser(int id) {
		// TODO Auto-generated method stub
		User user = null;
		@SuppressWarnings("unchecked")
		List<User> users = session.getCurrentSession().createQuery("from User where id='"+id+"'").list();
		if(!users.isEmpty() && users.size() == 1) {
			for(User u : users) {
				user = u;
			}
		}
		return user;
	}
	@SuppressWarnings("unchecked")
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
