package java8_examples.streams;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Evgeny Borisov
 */
public class CountWordsMain {
    @SneakyThrows
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new FileReader("data/song.txt"));
        Stream<String> lines = reader.lines();


        lines.map(String::toLowerCase)
                .flatMap(line -> Arrays.stream(line.split("\\W+")))
                .collect(groupingBy(word -> word, counting()))
                .entrySet().stream().sorted(comparingByValue(reverseOrder()))
                .forEach(System.out::println);

    }
}
