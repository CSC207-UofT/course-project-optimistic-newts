package application;

import java.util.HashMap;
import java.util.Map;

/**
 * A data structure representing a request passed through an InputBoundary Interface.
 */
public class RequestModel {
    /**
     * A Map containing the request's data. Specific Key-Value contracts are not enforced here, this should be
     * documented by each class that wants to use a RequestModel.
     */
    private final Map<String, Object> data;

    /**
     * Create an empty RequestModel.
     */
    public RequestModel() {
        this.data = new HashMap<>();
    }

    /**
     * Sets the value at specified key to the specified value in this RequestModel.
     * @param key       Key to store value at.
     * @param value     Value to store at given key.
     */
    public void fill(String key, Object value) {
        data.put(key, value);
    }

    /**
     * @param key   Key to fetch data from.
     * @return      Value at input key in this RequestModel or null if key does not have any value.
     */
    public Object get(String key) {
        return data.get(key);
    }
}