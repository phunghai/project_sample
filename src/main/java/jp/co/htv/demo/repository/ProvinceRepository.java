package jp.co.htv.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.htv.demo.entity.Province;

/**
 * Province Repository Class.
 * 
 * @author hainp
 *
 */
@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {
    List<Province> findAll(Sort sort);

    /**
     * Find all province by order by code asc
     * 
     * @return
     */
    List<Province> findAllByOrderByCodeAsc();
}
