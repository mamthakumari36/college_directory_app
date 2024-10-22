package org.jsp.cda.controller;

import org.jsp.cda.entity.User;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(value = "*")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthUser authUser)
	{
		return userService.login(authUser);
	}
	
	@GetMapping(value = "/{uid}")
	public ResponseEntity<?> findUserById(@PathVariable int uid)
	{
		return userService.findUserById(uid);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUser()
	{
		return userService.findAllUser();
	}
	
	@PatchMapping(value = "/{uid}")
	public ResponseEntity<?> setUserStatusToActive(@PathVariable int uid)
	{
		return userService.setUserStatusToActive(uid);
	}
	

}
