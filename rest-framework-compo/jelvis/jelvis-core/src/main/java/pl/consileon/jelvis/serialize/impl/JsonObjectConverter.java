package pl.consileon.jelvis.serialize.impl;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import pl.consileon.jelvis.serialize.ObjectConverter;

import java.io.IOException;

/**
 * Object converter supporting <code>application/json</code> mime type.
 */
public class JsonObjectConverter implements ObjectConverter {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supportsType(String contentType) {
        return contentType.contains("application/json");
    }

    @Override
    public String convert(Object target) throws IOException {
        return objectMapper.writeValueAsString(target);
    }
}
