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
	UserDao useDao;

	public List<User> users() {
		// TODO Auto-generated method stub
		return useDao.users();
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return useDao.delete(user);
	}

	public boolean save(User user) {
		// TODO Auto-generated method stub
		return useDao.save(user);
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		return useDao.update(user);
	}

	public User getCurrentUser(int id) {
		// TODO Auto-generated method stub
		return useDao.getCurrentUser(id);
	}

}
