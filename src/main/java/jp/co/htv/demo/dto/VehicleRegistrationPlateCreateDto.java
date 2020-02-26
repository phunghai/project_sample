package jp.co.htv.demo.dto;

import java.util.List;

import jp.co.htv.demo.entity.ProvincePlates;

/**
 * Vehicle Registration Plate Create DTO Class
 * 
 * @author hainp
 *
 */
public class VehicleRegistrationPlateCreateDto {
    /** Province Code property */
    private String provinceCode;

    /** Published property */
    private boolean published;

    /** Province Plates property */
    private List<ProvincePlates> provincePlatesList;

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
