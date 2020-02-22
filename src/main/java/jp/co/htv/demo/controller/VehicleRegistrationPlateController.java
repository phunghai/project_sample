package jp.co.htv.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.htv.demo.dto.VehicleRegistrationPlatesDto;
import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.entity.ProvincePlates;
import jp.co.htv.demo.form.plate.PlateForm;
import jp.co.htv.demo.form.plate.PlateListForm;
import jp.co.htv.demo.service.VehicleRegistrationPlatesService;

/**
 * Vehicle Registration Plate Controller
 * @author hainp
 *
 */
@Controller
public class VehicleRegistrationPlateController {

	@Autowired
	private VehicleRegistrationPlatesService plateService;
	
	@RequestMapping("/plate/list")
	public ModelAndView searchPlates() {
		ModelAndView model = new ModelAndView();
		
		PlateListForm form = new PlateListForm();
		// get vehicle registration plates list
		List<VehicleRegistrationPlatesDto> platesList = new ArrayList<VehicleRegistrationPlatesDto>();
		VehicleRegistrationPlatesDto plate = new VehicleRegistrationPlatesDto();
		plate.setId(Long.valueOf(1));
		
		Province province = new Province();
		province.setCode("01");
		province.setName("Province Name");
		plate.setProvince(province);
		
		// province plate
		List<ProvincePlates> provincePlateList = new ArrayList<ProvincePlates>();
		ProvincePlates provincePlate = new ProvincePlates();
		provincePlate.setValue("29");
		provincePlateList.add(provincePlate);
		
		provincePlate = new ProvincePlates();
		provincePlate.setValue("30");
		provincePlateList.add(provincePlate);
		
		plate.setProvincePlatesList(provincePlateList);
		
		
		plate.setPublished(true);
		
		platesList.add(plate);
		
		form.setPlatesList(platesList);
		model.addObject("platesListForm", form);
		model.setViewName("/plate/list");
		
		return model;
	}
	
	/**
	 * Action for initialize create plate form
	 * @return
	 */
	@RequestMapping("/plate/create")
	public ModelAndView showCreateForm() {
		ModelAndView model = new ModelAndView();
		PlateForm plateForm = new PlateForm();
		
		List<Province> provinceList = new ArrayList<Province>();
		Province province = new Province();
		province.setCode("01");
		province.setName("name 01");
		provinceList.add(province);
		
		province = new Province();
		province.setCode("02");
		province.setName("name 02");
		provinceList.add(province);
		
		plateForm.setPublished(true);
		plateForm.setProvinceCode("02");
		plateForm.setProvinceList(provinceList);
		model.addObject("plateForm", plateForm);
		model.setViewName("/plate/create");
		return model;
		
	}
	

	@PostMapping("/plate/create")
	public ModelAndView createPlate() {
		return null;
	}

	@PutMapping("/plate/update/{id}")
	public ModelAndView updatePlate() {
		return null;
	}

	@DeleteMapping("/plate/delete/{id}")
	public ModelAndView deletePlate() {
		return null;
	}

}
