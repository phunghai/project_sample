package jp.co.htv.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vehicle Registration Plates Entity.
 * 
 * @author hainp
 *
 */
@Entity
@Table(name = "vehicle_registration_plates")
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

    @OneToMany(mappedBy = "vehicleRegistrationPlates", cascade = { CascadeType.ALL })
    private List<ProvincePlates> provincePlates = new ArrayList<>();

    /**
     * Custom constructor.
     * @param id plate id
     * @param provinceCode province code
     * @param published published
     * @param createdAt created date
     * @param updatedAt updated date
     */
    public VehicleRegistrationPlates(Long id, String provinceCode, Boolean published, 
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        super();
        this.id = id;
        this.provinceCode = provinceCode;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Default constructor.
     */
    public VehicleRegistrationPlates() {
        super();
    }

    /**
     * Gets the value of the id property.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the value of the provinceCode property.
     * @return the provinceCode
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * Sets the value of the provinceCode property.
     * @param provinceCode the provinceCode to set
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * Gets the value of the published property.
     * @return the published
     */
    public Boolean getPublished() {
        return published;
    }

    /**
     * Sets the value of the published property.
     * @param published the published to set
     */
    public void setPublished(Boolean published) {
        this.published = published;
    }

    /**
     * Gets the value of the createdAt property.
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the value of the updatedAt property.
     * @return the updatedAt
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the value of the updatedAt property.
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets the value of the provincePlates property.
     * @return the provincePlates
     */
    public List<ProvincePlates> getProvincePlates() {
        return provincePlates;
    }

    /**
     * Sets the value of the provincePlates property.
     * @param provincePlates the provincePlates to set
     */
    public void setProvincePlates(List<ProvincePlates> provincePlates) {
        this.provincePlates = provincePlates;
    }

}
