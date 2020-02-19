package jp.co.htv.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.htv.demo.entity.User;
import jp.co.htv.demo.service.UserService;

/**
 * User Controller class
 * 
 * @author Nguyen Phung Hai
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
    /** User zone index. */
    @RequestMapping("/user/search")
    public ModelAndView userSearch() {
    	ModelAndView model = new ModelAndView();
	    model.addObject("users", userService.findAll());
	    model.setViewName("user/search");
	    return model;
    }

	@GetMapping("/user/registration")
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("/user/registration");

		return model;
	}

	@PostMapping("/user/registration")
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exists!");
		}

		if (bindingResult.hasErrors()) {
			model.setViewName("/user/registration");
		} else {
			userService.saveUser(user);
			model.addObject("users", userService.findAll());
			model.setViewName("user/search");
			return model;
		}

		return model;
	}

	/**
	 * Action for show user before editing
	 * @param id
	 * @return
	 */
	@GetMapping("/user/edit/{id}")
	public ModelAndView showUpdateForm(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView();
	    User user = userService.findUserById(Long.valueOf(id));
	     
	    model.addObject("user", user);
	    model.setViewName("/user/update");
	    
	    return model;
	}

	/**
	 * Update user information
	 * @param id
	 * @param user
	 * @param result
	 * @return
	 */
	@PostMapping("/user/update/{id}")
	public ModelAndView updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result) {
		ModelAndView model = new ModelAndView();
	    if (result.hasErrors()) {
	        user.setId(id);
	        
		    model.addObject("user", user);
		    model.setViewName("/user/update");
		    return model;
	    }
	         
	    userService.saveUser(user);
	    model.addObject("users", userService.findAll());
	    model.setViewName("user/search");
	    return model;
	}
	     
	@GetMapping("/user/delete/{id}")
	public ModelAndView deleteUser(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView();
	    // Get user information
		User user = userService.findUserById(id);
		
		
	    userService.deleteUser(user);
	    model.addObject("users", userService.findAll());
	    model.setViewName("user/search");
	    return model;
	}
}
