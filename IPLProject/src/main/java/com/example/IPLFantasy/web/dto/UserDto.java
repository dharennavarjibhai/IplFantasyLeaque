package com.example.IPLFantasy.web.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String firstName;

	private String lastName;

	private String teamName;

	private String password;

	private String email;

	private String role;
	
	private Integer points;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(final String teamName) {
		this.teamName = teamName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public UserDto(String firstName, String lastName, String teamName, String password, String email, Integer points) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.teamName = teamName;
		this.password = password;
		this.email = email;
		this.points = points;
	}

	public UserDto() {
	}

}