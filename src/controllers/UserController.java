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

	public static User getUser(String id) {
		if (id == null)
			return null;

		User u = daoUser.find(id);
		return u;
	}

	public static User login(String id, String password) {
		User u = daoUser.find(id);
		if (u != null && u.getPassword().equals(password))
			return u;
		return null;
	}

	public static boolean createUser(String id, String name, String password, Role role) {
		User u = daoUser.find(name);
		if (u == null) {
			daoUser.create(new User(id, name, password, role));
			return true;
		}
		return false;
	}
}
