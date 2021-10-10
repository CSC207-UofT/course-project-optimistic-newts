package application;

/**
 * A data structure representing a request passed through an InputBoundary Interface.
 */
public class RequestModel {
    private final Object[] data;
    private final OutputBoundary respondTo;

    /**
     * Construct a new RequestModel with an output location and provided data array.
     * @param respondTo     OutputBoundary to send response by
     * @param data          Request data array
     */
    public RequestModel(OutputBoundary respondTo, Object[] data) {
        this.respondTo = respondTo;
        this.data = data;
    }

    /**
     * Return this RequestModel's data.
     * @return  Request data
     */
    public Object[] getData() {
        return this.data;
    }

    public OutputBoundary getRespondTo() { return this.respondTo; }
}
