package java8_examples;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class ListUtil {
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
    }









}
