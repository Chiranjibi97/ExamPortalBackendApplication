package com.exam.runner;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.exam.entity.Roles;
import com.exam.entity.User;
import com.exam.entity.UsersRole;
import com.exam.service.IUserService;
//@Component
public class ExamRunner implements CommandLineRunner {

	@Autowired
	private IUserService service;
	@Override
	public void run(String... args) throws Exception {
		/*	User user = new User();
			user.setFirstName("chiranjibi");
			user.setLastName("Dash");
			user.setUserName("chiranjibi1997");
			user.setPhone(7008472938l);
			user.setPassword("butu");
			
			
			Set<UsersRole> userRole = new HashSet<>();
			
			Roles role = new Roles();
			role.setRollId(11);
			role.setRoll_name("admin");
			role.setUserRoles(userRole);
			UsersRole ur1 = new UsersRole();
			ur1.setUser(user);
			ur1.setRole(role);
			
			userRole.add(ur1);
			user.setUserRole(userRole);
			
			User user1 = service.registerUser(user);
		System.out.println(user1.getUserName());*/
		
		User user = service.getUserByName("sarita2001");
		System.out.println(user);
	}

}
