package paths;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;


import controllers.UserController;
import jakarta.ws.rs.core.MediaType;
import model.Role;
import model.User;
import security.JWTokenUtility;
import security.SigninNeeded;

@Path("/")
public class Authentification {
	
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
	
	@POST
	@Path("/signin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signin(@QueryParam("login") String login, @QueryParam("password") String password) {
		User u = UserController.login(login, password);

		if (u != null)
			return Response.ok().entity(JWTokenUtility.buildJWT(String.valueOf(u.getId()))).build();

		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
	@POST
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signup(@QueryParam("login") String login, @QueryParam("password") String password,
			@QueryParam("name") String name, @QueryParam("lastname") String lastname) {
		List<Role> role = new ArrayList<Role>();
		role.add(Role.NORMAL);
		if (UserController.createUser(name, password, role))
			return Response.status(Status.CREATED).build();
		return Response.status(Status.CONFLICT).build();

	}

	/**
	 * Méthode permettant de récupérer l'ensemble des roles d'un utilisateur
	 * 
	 * @param user l'utilisateur
	 * @return une liste de tous les roles associés à l'utilisateur user
	 */
	public static List<Role> findUserRoles(String user) {
		return UserController.getUserByName(user).getRoles();
	}
}
