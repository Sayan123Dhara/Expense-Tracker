package com.spring.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.auth.User;
import com.spring.config.UserInfoUserDetails;
import com.spring.project.service.UserService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getAllUser(@AuthenticationPrincipal UserInfoUserDetails userDetails){
		List<User> allUsers = null;
		boolean isAdmin = userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("OWNER"));
		if (userDetails!=null && isAdmin) {
			allUsers=userService.getAllTheUsers();
		}
		if (allUsers!=null) {
			return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
		}else {
			return new ResponseEntity<List<User>>(allUsers,HttpStatus.NOT_FOUND);
		}
	}
}
