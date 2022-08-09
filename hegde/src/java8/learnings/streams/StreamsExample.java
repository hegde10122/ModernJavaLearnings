package java8.learnings.streams;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamsExample {

    //create a supplier variable to get all employees from the database
    static Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;

    //define a bipredicate --- female employees who do not stay in Delhi
    static final BiPredicate<String,String> addressGenderPred = (address,gender) -> !address.equalsIgnoreCase("Delhi") && gender.equals("Female");

    //define a predicate --- employees who work in telecom department
    static final Predicate<Employee> telecomPredicate = (employee) -> employee.getDepartment().equals("Telecom");

    public static void main(String[] args) {

        //Use case is to create a map of employee names as keys and hobbies as values using stream

       Map<String,List<String>> listMap = supplier.get().stream(). // create a stream from the supplier output and use the Collectors class to create Map
               collect(Collectors.toMap(Employee::getName,Employee::getHobbies));

        System.out.println(listMap);

        //Use case 2 --- I want to get all female employees and their hobbies who are working in the telecom department but who do not belong to Delhi
        //Here we have three predicates --- 1) all female employees 2) All employees who do not belong to Delhi 3) Employees working in telecom department
        //We introduce a bipredicate addressGenderPred defined above...
        //We define a predicate telecomPredicate define above...

        //We do apply the streams API on the employees list obtained using the supplier
        //then we apply the bipredicate filter to get female employees who do not stay in delhi
        //then we apply the predicate filter to get employees working in telecom department
        //then we use the collect method to map the employees with their hobbies
        Map<String,List<String>> namesHobbiesMap = supplier.get().stream()
                .filter(employee -> addressGenderPred.test(employee.getAddress(), employee.getGender()))
                .filter(telecomPredicate)
                .collect(Collectors.toMap(Employee::getName,Employee::getHobbies));

        System.out.println(namesHobbiesMap);






    }
}
