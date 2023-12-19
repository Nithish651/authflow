package com.financetracker.authflow.service;

public interface AuthenticationService {
	boolean authenticate(String userName, String password);
}
