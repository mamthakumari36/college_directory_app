package org.jsp.cda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@Column(unique = true , nullable = false)
	private String title;
	private String description;
	@ManyToOne
	private Department department;
	@ManyToOne
	private Faculty faculty;

}
