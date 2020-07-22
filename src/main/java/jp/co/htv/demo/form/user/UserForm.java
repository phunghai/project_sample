package jp.co.htv.demo.form.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import jp.co.htv.demo.validation.ValidPassword;

/**
 * User Form class.
 * 
 * @author Nguyen Phung Hai
 *
 */
public class UserForm {
    @NotBlank(message = "{item.required}")
    private String name;

    @NotBlank(message = "{item.required}")
    @Email
    private String email;

    @NotBlank(message = "{item.required}")
    @ValidPassword
    private String password;

    /**
     * Default constructor.
     */
    public UserForm() {
        super();
    }

    /**
     * Custom constructor.
     * 
     * @param name user name
     * @param email email of user
     * @param password password of users
     */
    public UserForm(@NotNull String name, @NotNull String email, @NotNull String password) {
        super();
        this.name = name;
        this.email = email;
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
     * Getter of email.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter of email.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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

}
