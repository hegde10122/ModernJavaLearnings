package java8.learnings.interfaces;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MethodExamples {

    public static void main(String[] args) {

        sorting();
      sortHeights();
       sortSalaries();

        comparatorChaining();
    }

    //List of employees to be sorted using addresses followed by heights
    private static void comparatorChaining() {

        //use the supplier to get employees
        List<Employee> employees = supplier.get();

        employees.sort(addressComparator.thenComparing(heightComparator));
        System.out.println(employees);

    }

    //use case --- sort all employees with lowest salary starting first and return the list of employees
    private static void sortSalaries(){

        //use the supplier to get employees
        List<Employee> employees = supplier.get();

        //sort using the comparator interface on the basis of salaries--lowest to highest
        employees.sort(Comparator.comparing(Employee::getSalary));
        employees.forEach(System.out::println);

    }

    //use case ---- sort all employees with the tallest employee first and return that height value
    private static void sortHeights(){

        //use the supplier to get employees and map the heights before creating the List collection
        List<Integer> heights = supplier.get().stream().map(Employee::getHeightCms).
                sorted(Comparator.reverseOrder()).//since we require tallest height --- we reverse
                collect(Collectors.toList());

        System.out.println(heights);
        System.out.println("The tallest height (in cm) is : "+ heights.get(0));
    }

    //problem 1  --- sorting a list of integers using the sort() default method in the List interface
    private static void sorting(){

        long size = 20;
        int start = 1;
        int end = 53000;

        //generate a list of 20 integers between start and end using the Random() class and create a list
        List<Integer> arrayList = new Random().ints(size,start,end).boxed().collect(Collectors.toList());

        //sort using the default sort() method which uses comparator
        arrayList.sort(Comparator.naturalOrder());

        //print them
        System.out.println(arrayList);

    }

    //supplier to get employees list
    static final Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;

    //comparator to get employees height-wise
    static final Comparator<Employee> heightComparator = Comparator.comparing(Employee::getHeightCms);

    //comparator to get employees addresswise
    static final Comparator<Employee> addressComparator = Comparator.comparing(Employee::getAddress);

}
