package jp.co.htv.demo.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Province Entity Class.
 * 
 * @author hainp
 *
 */
@Entity
@Table(name = "m_province")
public class Province {

    @Id
    @Column(name = "cd")
    private String code;

    @Column(name = "type_cd")
    private String typeCode;

    @Column(name = "name")
    private String name;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    /**
     * Default constructor.
     */
    public Province() {
        super();
    }

    /**
     * Custom constructor.
     * @param code province code
     * @param typeCode type of province
     * @param name province name
     * @param nameEn province name english
     * @param createdAt created date
     * @param updatedAt updated date
     */
    public Province(String code, String typeCode, String name, String nameEn, 
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        super();
        this.code = code;
        this.typeCode = typeCode;
        this.name = name;
        this.nameEn = nameEn;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter of code.
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter of code.
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter of typeCode.
     * @return the typeCode
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * Getter of typeCode.
     * @param typeCode the typeCode to set
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * Getter of name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of name en.
     * @return the nameEn
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * Setter of name en.
     * @param nameEn the nameEn to set
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    /**
     * Getter of create date.
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Setter of create date.
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Getter of update date.
     * @return the updatedAt
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Setter of update date.
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
