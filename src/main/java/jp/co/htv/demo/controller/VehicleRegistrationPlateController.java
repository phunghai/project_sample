package jp.co.htv.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jp.co.htv.demo.dto.VehicleRegistrationPlateCreateDto;
import jp.co.htv.demo.dto.VehicleRegistrationPlateDto;
import jp.co.htv.demo.dto.VehicleRegistrationPlateUpdateDto;
import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.entity.ProvincePlates;
import jp.co.htv.demo.entity.VehicleRegistrationPlates;
import jp.co.htv.demo.form.plate.PlateForm;
import jp.co.htv.demo.form.plate.PlateSearchForm;
import jp.co.htv.demo.form.plate.PlateUpdateForm;
import jp.co.htv.demo.service.ProvinceService;
import jp.co.htv.demo.service.VehicleRegistrationPlatesService;
import jp.co.htv.demo.utils.AuthenticationUtils;
import jp.co.htv.demo.utils.Constants;

/**
 * Vehicle Registration Plate Controller.
 * 
 * @author hainp
 *
 */
@Controller
public class VehicleRegistrationPlateController {

    /** Vehicle Registration Plates Service. */
    @Autowired
    private VehicleRegistrationPlatesService plateService;

    /** Province service. */
    @Autowired
    private ProvinceService provinceService;

    /**
     * Search Plates Action.
     * 
     * @return
     */
    @GetMapping("/plate/list")
    public ModelAndView searchPlates(@RequestParam("provinceName") Optional<String> provinceName) {
        ModelAndView model = new ModelAndView();
        String searchName = provinceName.orElse("");

        List<VehicleRegistrationPlateDto> platesDtoList 
                                                = plateService.findAll(searchName, AuthenticationUtils.isLogged());

        PlateSearchForm form = new PlateSearchForm();
        form.setPlatesList(platesDtoList);
        form.setProvinceName(searchName);

        model.addObject("platesSearchForm", form);
        model.setViewName("plate/list");

        return model;
    }

    /**
     * Action for initialize create plate form.
     * 
     * @return
     */
    @GetMapping("/plate/create")
    public ModelAndView showCreateForm() {
        ModelAndView model = new ModelAndView();

        // Get all province list
        List<Province> provinceList = provinceService.findAllByOrderByCodeAsc();

        // create plate form to view
        PlateForm plateForm = new PlateForm();
        plateForm.setProvinceList(provinceList);

        model.addObject("plateForm", plateForm);
        model.setViewName("plate/create");
        return model;

    }

    /**
     * Create new province plate.
     * 
     * @param plateForm     PlateForm
     * @param bindingResult BindingResult
     * @return
     */
    @PostMapping("/plate/create")
    public ModelAndView createPlate(@Valid @ModelAttribute("plateForm") PlateForm plateForm,
            BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        // validation
        if (bindingResult.hasErrors()) {
            plateForm.setProvinceList(provinceService.findAllByOrderByCodeAsc());
            model.addObject("plateForm", plateForm);
            model.setViewName("plate/create");
            return model;
        }

        // check exist before add new
        VehicleRegistrationPlates plateExists 
                                    = plateService.findByProvinceCode(plateForm.getProvinceCode());
        if (plateExists != null) {
            bindingResult.rejectValue("provinceCode", 
                                        "error.province.plate.exist", "Province plates is exist!");
            plateForm.setProvinceList(provinceService.findAllByOrderByCodeAsc());
            model.addObject("plateForm", plateForm);
            model.setViewName("plate/create");
            return model;
        }

        // save object into database
        VehicleRegistrationPlateCreateDto plateDto = new VehicleRegistrationPlateCreateDto();
        plateDto.setProvinceCode(plateForm.getProvinceCode());

        // convert form plates to list of province plates object
        List<ProvincePlates> provincePlatesList = new ArrayList<ProvincePlates>();
        String[] provincePlatesArray = plateForm.getPlates().split(Constants.NEW_LINE);

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

    /**
     * Show update form.
     * 
     * @param id plate id
     * @return
     */
    @GetMapping("/plate/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") long id) {
        VehicleRegistrationPlateUpdateDto plateDto = plateService.getUpdateInfo(id);

        PlateUpdateForm updateForm = new PlateUpdateForm();
        String plates = this.convertPlatesDisplay(plateDto.getProvincePlatesList());
        updateForm.setId(plateDto.getId());
        updateForm.setProvinceName(plateDto.getProvinceName());
        updateForm.setPlates(plates);
        updateForm.setPublished(plateDto.isPublished());

        ModelAndView model = new ModelAndView();
        model.addObject("updateForm", updateForm);
        model.setViewName("plate/update");
        return model;
    }

    /**
     * Update plate.
     * 
     * @param id plate id
     * @return
     */
    @PostMapping("/plate/update/{id}")
    public ModelAndView updatePlate(@PathVariable("id") long id, 
            @Valid @ModelAttribute("updateForm") PlateUpdateForm updateForm,
            BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();

        // validation
        if (bindingResult.hasErrors()) {
            updateForm.setId(id);

            model.addObject("updateForm", updateForm);
            model.setViewName("plate/update");
            return model;
        }

        // convert form to update data transfer object
        VehicleRegistrationPlates plate = plateService.findById(id);

        VehicleRegistrationPlateUpdateDto updateDto = new VehicleRegistrationPlateUpdateDto();
        updateDto.setId(updateForm.getId());
        updateDto.setPublished(updateForm.isPublished());

        List<ProvincePlates> provincePlatesList = new ArrayList<ProvincePlates>();
        String[] provincePlatesArray = updateForm.getPlates().split(System.lineSeparator());
        for (String provincePlate : provincePlatesArray) {
            ProvincePlates provincePlateObj = new ProvincePlates();
            provincePlateObj.setVehicleRegistrationPlates(plate);
            provincePlateObj.setValue(provincePlate);
            provincePlateObj.setCreatedAt(LocalDateTime.now());
            provincePlateObj.setUpdatedAt(LocalDateTime.now());

            provincePlatesList.add(provincePlateObj);
        }

        updateDto.setProvincePlatesList(provincePlatesList);
        plateService.update(updateDto);

        // go to search screen
        model.setViewName("redirect:/plate/list");
        return model;
    }

    /**
     * Delete plate.
     * 
     * @param id plate id
     * @return
     */
    @GetMapping("/plate/delete/{id}")
    public ModelAndView deletePlate(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView();
        VehicleRegistrationPlates plate = plateService.findById(id);

        // delete plate
        plateService.delete(plate);

        // go to search screen
        model.setViewName("redirect:/plate/list");
        return model;
    }

    /**
     * Convert plate list to String.
     * 
     * @param provincePlateList List of ProvincePlates
     * @return
     */
    private String convertPlatesDisplay(List<ProvincePlates> provincePlateList) {
        List<String> platesValueList = new ArrayList<String>();

        for (ProvincePlates plate : provincePlateList) {
            platesValueList.add(plate.getValue());
        }

        return StringUtils.join(platesValueList, System.lineSeparator());
    }

}
