package jp.co.htv.demo.form.plate;

import java.util.List;

import jp.co.htv.demo.dto.VehicleRegistrationPlateDto;

/**
 * Plate Search Form Class.
 * @author hainp
 *
 */
public class PlateSearchForm {
    /** province name property. */
    private String provinceName;
    
    /** plate property. */
    private String plate;
    
    /** Vehicle registration plate list. */
    private List<VehicleRegistrationPlateDto> platesList;

    /**
     * @return the platesList
     */
    public List<VehicleRegistrationPlateDto> getPlatesList() {
        return platesList;
    }

    /**
     * @param platesList the platesList to set
     */
    public void setPlatesList(List<VehicleRegistrationPlateDto> platesList) {
        this.platesList = platesList;
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
     * @return the plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * @param plate the plate to set
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

}
