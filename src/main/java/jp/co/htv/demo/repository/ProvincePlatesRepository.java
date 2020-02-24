package jp.co.htv.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.htv.demo.entity.ProvincePlates;

/**
 * Province Plate Repository Class
 * @author hainp
 *
 */
@Repository
public interface ProvincePlatesRepository extends JpaRepository<ProvincePlates, Long>{
	List<ProvincePlates> findByVehicleRegistrationPlatesId(Long id);
	
	@Modifying
	@Query(value = "delete from ProvincePlates p where p.vehicleRegistrationPlates.id = :id ")
	void deleteByVehicleRegistrationPlatesId(@Param("id") Long id);
}
