package chapter20.Library2.repository;

import java.util.ArrayList;
import java.util.List;

import chapter20.Library2.model.User;

public class UserRepository {
	private List<User> users = new ArrayList<User>();

	public void addUser(User user) {
		users.add(user);
	}

	public User findUserById(String userId) {
		for(User user: users) {
			if(user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}

	public List<User> findAllUsers() {
		return users;
	}

}
