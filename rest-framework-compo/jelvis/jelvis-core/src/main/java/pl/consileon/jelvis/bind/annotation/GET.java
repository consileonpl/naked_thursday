package pl.consileon.jelvis.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that annotated method should be bound to GET request for specified path.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GET {

    /**
     * Indicates the path to which method should be bound.
     *
     * @return path to bound.
     */
    String value() default ("/");

}
