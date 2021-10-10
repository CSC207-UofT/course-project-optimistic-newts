package adapters;

import java.io.IOException;

/**
 * A general Input/Output interface.
 */
public interface InOut {

    /**
     * Returns input String to caller.
     * @return  String input
     */
    String getInput() throws IOException;

    /**
     * Outputs an Object.
     * @param output    desired output
     */
    void sendOutput(Object output);
}
