package jp.co.htv.demo.form.plate;

import java.util.List;
import javax.validation.constraints.NotBlank;
import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.validation.DuplicationPlateCheck;

/**
 * Plate Form Class.
 * 
 * @author hainp
 *
 */
public class PlateForm {
    /** Province Code. **/
    private String provinceCode;

    /** Province Name. */
    private String provinceName;

    /** Plates property. */
    @NotBlank(message = "{item.required}")
    @DuplicationPlateCheck
    private String plates;

    /** Published property. **/
    private boolean published;

    /** Province Display List. **/
    private List<Province> provinceList;

    /**
     * Getter of province code.
     * @return the provinceCode
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * Setter of province code.
     * @param provinceCode the provinceCode to set
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * Getter of plates.
     * @return the plates
     */
    public String getPlates() {
        return plates;
    }

    /**
     * Setter of plates.
     * @param plates the plates to set
     */
    public void setPlates(String plates) {
        this.plates = plates;
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
     * Getter of province list.
     * @return the provinceList
     */
    public List<Province> getProvinceList() {
        return provinceList;
    }

    /**
     * Setter of province list.
     * @param provinceList the provinceList to set
     */
    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    /**
     * Getter of province name.
     * @return the provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * Setter of province name.
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

}
