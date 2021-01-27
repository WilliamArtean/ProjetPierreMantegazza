package model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import exceptions.nonExistingUser;

@Path("/users")
public class UserDB {

	private List<User> users = new ArrayList<User>();
	private int idCpt;
	
	
	public UserDB() {
		addUser(new User("0", "admin", "admin", Role.ADMINISTRATOR));
		addUser(new User("1", "user1", "user1", Role.NORMAL));
		addUser(new User("2", "user2", "user2", Role.NORMAL));
	}
	
	
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
	@GET
	@Path("/user-{id}")
	@Produces("text/json")
	public User getUser(@PathParam("id") String id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	@POST
	@Path("createuser-id={id}&name={name}&password={password}&role={role}")
	public void createUser(@QueryParam("id") String id, @QueryParam("name") String name, @QueryParam("password") String password, @QueryParam("role") String role) {
		Role newUserRole;
		switch (role) {
		case "administrator":
			newUserRole = Role.ADMINISTRATOR;
			break;
		case "normal":
			newUserRole = Role.NORMAL;
			break;
		default:
			newUserRole = Role.NORMAL;
			break;
		}
		addUser(new User(id, name, password, newUserRole));
	}
	
}
