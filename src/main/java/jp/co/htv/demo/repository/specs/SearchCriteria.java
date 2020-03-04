package jp.co.htv.demo.repository.specs;

import java.io.Serializable;

/**
 * Search Criteria Class.
 * 
 * @author hainp
 *
 */
public class SearchCriteria implements Serializable {
    /**
     * serialVersionUID property. 
     */
    private static final long serialVersionUID = -2103687549171908775L;
    
    private String key;
    private Object value;
    private SearchOperation operation;

    /**
     * Default constructor.
     */
    public SearchCriteria() {
        super();
    }

    /**
     * Custom constructor.
     * @param key column name
     * @param value value of key
     * @param operation operation is like, and, greater,...
     */
    public SearchCriteria(String key, Object value, SearchOperation operation) {
        super();
        this.key = key;
        this.value = value;
        this.operation = operation;
    }

    /**
     * Getter of key.
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Setter of key.
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Getter of value.
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Setter of value.
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Getter of operation.
     * @return the operation
     */
    public SearchOperation getOperation() {
        return operation;
    }

    /**
     * Setter of operation.
     * @param operation the operation to set
     */
    public void setOperation(SearchOperation operation) {
        this.operation = operation;
    }

}
