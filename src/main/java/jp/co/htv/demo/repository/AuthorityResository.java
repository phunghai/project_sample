package jp.co.htv.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.htv.demo.entity.Authority;

@Repository
public interface AuthorityResository extends CrudRepository<Authority, Long> {
    Authority findByAuthority(String authority);
}
