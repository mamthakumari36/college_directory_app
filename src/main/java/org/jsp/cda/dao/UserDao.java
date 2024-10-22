package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.User;

public interface UserDao 
{
	User saveUser(User user);
	
	User updateUser(User user);
	
	List<User> findAllUser();
	
	Optional<User> findUserById(int id);
	
	Optional<User> findByUsernameAndPassword(String username,String password);
}
