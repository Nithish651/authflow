package com.financetracker.authflow;

import com.financetracker.authflow.model.UserDetails;

public interface AuthenticationProvider {
	
	UserDetails getUserDetails(String token);
	boolean validateToken(String token);

}
