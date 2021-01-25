package model;

import java.util.List;

import exceptions.nonExistingUser;

public class UserDB {

	private List<User> users;
	private static int idCpt;
	
	public void addUser(User userToAdd) {
		this.users.add(userToAdd);
	}
	public void removeUser(User userToRemove) throws nonExistingUser {
		if (this.users.contains(userToRemove)) {
			this.users.remove(userToRemove);
		} else {
			throw new nonExistingUser();
		}
	}
	
}
