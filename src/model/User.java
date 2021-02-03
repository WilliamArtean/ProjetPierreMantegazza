package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.Path;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;

	@Column(unique=true)
	private String name;

	private String password;
	
	private List<Role> roles;
	
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public User() {
		this("default", "default", new ArrayList<Role>());
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.NORMAL);
		this.setRoles(roles);
	}
	
	public User(String name, String password, List<Role> roles) {
		this.id = 0;
		this.name = name;
		this.password = password;
		this.roles = roles;
	}
	
}
