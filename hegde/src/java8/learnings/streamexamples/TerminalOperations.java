package java8.learnings.streamexamples;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TerminalOperations {

    static final Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;

    public static void main(String[] args) {

        System.out.println(problem1());
        System.out.println(problem2());
        System.out.println(problem3());
        System.out.println(problem4());
        System.out.println(problem5().isPresent() ? problem5().get() : "Nothing to display");
        System.out.println(problem6().isPresent() ? problem6().get() : "Nothing to display");
        System.out.println(problem7());
    }

    private static double problem7() {

        //problem ---- return the average height of the male employees
        return supplier.get().stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("male"))
                .collect(Collectors.averagingDouble(Employee::getHeightCms));
    }

    private static Optional<Employee> problem6() {

        //problem --- return employee  who has the highest salary --- we use maxBy() and the compartor
        return supplier.get().stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
    }

    private static Optional<Employee> problem5() {

        //problem --- return employee name who has the least height --- we use minBy and the comparator
        return supplier.get().stream().collect(Collectors.minBy(Comparator.comparing(Employee::getHeightCms)));
    }

    private static List<String> problem4() {

        //map the names in a list
        List<String> nameList = supplier.get().stream().collect(Collectors.mapping(Employee::getName,Collectors.toList()));

        return nameList;
    }

    private static long problem3() {

        //problem --- count the total employees using counting()
        return supplier.get().stream().collect(Collectors.counting());
    }

    private static String problem2() {

        //same as problem 1 --- but with prefix and suffix added
        return supplier.get().stream().map(Employee::getName).collect(Collectors.joining(",","(",")"));

    }

    private static String problem1() {

        //problem ---- return all the names in the employee database separated by commas as a single string

        //comma --- delimiter
       return supplier.get().stream().map(Employee::getName).collect(Collectors.joining(","));

    }
}
