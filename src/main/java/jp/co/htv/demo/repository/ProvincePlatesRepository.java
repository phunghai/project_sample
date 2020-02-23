package jp.co.htv.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.htv.demo.entity.ProvincePlates;

@Repository
public interface ProvincePlatesRepository extends JpaRepository<ProvincePlates, Long>{
	List<ProvincePlates> findByVehicleRegistrationPlatesId(Long id);
}
