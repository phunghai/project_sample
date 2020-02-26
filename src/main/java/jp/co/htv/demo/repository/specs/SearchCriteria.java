package jp.co.htv.demo.repository.specs;

/**
 * Search Criteria Class.
 * @author hainp
 *
 */
public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation operation;
    /**
     * 
     */
    public SearchCriteria() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @param key
     * @param value
     * @param operation
     */
    public SearchCriteria(String key, Object value, SearchOperation operation) {
        super();
        this.key = key;
        this.value = value;
        this.operation = operation;
    }
    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }
    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }
    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
    /**
     * @return the operation
     */
    public SearchOperation getOperation() {
        return operation;
    }
    /**
     * @param operation the operation to set
     */
    public void setOperation(SearchOperation operation) {
        this.operation = operation;
    }
    
}
