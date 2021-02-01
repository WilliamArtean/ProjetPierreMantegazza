package model;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/app")
public class Application {

	private UserDB userDB;
	
	public Application() {
		this.userDB = new UserDB();
	}
	
	@GET
	@Path("/users")
	@Produces("text/json")
	public List<User> getUsers() {
		return this.userDB.getUsers();
	}
	
}
