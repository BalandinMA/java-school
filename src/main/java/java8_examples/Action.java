package java8_examples;

/**
 * @author Evgeny Borisov
 */
@FunctionalInterface
public interface Action<T> {
    void doIt(T t);
}
