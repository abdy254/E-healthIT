package app.service;

import java.util.List;

import app.domain.User;
import app.exception.UserBlockedException;

public interface UserService {
	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCKED=2;
	
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	
	/**
	 * User registration logic
	 * @param u
	 */
	public void register(User u);
	/**
	 * Handle login operation(authentication) using given credentials
	 * when user account is blocked an exception is thrown
	 * @param loginName
	 * @param password
	 * @return
	 */
	public User login(String loginName, String password) throws UserBlockedException;
	public List<User> getUserList();
	/**
	 * Change user login status for details passed as arg
	 * @param userId
	 * @param loginStatus
	 */
	public void changeLoginStatus(Integer userId, int loginStatus);
	
}
