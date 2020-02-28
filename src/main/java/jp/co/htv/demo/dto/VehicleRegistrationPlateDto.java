package jp.co.htv.demo.dto;

import java.util.List;
import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.entity.ProvincePlates;

/**
 * Vehicle Registration Plates Data Transfer Object.
 * 
 * @author hainp
 *
 */
public class VehicleRegistrationPlateDto {
    /** id property. */
    private Long id;

    /** province property. */
    private Province province;

    /** plates of province list property. */
    private List<ProvincePlates> provincePlatesList;

    /** published property. */
    private boolean published;

    /**
     * Default constructor.
     */
    public VehicleRegistrationPlateDto() {
        super();
    }

    /**
     * Custom constructor.
     * 
     * @param id plate id
     * @param province province of plate
     * @param provincePlatesList province plate list
     * @param published published
     */
    public VehicleRegistrationPlateDto(Long id, Province province, 
                                        List<ProvincePlates> provincePlatesList,
            boolean published) {
        super();
        this.id = id;
        this.province = province;
        this.provincePlatesList = provincePlatesList;
        this.published = published;
    }

    /**
     * Getter of id.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter of id.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter of province.
     * @return the province
     */
    public Province getProvince() {
        return province;
    }

    /**
     * Setter of province.
     * @param province the province to set
     */
    public void setProvince(Province province) {
        this.province = province;
    }

    /**
     * Getter of published.
     * @return the published
     */
    public boolean isPublished() {
        return published;
    }

    /**
     * Setter of published.
     * @param published the published to set
     */
    public void setPublished(boolean published) {
        this.published = published;
    }

    /**
     * Getter of province plate list.
     * @return the provincePlatesList
     */
    public List<ProvincePlates> getProvincePlatesList() {
        return provincePlatesList;
    }

    /**
     * Setter of province plate list.
     * @param provincePlatesList the provincePlatesList to set
     */
    public void setProvincePlatesList(List<ProvincePlates> provincePlatesList) {
        this.provincePlatesList = provincePlatesList;
    }

}
