package jp.co.htv.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * User Form class
 * @author Nguyen Phung Hai
 *
 */
public class UserForm {
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	/**
	 * Default constructor 
	 */
	public UserForm() {
		super();
	}
	
	/**
	 * Custom constructor
	 * @param name
	 * @param email
	 * @param password
	 */
	public UserForm(@NotNull String name, @NotNull String email, @NotNull String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}



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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
