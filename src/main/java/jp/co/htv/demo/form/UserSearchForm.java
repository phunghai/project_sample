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

}
