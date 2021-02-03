package model;

public class RegisteredChallenge {

	private Challenge challenge;
	private User userRegistered;
	
	public RegisteredChallenge(User u, Challenge c) {
		this.challenge = c;
		this.userRegistered = u;
	}
	
	public Challenge getChallenge() {
		return challenge;
	}
	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}
	public User getUserRegistered() {
		return userRegistered;
	}
	public void setUserRegistered(User userRegistered) {
		this.userRegistered = userRegistered;
	}
	
	
	
}
