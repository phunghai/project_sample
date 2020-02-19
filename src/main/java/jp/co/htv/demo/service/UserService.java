package jp.co.htv.demo.service;

import jp.co.htv.demo.entity.User;

/**
 * User Service Interface
 * @author Nguyen Phung Hai
 *
 */
public interface UserService {
	/**
	 * Get user by email
	 * @param email
	 * @return
	 */
	User findUserByEmail(String email);
	
	/**
	 * Save new user
	 * @param user
	 */
	void saveUser(User user);
	
	/**
	 * Get all users
	 * @return
	 */
	Iterable<User> findAll();
	
	/**
	 * Find by id
	 * @param id
	 * @return
	 */
	User findUserById(Long id);
	
	/**
	 * Delete user
	 * @param user User
	 */
	void deleteUser(User user);
}
