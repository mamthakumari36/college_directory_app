package org.jsp.cda.service;

import org.jsp.cda.entity.User;
import org.jsp.cda.util.AuthUser;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> login(AuthUser authUser);

	ResponseEntity<?> findUserById(int uid);

	ResponseEntity<?> findAllUser();

	ResponseEntity<?> setUserStatusToActive(int uid);


}
