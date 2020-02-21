package jp.co.htv.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.htv.demo.entity.VehicleRegistrationPlates;

@Repository
public interface VehicleRegistrationPlatesRepository extends JpaRepository<VehicleRegistrationPlates, Long>{
	List<VehicleRegistrationPlates> findAll(Sort sort);
}
