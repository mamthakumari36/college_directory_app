package org.jsp.cda.entity;

import org.jsp.cda.util.UserRole;
import org.jsp.cda.util.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	@Column(unique = true,nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole role;
//	@Column(nullable = false)
	private String name;
//	@Column(nullable = false)
	private String email;
//	@Column(unique = true.nullable = false)
	private long phone;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	

}
