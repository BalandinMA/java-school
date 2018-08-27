package java8_examples.streams;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class CountWordsMain {
    @SneakyThrows
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new FileReader("data/song.txt"));
        Stream<String> lines = reader.lines();

        HashMap<String, Integer> map = new HashMap<>();


        OptionalDouble average = lines.flatMap(line -> Arrays.stream(line.split("\\W+"))).mapToInt(String::length).average();
        System.out.println("average.getAsDouble() = " + average.orElse(0));
    }
}
