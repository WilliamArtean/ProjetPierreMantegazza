package model;

public class User {

	private String name;
	private String password;
	private Role role;
	private int points;
	
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
		this.points = 0;
	}
	
}
