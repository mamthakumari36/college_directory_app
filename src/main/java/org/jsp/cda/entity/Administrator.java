package org.jsp.cda.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Administrator
{
	@Id
	private int id;
	@MapsId
	@OneToOne
	private User user;
	private String photo;
	@ManyToOne
	private Department department;

}
