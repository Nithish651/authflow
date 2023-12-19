package com.financetracker.authflow;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.financetracker.authflow.model.UserDetails;
import com.financetracker.authflow.service.AuthenticationService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtAuthenticationProvider implements AuthenticationProvider {

	private final String secureKey = "76f8b34168e5caa4c0fd4495168fde6f25cea9173f5bb6ea53f9285e3af8146b";
	private final int expiryInSeconds = 3600;
	private AuthenticationService authService;

	@Autowired
	public JwtAuthenticationProvider(AuthenticationService authService) {
		super();
		this.authService = authService;
	}


	private String createToken(String userName) {
		return Jwts.builder().setSubject(userName).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiryInSeconds * 1000))
				.signWith(SignatureAlgorithm.HS256, secureKey).compact();
	}

	@Override
	public UserDetails getUserDetails(String token) {
		Claims claims = Jwts.parser().setSigningKey(secureKey).parseClaimsJws(token).getBody();
		UserDetails user = new UserDetails();
		user.setUserName(claims.getSubject());
		return user;
	}

	@Override
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secureKey).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
