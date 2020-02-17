package jp.co.htv.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import jp.co.htv.demo.repository.OwnerRepository;

/**
 * 
 * @author Nguyen Phung Hai
 *
 */
@Controller
public class OwnerController {
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private final OwnerRepository owners;


    public OwnerController(OwnerRepository clinicService) {
        this.owners = clinicService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }	

//    @GetMapping("/owners/new")
//    public String initCreationForm(Map<String, Object> model) {
//        OwnerEntity owner = new OwnerEntity();
//        model.put("owner", owner);
//        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//    }
//
//    @PostMapping("/owners/new")
//    public String processCreationForm(@Valid Owner owner, BindingResult result) {
//        if (result.hasErrors()) {
//            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//        } else {
//            this.owners.save(owner);
//            return "redirect:/owners/" + owner.getId();
//        }
//    }
//
//    @GetMapping("/owners/find")
//    public String initFindForm(Map<String, Object> model) {
//        model.put("owner", new Owner());
//        return "owners/findOwners";
//    }
//
//    @GetMapping("/owners")
//    public String processFindForm(Owner owner, BindingResult result, Map<String, Object> model) {
//
//        // allow parameterless GET request for /owners to return all records
//        if (owner.getLastName() == null) {
//            owner.setLastName(""); // empty string signifies broadest possible search
//        }
//
//        // find owners by last name
//        Collection<Owner> results = this.owners.findByLastName(owner.getLastName());
//        if (results.isEmpty()) {
//            // no owners found
//            result.rejectValue("lastName", "notFound", "not found");
//            return "owners/findOwners";
//        } else if (results.size() == 1) {
//            // 1 owner found
//            owner = results.iterator().next();
//            return "redirect:/owners/" + owner.getId();
//        } else {
//            // multiple owners found
//            model.put("selections", results);
//            return "owners/ownersList";
//        }
//    }
//
//    @GetMapping("/owners/{ownerId}/edit")
//    public String initUpdateOwnerForm(@PathVariable("ownerId") int ownerId, Model model) {
//        Owner owner = this.owners.findById(ownerId);
//        model.addAttribute(owner);
//        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//    }
//
//    @PostMapping("/owners/{ownerId}/edit")
//    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") int ownerId) {
//        if (result.hasErrors()) {
//            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//        } else {
//            owner.setId(ownerId);
//            this.owners.save(owner);
//            return "redirect:/owners/{ownerId}";
//        }
//    }
//
//    /**
//     * Custom handler for displaying an owner.
//     *
//     * @param ownerId the ID of the owner to display
//     * @return a ModelMap with the model attributes for the view
//     */
//    @GetMapping("/owners/{ownerId}")
//    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
//        ModelAndView mav = new ModelAndView("owners/ownerDetails");
//        Owner owner = this.owners.findById(ownerId);
//        for (Pet pet : owner.getPets()) {
//            pet.setVisitsInternal(visits.findByPetId(pet.getId()));
//        }
//        mav.addObject(owner);
//        return mav;
//    }

}
