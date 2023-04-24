package com.exam.service;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UsersRole;
import com.exam.helper.UserNotFoundException;

public interface IUserService {

	public User registerUser(User user) throws Exception;
	public User getUserByName(String name) throws UserNotFoundException;
	public boolean deleteUser(Integer id);
	public boolean updateUser(User user);
}
