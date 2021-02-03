package paths;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import controllers.ChallengeController;
import controllers.RegisteredChallengeController;
import controllers.UserController;
import model.Challenge;
import model.RegisteredChallenge;
import model.User;
import security.SigninNeeded;

@Path("/user")
public class UserServices {
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") String id, @Context SecurityContext context) {
		try {
			User user = UserController.getUserByName(context.getUserPrincipal().getName());
			if(user == null) {
				return Response.status(Status.NO_CONTENT).build();
			}
			return Response.ok().entity(user).build();
		} catch(NullPointerException e) {
			return Response.status(Status.NO_CONTENT).build();
		}	
	}
	
	@SigninNeeded
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/password")
	public Response changePassword(@Context SecurityContext context, String new_password) {
		try {
			User user = UserController.getUserByName(context.getUserPrincipal().getName());
			if(user == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			user.setPassword(new_password);
			return Response.status(Status.ACCEPTED).build();
		} catch(NullPointerException e) {
			return Response.status(Status.FORBIDDEN).build();
		}
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/name")
	public Response setName(@Context SecurityContext context, String new_username) {
		try {
			User user = UserController.getUserByName(context.getUserPrincipal().getName());
			if(user == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			user.setName(new_username);
			return Response.status(Status.ACCEPTED).build();
		} catch(NullPointerException e) {
			return Response.status(Status.FORBIDDEN).build();
		}
	}
	
	@SigninNeeded
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/challenges")
	public Response getChallenges(@Context SecurityContext context) {
		try {
			User user = UserController.getUserByName(context.getUserPrincipal().getName());
			if(user == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			List<RegisteredChallenge> challenges = RegisteredChallengeController.getChallenges(user);
			return Response.status(Status.ACCEPTED).entity(challenges).build();
		} catch(NullPointerException e) {
			return Response.status(Status.FORBIDDEN).build();
		}
	}
	
	@SigninNeeded
	@POST
	@Path("/challenge/{cname}/signup")
	public Response challengeSignup(@Context SecurityContext context, @PathParam("cname") String challenge_name) {
		try {
			User user = UserController.getUserByName(context.getUserPrincipal().getName());
			if(user == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			Challenge challenge = ChallengeController.getChallenge(challenge_name);
			if(challenge == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			RegisteredChallengeController.createRegisteredChallenge(user, challenge);
			return Response.status(Status.ACCEPTED).build();
		} catch(NullPointerException e) {
			return Response.status(Status.FORBIDDEN).build();
		}
	}
	
	@SigninNeeded
	@POST
	@Path("/signout")
	public Response signout(@Context SecurityContext context) {
		try {
			User user = UserController.getUserByName(context.getUserPrincipal().getName());
			if(user == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}
			UserController.removeUser(user.getId());
			return Response.status(Status.ACCEPTED).build();
		} catch(NullPointerException e) {
			return Response.status(Status.FORBIDDEN).build();
		}
	}
}
