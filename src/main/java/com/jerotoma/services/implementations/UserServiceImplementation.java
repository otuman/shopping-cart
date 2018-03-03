package com.jerotoma.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jerotoma.dao.UserDao;
import com.jerotoma.model.User;
import com.jerotoma.services.UserService;

@Service
@Transactional
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserDao userDao;

	public List<User> users() {
		// TODO Auto-generated method stub
		return userDao.users();
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return userDao.delete(user);
	}

	public int save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	public User getCurrentUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getCurrentUser(id);
	}
	
	public User getCurrentUser(String username) {
		// TODO Auto-generated method stub
		return userDao.getCurrentUser(username);
	}

}
