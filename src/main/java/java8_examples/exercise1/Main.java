package java8_examples.exercise1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee("junior", "Ivan1"));
        employeeList.add(new Employee("junior", "Ivan2"));
        employeeList.add(new Employee("middle", "Ivan3"));
        employeeList.add(new Employee("middle", "Ivan4"));
        employeeList.add(new Employee("middle", "Ivan5"));
        employeeList.add(new Employee("senior", "Ivan6"));
        employeeList.add(new Employee("senior", "Ivan7"));
        employeeList.add(new Employee("senior", "Ivan8"));
        employeeList.add(new Employee("senior", "Ivan9"));

        Map<String, String> collect = employeeList.stream().collect(Collectors.toMap(Employee::getName, Employee::getSeniority));
//        collect.entrySet().stream().collect()

    }
}
