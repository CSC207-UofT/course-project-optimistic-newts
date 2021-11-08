package application;

public interface ConfigReader {

    /**
     * Return the string with the given key.
     * @param key The key of the string
     * @return The string
     * @throws Exception If no key value pair exists with the given key
     */
    String get(String key) throws Exception;
}
