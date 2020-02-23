package jp.co.htv.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.htv.demo.dto.VehicleRegistrationPlateCreateDto;
import jp.co.htv.demo.dto.VehicleRegistrationPlatesDto;
import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.entity.ProvincePlates;
import jp.co.htv.demo.entity.VehicleRegistrationPlates;
import jp.co.htv.demo.form.plate.PlateForm;
import jp.co.htv.demo.form.plate.PlateListForm;
import jp.co.htv.demo.service.ProvinceService;
import jp.co.htv.demo.service.VehicleRegistrationPlatesService;

/**
 * Vehicle Registration Plate Controller
 * @author hainp
 *
 */
@Controller
public class VehicleRegistrationPlateController {

	/** Vehicle Registration Plates Service */
	@Autowired
	private VehicleRegistrationPlatesService plateService;
	
	/** Province service  */
	@Autowired
	private ProvinceService provinceService;
	
	/**
	 * Search Plates Action
	 * @return
	 */
	@GetMapping("/plate/list")
	public ModelAndView searchPlates() {
		ModelAndView model = new ModelAndView();
		
		PlateListForm form = new PlateListForm();		
		List<VehicleRegistrationPlatesDto> platesDtoList = plateService.findAllByOrderByProvinceCodeAsc();
		form.setPlatesList(platesDtoList);
		model.addObject("platesListForm", form);
		model.setViewName("/plate/list");
		
		return model;
	}
	
	/**
	 * Action for initialize create plate form
	 * @return
	 */
	@GetMapping("/plate/create")
	public ModelAndView showCreateForm() {
		ModelAndView model = new ModelAndView();
		PlateForm plateForm = new PlateForm();
		
		// Get all province list
		List<Province> provinceList = provinceService.findAllByOrderByCodeAsc();
		plateForm.setProvinceList(provinceList);
		model.addObject("plateForm", plateForm);
		model.setViewName("/plate/create");
		return model;
		
	}
	
	/**
	 * Create new province plate
	 * @param plateForm
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/plate/create")
	public ModelAndView createPlate(@Valid @ModelAttribute("plateForm") PlateForm plateForm, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		// validation
		if (bindingResult.hasErrors()) {
			plateForm.setProvinceList(provinceService.findAllByOrderByCodeAsc());
			model.addObject("plateForm", plateForm);
			model.setViewName("/plate/create");
			return model;
		}
		
		// check exist before add new
		VehicleRegistrationPlates plateExists = plateService.findByProvinceCode(plateForm.getProvinceCode());
		if (plateExists != null) {
			bindingResult.rejectValue("provinceCode", "error.province.plate.exist", "Province plates is exist!");
			plateForm.setProvinceList(provinceService.findAllByOrderByCodeAsc());
			model.addObject("plateForm", plateForm);
			model.setViewName("/plate/create");
			return model;
		}
		
		// save object into database
		VehicleRegistrationPlateCreateDto plateDto = new VehicleRegistrationPlateCreateDto();
		plateDto.setProvinceCode(plateForm.getProvinceCode());
		
		// convert form plates to list of provice plates object
		List<ProvincePlates> provincePlatesList = new ArrayList<ProvincePlates>();
		String[] provincePlatesArray = plateForm.getPlates().split("\\r\\n");
		for (String provincePlate : provincePlatesArray) {
			ProvincePlates provincePlateObj = new ProvincePlates();
			provincePlateObj.setValue(provincePlate);
			provincePlatesList.add(provincePlateObj);
		}
		plateDto.setProvincePlatesList(provincePlatesList);
		plateDto.setPublished(plateForm.isPublished());
	
		plateService.save(plateDto);
		
		// go to search screen
		model.setViewName("redirect:/plate/list");
		
		return model;
	}

	@PutMapping("/plate/update/{id}")
	public ModelAndView updatePlate() {
		return null;
	}

	@GetMapping("/plate/delete/{id}")
	public ModelAndView deletePlate(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView();
		VehicleRegistrationPlates plate = plateService.findById(id);
		
		// delete plate
		plateService.delete(plate);
		
//		// go to search screen
//		PlateListForm plateListForm = new PlateListForm();		
//		List<VehicleRegistrationPlatesDto> platesDtoList = plateService.findAllByOrderByProvinceCodeAsc();
//		plateListForm.setPlatesList(platesDtoList);
//		model.addObject("platesListForm", plateListForm);
		model.setViewName("redirect:/plate/list");
		return model;
	}

}
