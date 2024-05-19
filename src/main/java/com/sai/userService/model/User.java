package com.sai.userService.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;



@Entity
@Table(name="micro_user")
@Data
public class User{
	@Id
	@Column(name = "id")
	private String userId;
	@Column(name = "username")
	private String name;
	private String email;
	private String about;
	@Transient
	private List<Rating> ratings;
}
