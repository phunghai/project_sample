package jp.co.htv.demo.form;

import org.springframework.data.domain.Page;
import jp.co.htv.demo.entity.User;

/**
 * User Search Form.
 * 
 * @author Nguyen Phung Hai
 *
 */
public class UserSearchForm {
    /** name on condition. **/
    private String name;
    
    /** email property. */
    private String email;

    /** resul.t **/
    private Page<User> result;

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
     * Getter of result.
     * @return the result
     */
    public Page<User> getResult() {
        return result;
    }

    /**
     * Setter of result.
     * @param result the result to set
     */
    public void setResult(Page<User> result) {
        this.result = result;
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

}
