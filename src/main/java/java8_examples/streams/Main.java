package java8_examples.streams;

import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5).map(integer -> {
            throw new RuntimeException("bla");
        }).forEach(System.out::println);
    }
}
