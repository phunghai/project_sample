package jp.co.htv.demo.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Province Type Entity Class.
 * 
 * @author hainp
 *
 */
@Entity
@Table(name = "m_province_type")
public class ProvinceType {
    @Id
    @Column(name = "cd")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    /**
     * Default constructor.
     */
    public ProvinceType() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Customize constructor.
     * 
     * @param code      province type code
     * @param name      province type name
     * @param createdAt create date
     * @param updatedAt update date
     */
    public ProvinceType(String code, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super();
        this.code = code;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter of code.
     * 
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter of code.
     * 
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter of name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of create date.
     * 
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Setter of create date.
     * 
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Getter of update date.
     * 
     * @return the updatedAt
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter of update date.
     * 
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
