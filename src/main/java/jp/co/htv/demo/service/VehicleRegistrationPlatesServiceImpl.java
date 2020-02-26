package jp.co.htv.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.htv.demo.dto.VehicleRegistrationPlateCreateDto;
import jp.co.htv.demo.dto.VehicleRegistrationPlateUpdateDto;
import jp.co.htv.demo.dto.VehicleRegistrationPlateDto;
import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.entity.ProvincePlates;
import jp.co.htv.demo.entity.VehicleRegistrationPlates;
import jp.co.htv.demo.repository.ProvincePlatesRepository;
import jp.co.htv.demo.repository.ProvinceRepository;
import jp.co.htv.demo.repository.VehicleRegistrationPlatesRepository;

/**
 * Vehicle Registration Plates Service Class
 * 
 * @author hainp
 *
 */
@Service
public class VehicleRegistrationPlatesServiceImpl implements VehicleRegistrationPlatesService {

    /** Vehicle Registration Plates Repository property */
    @Autowired
    private VehicleRegistrationPlatesRepository vehicleRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private ProvincePlatesRepository provincePlateRepository;

    @Override
    public List<VehicleRegistrationPlates> findAll(Sort sort) {
        return vehicleRepository.findAll(sort);
    }

    @Override
    public List<VehicleRegistrationPlateDto> findAll(String provinceName, boolean isLogged) {
        // returning list
        List<VehicleRegistrationPlateDto> plateDtoList = new ArrayList<VehicleRegistrationPlateDto>();
        
        // get vehicle registration plates list from database and filter by province name.
        List<Object[]> rawDataList = new ArrayList<Object[]>();
        if (isLogged) {
            rawDataList = vehicleRepository.findAllByProvinceName(provinceName);
        } else {
            rawDataList = vehicleRepository.findAllByProvinceNameAndUnPublished(provinceName);
        }
        
        
        for (Object[] rawData : rawDataList) {
            VehicleRegistrationPlateDto plateDto = new VehicleRegistrationPlateDto();
            VehicleRegistrationPlates plate = (VehicleRegistrationPlates)rawData[0];
            Province province = (Province)rawData[1];
            
            List<ProvincePlates> provinceList = plate.getProvincePlates();
            plateDto.setId(plate.getId());
            plateDto.setProvince(province);
            plateDto.setProvincePlatesList(provinceList);
            plateDto.setPublished(plate.getPublished());

            plateDtoList.add(plateDto);
            
        }

        return plateDtoList;
    }

    @Override
    public VehicleRegistrationPlates findByProvinceCode(String provinceCode) {
        return vehicleRepository.findByProvinceCode(provinceCode);
    }

    @Transactional
    @Override
    public void save(VehicleRegistrationPlateCreateDto plateDto) {
        VehicleRegistrationPlates plate = new VehicleRegistrationPlates();

        plate.setProvinceCode(plateDto.getProvinceCode());
        plate.setPublished(plateDto.isPublished());

        for (ProvincePlates provincePlate : plateDto.getProvincePlatesList()) {

            ProvincePlates newProvincePlate = new ProvincePlates();
            newProvincePlate.setValue(provincePlate.getValue());
            newProvincePlate.setVehicleRegistrationPlates(plate);
            newProvincePlate.setCreatedAt(LocalDateTime.now());
            newProvincePlate.setUpdatedAt(LocalDateTime.now());
            plate.getProvincePlates().add(newProvincePlate);
        }

        plate.setCreatedAt(LocalDateTime.now());
        plate.setUpdatedAt(LocalDateTime.now());

        // save object into database
        vehicleRepository.save(plate);

    }

    @Override
    public VehicleRegistrationPlates findById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(VehicleRegistrationPlates plate) {
        vehicleRepository.delete(plate);
    }

    @Override
    public VehicleRegistrationPlateUpdateDto getUpdateInfo(Long id) {
        VehicleRegistrationPlateUpdateDto plateDto = new VehicleRegistrationPlateUpdateDto();
        VehicleRegistrationPlates plate = vehicleRepository.findById(id).orElse(null);

        // if plate is not exists
        if (plate == null) {
            return null;
        }

        Province province = provinceRepository.findById(plate.getProvinceCode()).orElse(new Province());

        // mapping data to return dto
        plateDto.setId(plate.getId());
        plateDto.setProvinceCode(province.getCode());
        plateDto.setProvinceName(province.getName());
        plateDto.setPublished(plate.getPublished());
        plateDto.setProvincePlatesList(plate.getProvincePlates());

        return plateDto;
    }

    @Transactional
    @Override
    public void update(VehicleRegistrationPlateUpdateDto plateUpdateDto) {
        // update published value
        vehicleRepository.updatePlate(plateUpdateDto.getId(), plateUpdateDto.isPublished());

        // delete province plate
        provincePlateRepository.deleteByVehicleRegistrationPlatesId(plateUpdateDto.getId());

        provincePlateRepository.saveAll(plateUpdateDto.getProvincePlatesList());
    }

}
