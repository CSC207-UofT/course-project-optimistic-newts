package application;

import java.util.Map;

/**
 * A data structure representing a response passed through an OutputBoundary Interface.
 */
public class ResponseModel {
    private final Map<String, Object> data;

    /**
     * Construct a new ResponseModel with provided data map (string keys, object values).
     * @param data  Response data map
     */
    public ResponseModel(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * Return this ResponseModel's data map.
     * @return  Response data array
     */
    public Map<String, Object> getData() {
        return this.data;
    }
}
