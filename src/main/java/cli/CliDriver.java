package cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Command line interface driver that accepts text input from System.in and can output to System.out.
 */
public class CliDriver implements adapters.InOut{
    private BufferedReader reader;

    /**
     * Creates a new CliDriver object.
     */
    public CliDriver() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Returns next input from a buffered input stream reader (reading from System.in).
     * @return next input
     * @throws IOException  if no input to return
     */
    @Override
    public String getInput() throws IOException {
        return reader.readLine();
    }

    /**
     * Prints string representation of an Object to System.out.
     * @param output    desired output
     */
    @Override
    public void sendOutput(Object output) {
        System.out.println(output);
    }
}
