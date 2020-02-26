package jp.co.htv.demo.dto;

import java.util.List;

import jp.co.htv.demo.entity.ProvincePlates;

/**
 * Vehicle Registration Plate Update Dto.
 * 
 * @author hainp
 *
 */
public class VehicleRegistrationPlateUpdateDto {
    /** id property */
    private Long id;

    /** province code property */
    private String provinceCode;

    /** province name property */
    private String provinceName;

    /** published property */
    private boolean published;

    /** province plates list */
    private List<ProvincePlates> provincePlatesList;

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
     * @return the provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
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
