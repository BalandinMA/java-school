package java8_examples.streams;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Evgeny Borisov
 */
public class BlackFridayMain {
    public static void main(String[] args) {
        int startYear = 1900;
        int endYear = 2020;
        LocalDate startDate = LocalDate.of(startYear, JANUARY, 13);
        LocalDate endDate = LocalDate.of(endYear, DECEMBER, 13);
        long numberOfMonths = ChronoUnit.MONTHS.between(startDate, endDate);
        Stream.iterate(startDate,date ->date.plusMonths(1))
                .limit(numberOfMonths)
                .filter(date->date.getDayOfWeek()==FRIDAY)
                .collect(groupingBy(LocalDate::getYear,counting()))
                .entrySet().stream().sorted(comparingByValue(reverseOrder()))
                .forEach(System.out::println);

    }
}
