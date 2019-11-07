package by.BSUIR.hotel.service;

/**
 * The interface Finder.
 *
 * @param <T> the type parameter
 */
public interface Finder<T> {
    /**
     * Is found boolean.
     *
     * @param obj   the obj
     * @param value the value
     * @return the boolean
     */
    boolean isFound(T obj, T value);
}
