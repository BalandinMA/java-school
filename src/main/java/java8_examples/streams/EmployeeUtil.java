package java8_examples.streams;

import org.w3c.dom.ranges.Range;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author Evgeny Borisov
 */
public class EmployeeUtil {


    public static Map<Seniority, List<Employee>> mapBySeniority(List<Employee> employees) {
        return employees.stream().collect(groupingBy(emp -> Seniority.findBySalary(emp.getSalary())));
    }

    public static Map<String, Integer> getNameVsSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary,
                (salary1, salary2) -> salary1 + salary2));
    }


    public static int totalSalary(List<Employee> employees) {
        Optional<Integer> optional = employees.stream().map(Employee::getSalary).reduce(Integer::sum);
        return optional.orElse(0);
    }

    public static int totalSalary2(List<Employee> employees) {
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }

    public static String joinNamesToText(List<Employee> employees) {
        return employees.stream().map(Employee::getName).reduce((s, s2) -> s + "," + s2).orElse("");
    }

    public static String joinNamesToTextEffective(List<Employee> employees) {
        return employees.stream().map(Employee::getName).collect(Collectors.joining(","));
    }

}






