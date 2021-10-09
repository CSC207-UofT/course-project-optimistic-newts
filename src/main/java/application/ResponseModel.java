package application;

/**
 * A data structure representing a response passed through an OutputBoundary Interface.
 */
public class ResponseModel {
    private final String data;

    /**
     * Construct a new ResponseModel with provided data.
     * @param data  response data
     */
    public ResponseModel(String data) {
        this.data = data;
    }

    /**
     * Return this ResponseModel's data.
     * @return  response data
     */
    public String getData() {
        return this.data;
    }
}
