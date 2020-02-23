package jp.co.htv.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import jp.co.htv.demo.dto.VehicleRegistrationPlateCreateDto;
import jp.co.htv.demo.dto.VehicleRegistrationPlatesDto;
import jp.co.htv.demo.entity.VehicleRegistrationPlates;

/**
 * Vehicle Registration Plates Service
 * @author hainp
 *
 */
public interface VehicleRegistrationPlatesService {
	
	/**
	 * Find object by id
	 * @param id
	 * @return
	 */
	VehicleRegistrationPlates findById(Long id);

	/**
	 * Find all
	 * @param sort Sort
	 * @return
	 */
	List<VehicleRegistrationPlates> findAll(Sort sort);
	
	/**
	 * Find all by province code asc
	 * @return List of VehicleRegistrationPlates
	 */
	List<VehicleRegistrationPlatesDto> findAllByOrderByProvinceCodeAsc();
	
	/**
	 * Find by province code
	 * @param provinceCode Province Code
	 * @return
	 */
	VehicleRegistrationPlates findByProvinceCode(String provinceCode);
	
	/**
	 * Save new plate
	 * @param plateDto
	 */
	void save(VehicleRegistrationPlateCreateDto plateDto);
	
	/**
	 * Delete plate
	 * @param plate
	 */
	void delete(VehicleRegistrationPlates plate);
}
