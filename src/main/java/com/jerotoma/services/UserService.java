package com.jerotoma.services;

import java.util.List;

import com.jerotoma.model.User;

public interface UserService {
	public List<User> users();
	public User getCurrentUser(int id);
	public User getCurrentUser(String username);
	public boolean delete(User user);
	public int save(User user);
	public int update(User user);
}
