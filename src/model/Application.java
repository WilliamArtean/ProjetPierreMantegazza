package model;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/app")
public class Application {

	private UserDB userDB;
	
	public Application() {
		this.userDB = new UserDB();
		this.userDB.addUser(new User("user1", "user1", Role.ADMINISTRATOR));
		this.userDB.addUser(new User("user2", "user2", Role.NORMAL));
	}
	
	@GET
	@Path("/users")
	@Produces("text/json")
	public List<User> getUsers() {
		return this.userDB.getUsers();
	}
	
}
