package com.financetracker.authflow;

import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {

	private final String secureKey = "76f8b34168e5caa4c0fd4495168fde6f25cea9173f5bb6ea53f9285e3af8146b";
	private final int expiryInSeconds = 3600;

	public String createToken(String userName) {
		return Jwts.builder().setSubject(userName).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiryInSeconds * 1000))
				.signWith(SignatureAlgorithm.HS256, secureKey).compact();
	}
	
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
		Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secureKey).parseClaimsJws(token).getBody();
	}


	public boolean isValidToken(String token) {
		try {
			Jwts.parser().setSigningKey(secureKey).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
