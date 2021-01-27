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
		createUser(id, name, password, newUserRole);
	}
	
}
