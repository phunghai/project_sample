package jp.co.htv.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.htv.demo.entity.User;

/**
 * User Repository Class.
 * 
 * @author hainp
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    /**
     * Using jsql for update user info
     * 
     * @param id   user id
     * @param name user name
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "update User u set u.name = :name where u.id = :user_id ")
    int updateUserName(@Param("user_id") Long id, @Param("name") String name);

    /**
     * Paging with search name
     * 
     * @param name     user name
     * @param email    email of user
     * @param pageable Page object
     * @return List of User
     */
    Page<User> findAllByNameContainingOrEmailContaining(String name, String email, Pageable pageable);
}
