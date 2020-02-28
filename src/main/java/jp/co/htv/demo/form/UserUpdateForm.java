package jp.co.htv.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * User Update Form class.
 * 
 * @author Nguyen Phung Hai
 *
 */
public class UserUpdateForm {
    /** user id. */
    private Long id;
    
    @NotBlank(message = "{item.required}")
    private String name;

    private String password;
    
    /** Stored old password. */
    private String oldPassword;

    /**
     * Default constructor.
     */
    public UserUpdateForm() {
        super();
    }

    /**
     * Custom constructor.
     * 
     * @param name user name
     * @param password password of users
     */
    public UserUpdateForm(@NotNull String name, @NotNull String password) {
        super();
        this.name = name;
        this.password = password;
    }

    /**
     * Getter of name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Getter of password.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter of password.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter of id.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter of id.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter of old password.
     * @return the oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Setter of old password.
     * @param oldPassword the oldPassword to set
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    
}
