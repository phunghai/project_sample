package jp.co.htv.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	
	/**
	 * Update user info
	 * @param id user id
	 * @param name user name
	 * @return
	 */
	int updateUser(Long id, String name);
	
	/**
	 * Paging user by name
	 * @param name user name
	 * @param pageable Pageable
	 * @return number of user on one page
	 */
	Page<User> findPaginatedByName(String name, Pageable pageable);
}
