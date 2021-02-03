package model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Response.Status;

import controllers.UserController;
import exceptions.nonExistingUser;
import jakarta.ws.rs.core.MediaType;
import security.SigninNeeded;

@Path("/users")
public class UserDB {

	@GET
	@SigninNeeded
	@Path("/whoami")
	@Produces(MediaType.APPLICATION_JSON)
	public Response whoami(@Context SecurityContext security) {
		try {
			System.err.println(">> whoami");
			User user = UserController.getUserByName(security.getUserPrincipal().getName());
			return Response.ok().entity(user).build();
		} catch (NullPointerException e) {
			return Response.status(Status.NO_CONTENT).build();
		}
	}
	
	private List<User> users = new ArrayList<User>();
	private int idCpt;
	
	
	public UserDB() {
		List<Role> admin = new ArrayList<Role>();
		List<Role> normal = new ArrayList<Role>();
		admin.add(Role.ADMINISTRATOR);
		normal.add(Role.NORMAL);
		addUser(new User("admin", "admin", admin));
		addUser(new User("user1", "user1", normal));
		addUser(new User("user2", "user2", normal));
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
	public User getUser(@PathParam("id") long id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	@PUT
	@Path("/createuser")
	public User createUser(@QueryParam("name") String name, @QueryParam("password") String password, @QueryParam("role") String role) {
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
		List<Role> roles = new ArrayList<Role>();
		roles.add(newUserRole);
		User newUser = new User(name, password, roles);
		addUser(newUser);
		return newUser;
	}
	
}
