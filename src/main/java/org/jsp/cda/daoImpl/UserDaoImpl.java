package org.jsp.cda.daoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.User;
import org.jsp.cda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao
{
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user)
	{
		return userRepository.save(user);
	}
	
	public User updateUser(User user)
	{
		return userRepository.save(user);
	}
	
	public List<User> findAllUser()
	{
		return userRepository.findAll();
	}
	
	public Optional<User> findUserById(int id)
	{
		return userRepository.findById(id);
	}
	
	public Optional<User> findByUsernameAndPassword(String username,String password)
	{
		return userRepository.findByUsernameAndPassword(username,password);
	}

}
