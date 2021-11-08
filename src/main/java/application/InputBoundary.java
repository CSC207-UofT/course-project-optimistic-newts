package application;

/**
 * An Input Boundary interface. Defines a standard input method by which to pass RequestModel objects.
 */
public interface InputBoundary {

    /**
     * Accepts a request.
     * @param request   a request stored as a RequestModel
     * @param config an object storing the Responses
     */
    public void request(RequestModel request, ConfigReader config) throws Exception;
}