package jp.co.htv.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jp.co.htv.demo.dto.user.UserCreateDto;
import jp.co.htv.demo.dto.user.UserUpdateDto;
import jp.co.htv.demo.entity.User;

/**
 * User Service Interface Class.
 * 
 * @author Nguyen Phung Hai
 *
 */
public interface UserService {
    /**
     * Get user by email.
     * 
     * @param email Email
     * @return
     */
    User findUserByEmail(String email);

    /**
     * Save new user.
     * 
     * @param user User
     */
    void saveUser(UserCreateDto user);

    /**
     * Find by id.
     * 
     * @param id user Id
     * @return
     */
    User findUserById(Long id);

    /**
     * Delete user.
     * 
     * @param user User
     */
    void deleteUser(User user);

    /**
     * Update password for user.
     * 
     * @return
     */
    int updateUser(UserUpdateDto userUpdateDto);

    /**
     * Paging user by name.
     * 
     * @param name     user name
     * @param email    email of user
     * @param pageable Pageable
     * @return number of user on one page
     */
    Page<User> findPaginatedByNameOrEmail(String name, String email, Pageable pageable);
}
