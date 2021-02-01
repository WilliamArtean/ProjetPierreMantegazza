package controllers;

import java.util.List;

import dao.DAOUser;
import model.Role;
import model.User;

public class UserController {
	
	static DAOUser daoUser = new DAOUser();

	public static List<User> getUsers() {
		List<User> lv = daoUser.findAll();
		return lv;
	}

	public static User getUser(String name) {
		if (name == null)
			return null;

		User u = daoUser.find(name);
		return u;
	}

	public static User login(String name, String password) {
		User u = daoUser.find(name);
		if (u != null && u.getPassword().equals(password))
			return u;
		return null;
	}

	public static boolean createUser(String name, String password, Role role) {
		User u = daoUser.find(name);
		if (u == null) {
			daoUser.create(new User(name, password, role));
			return true;
		}
		return false;
	}
}
