package jp.co.htv.demo.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import jp.co.htv.demo.dto.VehicleRegistrationPlateCreateDto;
import jp.co.htv.demo.dto.VehicleRegistrationPlateDto;
import jp.co.htv.demo.dto.VehicleRegistrationPlateUpdateDto;
import jp.co.htv.demo.entity.VehicleRegistrationPlates;

/**
 * Vehicle Registration Plates Service Class.
 * 
 * @author hainp
 *
 */
public interface VehicleRegistrationPlatesService {

    /**
     * Find object by id.
     * 
     * @param id plate id.
     * @return
     */
    VehicleRegistrationPlates findById(Long id);

    /**
     * Find all.
     * 
     * @param sort Sort
     * @return
     */
    List<VehicleRegistrationPlates> findAll(Sort sort);

    /**
     * Find all by province code asc.
     * 
     * @param provinceName Province Name
     * @param isLogged user login or not
     * @return List of VehicleRegistrationPlates
     */
    List<VehicleRegistrationPlateDto> findAll(String provinceName, boolean isLogged);

    /**
     * Find by province code.
     * 
     * @param provinceCode Province Code
     * @return
     */
    VehicleRegistrationPlates findByProvinceCode(String provinceCode);

    /**
     * Save new plate.
     * 
     * @param plateDto plate dto.
     */
    void save(VehicleRegistrationPlateCreateDto plateDto);

    /**
     * Delete plate.
     * 
     * @param plate vehicle registration plate.
     */
    void delete(VehicleRegistrationPlates plate);

    /**
     * Get plate information for update.
     * 
     * @param id province plate id
     * @return
     */
    VehicleRegistrationPlateUpdateDto getUpdateInfo(Long id);

    /**
     * Update plate.
     * 
     * @param plateUpdateDto plate update dto.
     */
    void update(VehicleRegistrationPlateUpdateDto plateUpdateDto);
}
