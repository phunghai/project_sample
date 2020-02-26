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
    /** name on condition **/
    private String name;
    
    /** email property */
    private String email;

    /** result **/
    private Page<User> result;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the result
     */
    public Page<User> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Page<User> result) {
        this.result = result;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
