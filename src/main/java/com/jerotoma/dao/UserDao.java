package com.jerotoma.dao;

import java.util.List;

import com.jerotoma.model.User;

public interface UserDao {
	
	public List<User> users();
	public User getCurrentUser(int id);
	public boolean delete(User user);
	public boolean save(User user);
	public boolean update(User user);

}
