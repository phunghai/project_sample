package jp.co.htv.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vehicle Registration Plates Entity
 * @author hainp
 *
 */
@Entity
@Table(name="vehicle_registration_plates")
public class VehicleRegistrationPlates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "province_cd")
	private String provinceCode;

	
	@Column(name = "published")
	private Boolean published = true;
	
	@Column(name = "created_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime updatedAt;
	
	@OneToMany(fetch = FetchType.LAZY,  cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
	@JoinTable(name="provice_plates", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "vehicle_plates_id"))
	private Set<ProvincePlates> provincePlates;

	

	/**
	 * @param id
	 * @param provinceCode
	 * @param published
	 * @param createdAt
	 * @param updatedAt
	 */
	public VehicleRegistrationPlates(Long id, String provinceCode, Boolean published, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.provinceCode = provinceCode;
		this.published = published;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	/**
	 * 
	 */
	public VehicleRegistrationPlates() {
		super();
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
	 * @return the provinceCode
	 */
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	 * @param provinceCode the provinceCode to set
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	 * @return the published
	 */
	public Boolean getPublished() {
		return published;
	}

	/**
	 * @param published the published to set
	 */
	public void setPublished(Boolean published) {
		this.published = published;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the provincePlates
	 */
	public Set<ProvincePlates> getProvincePlates() {
		return provincePlates;
	}

	/**
	 * @param provincePlates the provincePlates to set
	 */
	public void setProvincePlates(Set<ProvincePlates> provincePlates) {
		this.provincePlates = provincePlates;
	}

}
