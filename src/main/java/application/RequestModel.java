package application;

import java.util.Map;

/**
 * A data structure representing a request passed through an InputBoundary Interface.
 */
public class RequestModel {
    private final Map<String, Object> data;
    private final OutputBoundary respondTo;

    /**
     * Construct a new RequestModel with an output location and provided data map (String keys, Object values).
     * @param respondTo     OutputBoundary to send response by
     * @param data          Request data map
     */
    public RequestModel(OutputBoundary respondTo, Map<String, Object> data) {
        this.respondTo = respondTo;
        this.data = data;
    }

    /**
     * Return this RequestModel's data.
     * @return  Request data map
     */
    public Map<String, Object> getData() {
        return this.data;
    }

    public OutputBoundary getRespondTo() { return this.respondTo; }
}
