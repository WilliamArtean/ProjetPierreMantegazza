package model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import exceptions.nonExistingUser;

public class UserDB {

	private List<User> users = new ArrayList<User>();
	private int idCpt;
	
	public void addUser(User userToAdd) {
		users.add(userToAdd);
	}
	public void removeUser(User userToRemove) throws nonExistingUser {
		if (users.contains(userToRemove)) {
			users.remove(userToRemove);
		} else {
			throw new nonExistingUser();
		}
	}
	
	@GET
	@Path("")
	@Produces("text/json")
	public List<User> getUsers() {
		return users;
	}
	
}
