package jp.co.htv.demo.dto.user;

/**
 * User Create DTO Class.
 * @author hainp
 *
 */
public class UserCreateDto {
    /** user name. */
    private String name;

    /** email of user. */
    private String email;

    /** password of user. */
    private String password;

    /**
     * Gets the value of the name property.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of the email property.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the value of the password property.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
