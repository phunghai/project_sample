package jp.co.htv.demo.form.plate;

import java.util.List;

import javax.validation.constraints.NotBlank;

import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.validation.DuplicationPlateCheck;

/**
 * Plate Form Class
 * 
 * @author hainp
 *
 */
public class PlateForm {
    /** Province Code **/
    private String provinceCode;

    /** Province Name */
    private String provinceName;

    /** Plates property */
    @NotBlank
    @DuplicationPlateCheck
    private String plates;

    /** Published property **/
    private boolean published;

    /** Province Display List **/
    private List<Province> provinceList;

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
     * @return the plates
     */
    public String getPlates() {
        return plates;
    }

    /**
     * @param plates the plates to set
     */
    public void setPlates(String plates) {
        this.plates = plates;
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
     * @return the provinceList
     */
    public List<Province> getProvinceList() {
        return provinceList;
    }

    /**
     * @param provinceList the provinceList to set
     */
    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
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

}
