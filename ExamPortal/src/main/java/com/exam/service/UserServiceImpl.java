package com.exam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exam.entity.User;
import com.exam.helper.UserNotFoundException;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;

@Component
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User registerUser(User user) throws Exception {
		Optional<User> local = userRepository.findByUserName(user.getUsername());
		User user2=null;
		if (local.isPresent()) {
			System.err.println("username already used!!");
			throw new Exception("User already present!!");
		} else {
			user2 = userRepository.save(user);
		}
		return user2;
	}

	@Override
	public User getUserByName(String name) throws UserNotFoundException {

		return userRepository.findByUserName(name).orElseThrow(()->new UserNotFoundException("User not found in this given Name "+name));
	}

	@Override
	public boolean deleteUser(Integer id) {
        boolean bo=false;
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			bo=true;
		}
		return bo;
	}

	@Override
	public boolean updateUser(User user) {
		boolean bo=false;
		Optional<User> opt = userRepository.findById(user.getId());
		if(opt.isPresent()) {
			userRepository.save(user);
			bo=true;
		}
		return bo;
	}

}
