package jp.co.htv.demo.dto;

import java.util.List;

import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.entity.ProvincePlates;

/**
 * Vehicle Registration Plates Data Transfer Object
 * @author hainp
 *
 */
public class VehicleRegistrationPlatesDto {
	/** id property */
	private Long id;
	
	/** province property */
	private Province province;
	
	/** plates of province list property */
	private List<ProvincePlates> provincePlatesList;
	
	/** published property */
	private boolean published;
	

	/**
	 * 
	 */
	public VehicleRegistrationPlatesDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * Custom constructor
	 * @param id
	 * @param province
	 * @param provincePlatesList
	 * @param published
	 */
	public VehicleRegistrationPlatesDto(Long id, Province province, List<ProvincePlates> provincePlatesList,
			boolean published) {
		super();
		this.id = id;
		this.province = province;
		this.provincePlatesList = provincePlatesList;
		this.published = published;
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
	 * @return the province
	 */
	public Province getProvince() {
		return province;
	}


	/**
	 * @param province the province to set
	 */
	public void setProvince(Province province) {
		this.province = province;
	}


	/**
	 * @return the published
	 */
	public boolean isPublished() {
		return published;
	}


	/**
	 * @param published the published to set
	 */
	public void setPublished(boolean published) {
		this.published = published;
	}


	/**
	 * @return the provincePlatesList
	 */
	public List<ProvincePlates> getProvincePlatesList() {
		return provincePlatesList;
	}


	/**
	 * @param provincePlatesList the provincePlatesList to set
	 */
	public void setProvincePlatesList(List<ProvincePlates> provincePlatesList) {
		this.provincePlatesList = provincePlatesList;
	}
		
	
}
