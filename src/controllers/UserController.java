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

	public static User getUser(long id) {
		return daoUser.find(id);
	}

	public static User getUserByName(String name) {
		return daoUser.findByName(name);
	}
	
	public static User login(String login, String password) {
		User u = daoUser.findByName(login);
		if (u != null && u.getPassword().equals(password))
			return u;
		return null;
	}

	public static boolean createUser(String name, String password, List<Role> roles) {
		User u = daoUser.find(name);
		if (u == null) {
			daoUser.create(new User(name, password, roles));
			return true;
		}
		return false;
	}
	
	public static boolean removeUser(long id) {
		User u = daoUser.find(id);
		if(u == null) {
			return false;
		}
		daoUser.remove(u);
		return true;
	}
}
