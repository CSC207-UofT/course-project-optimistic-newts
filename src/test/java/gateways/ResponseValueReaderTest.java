package gateways;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class ResponseValueReaderTest {
    ResponseValueReader responseValueReader;

    /**
     * Create a new ResponseValueReader object.
     * @throws IOException If the file cannot be read.
     */
    @Before
    public void setUp() throws IOException, ParseException {
        responseValueReader = new ResponseValueReader();
    }

    @Test
    public void getTest() throws Exception {
        String response = responseValueReader.get("created");
        Assert.assertEquals(response, " has been created ");
    }
}
