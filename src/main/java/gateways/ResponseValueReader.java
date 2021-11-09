package gateways;

import application.ConfigReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ResponseValueReader implements ConfigReader {
    private HashMap<String, String> ResponseValues = new HashMap<>();

    public ResponseValueReader() throws IOException, ParseException{
        String RESPONSE_VALUE_PATH = "configData/ResponseValues.JSON/";

        JSONParser jsonparser = new JSONParser();

        FileReader reader = new FileReader(RESPONSE_VALUE_PATH);

        Object obj = jsonparser.parse(reader);

        JSONObject jsonObject = (JSONObject)obj;

        if (jsonObject.size() > 0){
            for (Object o : jsonObject.keySet()) {
                String key = (String) o;
                String val = (String) jsonObject.get(key);
                this.ResponseValues.put(key, val);
            }
        }
    }

    /**
     * Return the value of the Response given key
      * @param key The key of the string
     * @return The response string or null if no such string exists
     */
    @Override
    public String get(String key){
        try {
            return this.ResponseValues.get(key);
        } catch (Exception e){
            return null;
        }
    }
}
