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

import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.form.plate.PlateForm;
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
		return null;
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
