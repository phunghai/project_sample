package jp.co.htv.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.htv.demo.entity.VehicleRegistrationPlates;

/**
 * Vehicle Registration Plates Repository Class
 * @author hainp
 *
 */
@Repository
public interface VehicleRegistrationPlatesRepository extends JpaRepository<VehicleRegistrationPlates, Long>{
	/**
	 * Find all with sort
	 */
	List<VehicleRegistrationPlates> findAll(Sort sort);
	
	/**
	 * Order by province Code
	 * @return
	 */
	List<VehicleRegistrationPlates> findAllByOrderByProvinceCodeAsc();
	
	/**
	 * Find by Province Code
	 * @param provinceCode Province Code
	 * @return
	 */
	VehicleRegistrationPlates findByProvinceCode(String provinceCode);
	
	@Transactional
	@Modifying
	@Query(value = "update VehicleRegistrationPlates v set v.published = :published where v.id = :id ")
	int updatePlate(@Param("id") Long id, @Param("published") boolean published);
}
