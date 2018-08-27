package java8_examples;

import lombok.Lombok;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class ListUtil {

    @SneakyThrows
    public static <T> void forEachWithDelay(List<T> list, int delay, Action<T> action) {
        for (T t : list) {
            Thread.sleep(delay);
            action.doIt(t);
        }
    }


    public static <T> int countDuplicates(List<T> list, T t, Equalator<T> equalator) {

        int counter = 0;
        for (T t1 : list) {
            if (equalator.equals(t,t1)) {
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "JaVa", "JAVA", "scala", "groovy", "java");
        int counter = countDuplicates(strings, "java", (t1, t2) -> t1.length() == t2.length());

        System.out.println("counter = " + counter);
        forEachWithDelay(strings, 5, s -> {
            System.out.println(s);
        });

        System.out.println("********************");
        Stream<String> stream = strings.stream().filter(s -> !s.startsWith("s"));
       stream = stream.filter(s->!s.startsWith("g"));
        stream.forEach(System.out::println);


    }









}
