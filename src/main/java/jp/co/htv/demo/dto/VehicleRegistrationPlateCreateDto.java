package jp.co.htv.demo.dto;

import java.util.List;
import jp.co.htv.demo.entity.ProvincePlates;

/**
 * Vehicle Registration Plate Create DTO Class.
 * 
 * @author hainp
 *
 */
public class VehicleRegistrationPlateCreateDto {
    /** Province Code property. */
    private String provinceCode;

    /** Published property. */
    private boolean published;

    /** Province Plates property. */
    private List<ProvincePlates> provincePlatesList;

    /**
     * Getter of province code.
     * 
     * @return the provinceCode
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * Setter of province code.
     * 
     * @param provinceCode the provinceCode to set
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * Getter of published.
     * 
     * @return the published
     */
    public boolean isPublished() {
        return published;
    }

    /**
     * Setter of published.
     * 
     * @param published the published to set
     */
    public void setPublished(boolean published) {
        this.published = published;
    }

    /**
     * Getter of province list.
     * 
     * @return the provincePlatesList
     */
    public List<ProvincePlates> getProvincePlatesList() {
        return provincePlatesList;
    }

    /**
     * Setter of provice plate list.
     * 
     * @param provincePlatesList the provincePlatesList to set
     */
    public void setProvincePlatesList(List<ProvincePlates> provincePlatesList) {
        this.provincePlatesList = provincePlatesList;
    }

}
