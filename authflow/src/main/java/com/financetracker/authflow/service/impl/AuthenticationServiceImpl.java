package com.financetracker.authflow.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financetracker.authflow.exceptions.AuthenticationException;
import com.financetracker.authflow.model.User;
import com.financetracker.authflow.repository.UserRepository;
import com.financetracker.authflow.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	
	public UserRepository userRepository;
	
	
	@Autowired
	public AuthenticationServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}




	@Override
	public boolean authenticate(String userName, String password) {
		//User user = userRepository.findByUserNameAndPassWord(userName, password);
		
		if(Objects.isNull(null)) {
			throw new AuthenticationException("User not found");
		}
		
		return true;
	}

}
