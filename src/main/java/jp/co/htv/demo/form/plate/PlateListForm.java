package jp.co.htv.demo.form.plate;

import java.util.List;

import jp.co.htv.demo.dto.VehicleRegistrationPlatesDto;

public class PlateListForm {
    private List<VehicleRegistrationPlatesDto> platesList;

    /**
     * @return the platesList
     */
    public List<VehicleRegistrationPlatesDto> getPlatesList() {
        return platesList;
    }

    /**
     * @param platesList the platesList to set
     */
    public void setPlatesList(List<VehicleRegistrationPlatesDto> platesList) {
        this.platesList = platesList;
    }

}
