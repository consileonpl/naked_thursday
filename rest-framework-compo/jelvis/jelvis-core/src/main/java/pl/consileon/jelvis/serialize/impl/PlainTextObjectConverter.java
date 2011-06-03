package pl.consileon.jelvis.serialize.impl;

import pl.consileon.jelvis.serialize.ObjectConverter;

/**
 * Object converter supporting the <code>plain/text</code> type. This converter
 * performs trivial conversion invoking <code>toString()</code> method on the
 * converted object.
 */
public class PlainTextObjectConverter implements ObjectConverter {
    @Override
    public boolean supportsType(String contentType) {
        return contentType.contains("text/plain");
    }

    @Override
    public String convert(Object target) {
        return target.toString();
    }
}
