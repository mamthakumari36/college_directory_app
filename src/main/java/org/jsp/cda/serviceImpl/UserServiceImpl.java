package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.InvalidCredentialsException;
import org.jsp.cda.exceptionclasses.NoUserFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthUser;
import org.jsp.cda.util.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<?> saveUser(User user) {
		user.setStatus(UserStatus.IN_ACTIVE);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body(userDao.saveUser(user)).message("User Saved Successfully").build());
	}

	@Override
	public ResponseEntity<?> login(AuthUser authUser) {

		Optional<User> optional = userDao.findByUsernameAndPassword(authUser.getUsername(), authUser.getPassword());
		if (optional.isEmpty())
			throw InvalidCredentialsException.builder().message("Invalid Username or Password...").build();

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Verified Successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if(optional.isEmpty())
			throw NoUserFoundException.builder().message("Invalid Id..").build();
		User user = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Found Successfully...").body(user).build());
	}

	@Override
	public ResponseEntity<?> findAllUser() {
		List<User> users = userDao.findAllUser();
		if(users.isEmpty())
			throw NoUserFoundException.builder().message("No Users Found...").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Users Found Successfully...").body(users).build());
	}

	@Override
	public ResponseEntity<?> setUserStatusToActive(int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if(optional.isEmpty())
			throw NoUserFoundException.builder().message("Invalid Id..").build();
		
		User user = optional.get();
		user.setStatus(UserStatus.ACTIVE);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Users Status Set To ACTIVE Successfully...").body(userDao.saveUser(user)).build());
	}


}
