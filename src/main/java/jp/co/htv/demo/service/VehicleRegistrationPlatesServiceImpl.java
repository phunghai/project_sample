package jp.co.htv.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.htv.demo.entity.VehicleRegistrationPlates;
import jp.co.htv.demo.repository.VehicleRegistrationPlatesRepository;

/**
 * Vehicle Registration Plates Service
 * @author hainp
 *
 */
@Service
public class VehicleRegistrationPlatesServiceImpl implements VehicleRegistrationPlatesService {

	@Autowired
	private VehicleRegistrationPlatesRepository vehicleRepository;

	@Override
	public List<VehicleRegistrationPlates> findAll() {
		return vehicleRepository.findAll();
	}

}
