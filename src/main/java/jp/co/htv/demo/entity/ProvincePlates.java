package jp.co.htv.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Province palates entity
 * @author hainp
 *
 */
@Entity
@Table(name="province_plates")
public class ProvincePlates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "value")
	private String value;
		
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_plates_id")
	private VehicleRegistrationPlates vehicleRegistrationPlates;
	
	@Column(name = "created_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime updatedAt;

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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the vehicleRegistrationPlates
	 */
	public VehicleRegistrationPlates getVehicleRegistrationPlates() {
		return vehicleRegistrationPlates;
	}

	/**
	 * @param vehicleRegistrationPlates the vehicleRegistrationPlates to set
	 */
	public void setVehicleRegistrationPlates(VehicleRegistrationPlates vehicleRegistrationPlates) {
		this.vehicleRegistrationPlates = vehicleRegistrationPlates;
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

		
}
