package jp.co.htv.demo.form.plate;

import javax.validation.constraints.NotBlank;
import jp.co.htv.demo.validation.DuplicationPlateCheck;

/**
 * Plate Update Form Class.
 * 
 * @author hainp
 *
 */
public class PlateUpdateForm {
    /** plate id. */
    private Long id;

    /** Province Name. */
    private String provinceName;

    /** Plates property. */
    @NotBlank
    @DuplicationPlateCheck
    private String plates;

    /** Published property. **/
    private boolean published;

    /**
     * Getter of plate id.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter of plate id.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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

    /**
     * Getter of plate list.
     * @return the plates
     */
    public String getPlates() {
        return plates;
    }

    /**
     * Setter of plate list.
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

}
