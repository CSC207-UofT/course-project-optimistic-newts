package application;

import java.util.Optional;

/**
 * A data structure representing a request passed through an InputBoundary Interface.
 */
public class RequestModel {
    private final String data;
    private final OutputBoundary respondTo;

    /**
     * Construct a new RequestModel with an output location and provided data.
     * @param respondTo     OutputBoundary to send response by
     * @param data          Request data
     */
    public RequestModel(OutputBoundary respondTo, String data) {
        this.respondTo = respondTo;
        this.data = data;
    }

    /**
     * Return this RequestModel's data.
     * @return  Request data
     */
    public String getData() {
        return this.data;
    }

    public OutputBoundary getRespondTo() { return this.respondTo; }
}
