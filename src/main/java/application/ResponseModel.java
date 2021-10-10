package application;

/**
 * A data structure representing a response passed through an OutputBoundary Interface.
 */
public class ResponseModel {
    private final Object[] data;

    /**
     * Construct a new ResponseModel with provided data array.
     * @param data  response data array
     */
    public ResponseModel(Object[] data) {
        this.data = data;
    }

    /**
     * Return this ResponseModel's data array.
     * @return  response data array
     */
    public Object[] getData() {
        return this.data;
    }
}
