package com.sg.leoublog.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sg.leoublog.domain.RoleType;
import com.sg.leoublog.domain.User;
import com.sg.leoublog.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertUser(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	public User getUser(String username) {
		
		User findUser = userRepository.findByUsername(username).orElseGet(
				new Supplier<User>() {
					public User get() {
						return new User();
					}
				}
				)
				;
		return findUser;
	}

}
