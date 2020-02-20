package jp.co.htv.demo.dto;

/**
 * UserDTO class
 * For mapping item with screen
 * @author Nguyen Phung Hai
 *
 */
public class UserDto {
	/** User Id **/
	private Long id;
	
	/** User name property **/
	private String name;
	
	/** Email property **/
	private String email;
	
	

	/**
	 * Default Constructor 
	 */
	public UserDto() {
		super();
	}

	/**
	 * Custom constructor
	 * @param id
	 * @param name
	 * @param email
	 */
	public UserDto(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
}
