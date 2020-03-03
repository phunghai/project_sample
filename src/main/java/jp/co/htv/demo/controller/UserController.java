package jp.co.htv.demo.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import javax.validation.Valid;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jp.co.htv.demo.dto.user.UserCreateDto;
import jp.co.htv.demo.dto.user.UserUpdateDto;
import jp.co.htv.demo.entity.User;
import jp.co.htv.demo.form.user.UserForm;
import jp.co.htv.demo.form.user.UserSearchForm;
import jp.co.htv.demo.form.user.UserUpdateForm;
import jp.co.htv.demo.service.UserService;

/**
 * User Controller class Provide CRUD method for User.
 * 
 * @author Nguyen Phung Hai
 *
 */
@Controller
public class UserController {
    /**  Logger. */
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    /** User Service. */
    @Autowired
    private UserService userService;

    /**
     * Search user with paging controller.
     * 
     * @param name user name
     * @param page specify page number
     * @param size page size
     * @return
     */
    @RequestMapping("/users")
    public ModelAndView searchUser(@RequestParam("name") Optional<String> name,
            @RequestParam("email") Optional<String> email,
            @RequestParam("page") Optional<Integer> page, 
            @RequestParam("size") Optional<Integer> size) {
        
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        String searchName = name.orElse("");
        String searchEmail = email.orElse("");

        // get user list from service
        Page<User> userPage = userService.findPaginatedByNameOrEmail(searchName, searchEmail, 
                                                        PageRequest.of(currentPage - 1, pageSize));

        // Form contain search condition and search result
        UserSearchForm form = new UserSearchForm();
        form.setResult(userPage);
        form.setName(searchName);
        form.setEmail(searchEmail);

        ModelAndView model = new ModelAndView();
        model.addObject("userSearchForm", form);

        model.setViewName("user/search");
        return model;
    }

    /**
     * Action for initialize new user.
     * @return
     */
    @GetMapping("/user/registration")
    public ModelAndView showCreateForm() {
        ModelAndView model = new ModelAndView();
        UserForm user = new UserForm();
        model.addObject("user", user);
        model.setViewName("user/registration");

        return model;
    }

    /**
     * Action for register user.
     * @param userForm User Form
     * @param bindingResult Binding for validation.
     * @return
     */
    @PostMapping("/user/registration")
    public ModelAndView registerUser(@Valid @ModelAttribute("user") UserForm userForm, 
                                        BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();

        // validation
        if (bindingResult.hasErrors()) {
            model.addObject("user", userForm);
            model.setViewName("user/registration");
            return model;
        }
        
        // check user exists or not
        User userExists = userService.findUserByEmail(userForm.getEmail());
        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
            model.addObject("user", userForm);
            model.setViewName("user/registration");
            return model;
        }

        UserCreateDto user = new UserCreateDto();
        // copy form to entity
        try {
            BeanUtils.copyProperties(user, userForm);
            userService.saveUser(user);

            // redirect to search user
            model.setViewName("redirect:/users");
            return model;
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error("Error parsing from form to enitity.");
            // if have exception then stay in current page.
            model.addObject("user", userForm);
            model.setViewName("user/registration");
            return model;
        }

    }

    /**
     * Action for show user before editing.
     * 
     * @param id user id
     * @return
     */
    @GetMapping("/user/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") long id) {
        // get stored user information
        User user = userService.findUserById(id);
        
        // create updating form.
        UserUpdateForm updateForm = new UserUpdateForm();
        updateForm.setId(user.getId());
        updateForm.setName(user.getName());
        
        ModelAndView model = new ModelAndView();
        model.addObject("updateForm", updateForm);
        model.setViewName("user/update");

        return model;
    }

    /**
     * Update user information.
     * 
     * @param id user id
     * @param updateForm User Update Form
     * @param result Binding
     * @return
     */
    @PostMapping("/user/update/{id}")
    public ModelAndView updateUser(@PathVariable("id") long id, 
            @Valid @ModelAttribute("updateForm") UserUpdateForm updateForm, BindingResult result) {
        ModelAndView model = new ModelAndView();
        if (result.hasErrors()) {
            updateForm.setId(id);

            model.addObject("updateForm", updateForm);
            model.setViewName("user/update");
            return model;
        }
        
        UserUpdateDto userDto = new UserUpdateDto();
        userDto.setId(id);
        userDto.setName(updateForm.getName());
        userDto.setPassword(updateForm.getPassword());
        //check input password
        userService.updateUser(userDto);
        // redirect to search user
        model.setViewName("redirect:/users");
        return model;
    }

    /**
     * Delete User.
     * 
     * @param id user id
     * @return
     */
    @GetMapping("/user/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView();
        // Get user information
        User user = userService.findUserById(id);

        userService.deleteUser(user);
        // redirect to search user
        model.setViewName("redirect:/users");
        return model;
    }
}
