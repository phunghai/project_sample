package jp.co.htv.demo.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * User Entity.
 * 
 * @author Nguyen Phung Hai
 *
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "authorities_users", joinColumns = @JoinColumn(name = "user_id"), 
                inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authority;

    /**
     * Default constructor.
     */
    public User() {
        super();
    }

    /**
     * Custom constructor.
     * 
     * @param name     user name
     * @param email    email of user
     * @param password password of user
     * @param enabled  user enable or not
     */
    public User(String name, String email, String password, boolean enabled) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    /**
     * Getter of id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter of id.
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * Getter of email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter of email.
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter of password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter of password.
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter of enabled.
     * 
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Setter of enabled.
     * 
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Getter of authority.
     * 
     * @return the authority
     */
    public Set<Authority> getAuthority() {
        return authority;
    }

    /**
     * Setter of authority.
     * 
     * @param authority the authority to set
     */
    public void setAuthority(Set<Authority> authority) {
        this.authority = authority;
    }
}
