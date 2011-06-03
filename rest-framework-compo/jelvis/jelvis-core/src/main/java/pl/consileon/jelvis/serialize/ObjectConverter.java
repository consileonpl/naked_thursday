package pl.consileon.jelvis.serialize;

import org.codehaus.jackson.JsonGenerationException;

import java.io.IOException;

/**
 * Interface for components converting objects. Each converter should support only one mime-type.
 */
public interface ObjectConverter {

    /**
     * Returns <code>true</code> if given component supports converting to specified
     * content-type.
     *
     * @param contentType content type which converter should support.
     * @return <code>true</code> if content-type is supported, otherwise <code>false</code>.
     */
    boolean supportsType(String contentType);

    /**
     * Performs object conversion to supported type.
     *
     * @param target object to convert.
     * @return serialization result.
     */
    String convert(Object target) throws IOException;

}
