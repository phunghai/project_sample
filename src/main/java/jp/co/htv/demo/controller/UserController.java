package jp.co.htv.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.htv.demo.entity.User;
import jp.co.htv.demo.form.UserSearchForm;
import jp.co.htv.demo.service.UserService;

/**
 * User Controller class
 * Provide CRUD method for User
 * @author Nguyen Phung Hai
 *
 */
@Controller
public class UserController {
	/** User Service */
	@Autowired
	private UserService userService;
	
	
	/**
	 * Search user with paging controller
	 * @param name user name
	 * @param page specify page number
	 * @param size page size
	 * @return
	 */
    @RequestMapping("/users")
    public ModelAndView searchUser(@RequestParam("name") Optional<String> name, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
    	ModelAndView model = new ModelAndView();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        
        String searchName = name.orElse("");

        // get user list from service
    	Page<User> userPage = userService.findPaginatedByName(searchName, PageRequest.of(currentPage - 1, pageSize));
    	
    	// Form contain search condition and search result
    	UserSearchForm form = new UserSearchForm();
    	form.setResult(userPage);
    	
    	model.addObject("userSearchForm", form);
	    
        // calulate total page
	    int totalPages = userPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addObject("pageNumbers", pageNumbers);
        }
        
	    model.setViewName("user/search");
	    return model;
    }
	
	/**
	 * Get all users
	 * @return ModelAndView mv
	 */
    @RequestMapping("/user/search")
    public ModelAndView userSearch() {
    	ModelAndView model = new ModelAndView();
	    model.addObject("users", userService.findAll());
	    model.setViewName("user/search");
	    return model;
    }

	@GetMapping("/user/registration")
	public ModelAndView showCreateForm() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("/user/registration");

		return model;
	}

	@PostMapping("/user")
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult) {
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
	 * @param result Binding
	 * @return
	 */
	@PutMapping("/user/update/{id}")
	public ModelAndView updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result) {
		ModelAndView model = new ModelAndView();
	    if (result.hasErrors()) {
	        user.setId(id);
	        
		    model.addObject("user", user);
		    model.setViewName("/user/update");
		    return model;
	    }
	         
	    userService.updateUser(id, user.getName());
	    model.addObject("users", userService.findAll());
	    model.setViewName("user/search");
	    return model;
	}

	/**
	 * Delete User
	 * @param id
	 * @return
	 */
	@DeleteMapping("/user/delete/{id}")
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
