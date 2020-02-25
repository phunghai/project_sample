package jp.co.htv.demo.utils;

import java.util.stream.Stream;

public class ValidationUtils {
    
    /**
     * Check for duplicate in array.
     * @param <T>
     * @param array
     * @return
     */
    public static <T> boolean checkForDuplicates(T[] array)
    {
        Long distinctCount = Stream.of(array).distinct().count();

        return array.length != distinctCount;
    }
}
