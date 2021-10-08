package application;

/**
 * A data structure representing a request passed through an InputBoundary Interface.
 *
 */
public class RequestModel {
    private final String data;

    /**
     * Construct a new RequestModel with provided data.
     * @param data  request data
     */
    public RequestModel(String data) {
        this.data = data;
    }

    /**
     * Return this RequestModel's data.
     * @return  request data
     */
    public String getData() {
        return this.data;
    }
}
