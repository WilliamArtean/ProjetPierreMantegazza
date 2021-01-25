package model;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table
public class User {

	@JsonProperty
	private String name;
	@JsonProperty
	private String password;
	@JsonProperty
	private Role role;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public User() {
		this("default", "default", Role.NORMAL);
	}
	
	public User(String name, String password, Role role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
}
