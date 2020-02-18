package jp.co.htv.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.htv.demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public Optional<User> findByEmail(String email);
}
