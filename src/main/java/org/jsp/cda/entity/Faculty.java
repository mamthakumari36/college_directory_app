package org.jsp.cda.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Faculty
{
	@Id
	private int fid;
	@MapsId
	@OneToOne
	private User user;
	private String photo;
	
	@ManyToOne
	private Department department;
	private LocalTime officeHours;

}
