package org.elsys.ip.servlet.service;

import java.util.ArrayList;
import java.util.List;

import org.elsys.ip.servlet.model.User;

public class UserService {
	private static List<User> users = new ArrayList<>();

	public UserService() {
		if (users.size() == 0) {
			users.add(new User(1, "admin", "admin@admin.bg"));
			users.add(new User(2, "user", "user@user.bg"));
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public User getByName(String name) {
		System.out.println(name);
		if (name != null) {
			return users.stream().filter(u -> name.equals(u.getName())).findFirst().orElse(null);
		} else {
			return null;
		}
	}

	public void addUser(User user) {
		if (user != null) {
			users.add(user);
		} else {
			System.out.println("Error: null pointer");
		}
	}
	public void updateUser(User oldUser, User newUser) {
		if (users.contains(oldUser) && oldUser != null && newUser != null) {
			deleteUser(oldUser);
			addUser(newUser);
		} else {
			System.out.printf("Error: user dont exists or null pointer");
		}
	}

	public void deleteUser(User user) {
		if (users.contains(user) && user != null) {
			users.remove(user);
		} else {
			System.out.printf("Error: user dont exists");
		}
	}
}
