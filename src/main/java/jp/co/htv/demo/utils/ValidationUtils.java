package jp.co.htv.demo.utils;

import java.util.stream.Stream;

/**
 * Validation Utility Class.
 * 
 * @author hainp
 *
 */
public class ValidationUtils {

    /**
     * Utility classes should not have public constructors.
     */
    private ValidationUtils() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * Check for duplicate in array.
     * 
     * @param <T> boolean
     * @param array input array
     * @return
     */
    public static <T> boolean checkForDuplicates(T[] array) {
        Long distinctCount = Stream.of(array).distinct().count();

        return array.length != distinctCount;
    }
}
