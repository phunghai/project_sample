package jp.co.htv.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.htv.demo.entity.Authority;

/**
 * Authority Repository Class.
 * @author hainp
 *
 */
@Repository
public interface AuthorityResository extends JpaRepository<Authority, Long> {
    Authority findByAuthority(String authority);
}
