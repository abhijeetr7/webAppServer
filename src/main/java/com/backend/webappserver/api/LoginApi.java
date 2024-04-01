package com.backend.webappserver.api;

import org.springframework.security.authentication.AuthenticationManager;

import ch.qos.logback.classic.Logger;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.webappserver.config.JwtTokenProvider;
import com.backend.webappserver.config.UserPrincipal;
import com.backend.webappserver.payload.LoginRequest;
import com.backend.webappserver.payload.employeeMasterModel;
import com.backend.webappserver.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class LoginApi {

//	private static final Logger logger = LoggerFactory.getLogger(LoginApi.class);

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@PostMapping("/signin")
	public UserPrincipal authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		UserPrincipal userPrincipal = userService.validateUser(loginRequest);
		if (userPrincipal != null && userPrincipal.getId() != null) {
			String jwt = tokenProvider.generateToken(userPrincipal);
			userPrincipal.setToken(jwt);
			return userPrincipal;
		} else {
			return userPrincipal;
		}
	}
	
	@PostMapping("/changePassword")
	public UserPrincipal changePassword(@RequestBody employeeMasterModel model) {
		return userService.changePassword(model);
	}

	
	
	
	
//	@PostMapping("/changePassword")
//	public UserPrincipal authenticateChangepassword(@Valid @RequestBody LoginRequest loginRequest) {
//		UserPrincipal userPrincipal = userService.validateChangepassword(loginRequest);
////		if (userPrincipal != null && userPrincipal.getId() != null) {
//////			String jwt = tokenProvider.generateToken(userPrincipal);
//////			userPrincipal.setToken(jwt);
////			
////		} 
//		return userPrincipal;
//	}
}
