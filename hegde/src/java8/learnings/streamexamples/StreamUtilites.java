package java8.learnings.streamexamples;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamUtilites {

    static final Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;

    public static void main(String[] args) {

        System.out.println(topThreeSalaryEmployees());
        System.out.println(bottomTwoSalaryEmployees());
        System.out.println(transgenderEmployee());
        System.out.println(salaryEmployee());
        System.out.println(allEmployee());
        System.out.println(generateSeries());
        System.out.println(generateRandom());
    }

    //use case 1 --- get the employee details for the 3 employees with top 3 salaries from the Employee DB.
    private static List<Employee> topThreeSalaryEmployees(){

        return supplier.get().stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                //limit function picks up the top 3 for us --- remaining stream is not processed
                .limit(3).collect(Collectors.toList());

    }


    //use case 2 --- get the employee details for the 2 employees with bottom 2 salaries from the employee DB.
    private static List<Employee> bottomTwoSalaryEmployees(){

        //here I am deliberately sorting in descending order so that I can use the skip() function to showcase how it is used

        if(supplier.get().size() < 1)return new ArrayList<>();

        //eliminate all employees except the bottom 2 employees ---- we use the skip function to do this
        long skipLimit = supplier.get().size() - 2; //using 2 here because we need bottom 2 salaried employees

        return supplier.get().stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                //skip function skips the elements specified by the limit for us --- and processes remaining stream
                .skip(skipLimit).collect(Collectors.toList());
    }

    //use case 3 ---- return true if any employee is a transgender
    private static Boolean transgenderEmployee(){

        final Set<String> genderSet = Set.of("Male","Female");

        //here we are creating a predicate --- transgender means neither male nor female -- we create predicate for that condition
         final Predicate<Employee> genderPred = (employee -> !genderSet.contains(employee.getGender()));

        return supplier.get().stream().anyMatch(genderPred);
    }

    //use case 4 ---- return true if none of the employees are below 100,000 salary
    private static Boolean salaryEmployee(){

        //here we are creating a predicate ---salary lower level 100,000 -- we create predicate for that condition
        final Predicate<Employee> salaryPred = (employee -> employee.getSalary() < 100000.0);

        return supplier.get().stream().noneMatch(salaryPred);
    }

    //use case 5 ---- return true if all employees belong to mumbai and earn more than 300,000
    private static Boolean allEmployee(){

        //Here we are creating a predicate --- mumbai residents
        Predicate<Employee> mumbaiResident = e -> e.getAddress().equalsIgnoreCase("mumbai");

        //here we are creating a predicate ---salary more than 300,000 --
        final Predicate<Employee> salaryPred = (employee -> employee.getSalary() > 300000.0);

        final Predicate<Employee> combinedPredicate = mumbaiResident.and(salaryPred);

        return supplier.get().stream().allMatch(combinedPredicate);
    }


    //use case 6 ---- generate a stream of 1000 random integers and find the sum of all positive even integers in the stream
    //Generate the stream only for positive random integers
    private static Integer generateRandom(){

        //we will use generate() to create the stream of random integers
        //we will use limit() to get 1000 numbers and then map them to check for even integers
        //We will use reduce() to get the sum total of all even integers generated.

        //number modulo 2 = 0 means number is an even number
        final Predicate<Integer> evenPredicate = (num) -> num % 2 == 0;
        //supplier that supplies the random integer --- only positive values are considered
        final Supplier<Integer> supplier = StreamUtilites::generateRandomInt;

        //get only even integers and return the total
        return Stream.generate(supplier).limit(1000).filter(evenPredicate).reduce(0, Integer::sum);
    }

    //generate a random integer
    private static Integer generateRandomInt(){
        return new Random().nextInt(0,99999);
    }

    //use case 7 --- generate a series of first 100 multiples of 7 and find their product....The series will be be 7,14,21...etc.
    private static List<Long> generateSeries(){

        //The seed value is 7
        long seed = 7L;

        //list of 7 series
        List<Long> series = Stream.iterate(seed, a -> a+seed).limit(100).collect(Collectors.toList());

        //find the product using limit and reduce
       Double prod = Stream.iterate(7.0, a -> a+seed).limit(100).reduce(1.0, (a, b) -> a * b);

        System.out.println("Product is "+ prod);

        return series;
    }

}

/*

limit(X) --- limits the "X" number of elements to be processed in the stream.
skip(X) --- skips the "X" number of elements from the stream.
anyMatch(),allMatch(),noneMatch() --- take predicates as input and produce boolean result
anyMatch() --- returns true if any one of the item in the stream matches the predicate or else returns false.
allMatch() --- returns true if all the items in the stream match the predicate or else returns false.
noneMatch() --- returns true if none of the items in the stream match the predicate or else returns false.

TBD
 //use case 6 --- findFirst() -- returns first element in the stream

    // use case 7 --- findAny() -- returns the first encountered element in the stream

* */