package jp.co.htv.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Authority Entity Class.
 * 
 * @author Nguyen Phung Hai
 *
 */
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String authority;

    /**
     * Default constructor.
     */
    public Authority() {
        super();
    }

    /**
     * Custom constructor.
     * 
     * @param authority Authority
     */
    public Authority(String authority) {
        super();
        this.authority = authority;
    }

    /**
     * Getter of id.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter of id.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter of Authority.
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Setter of authority.
     * @param authority the authority to set
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
