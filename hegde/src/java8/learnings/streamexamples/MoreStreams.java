package java8.learnings.streamexamples;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MoreStreams {

    //supplier to get employees list
    static final Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;

    private static Set<String> departmentList(){

        //Use case 2 --- get the list of departments in uppercase for all employees. remove duplicates if necessary
        Set<String> addresses = supplier.get().stream().
                map(Employee::getDepartment). //get the departments for every employee using mapping
                map(String::toUpperCase) //map to the uppercase for every department
                .collect(Collectors.toSet());

        //Set means all duplicates are removed
        return addresses;
    }

    private static List<String> addressList(){


        //Use case 1 --- get the list of addresses from the employee database for all employees -- use map() function
        return supplier.get().stream(). //get the stream of employees
                map(Employee::getAddress). //get the list of addresses using map function
                collect(Collectors.toList());


    }

    private static List<String> allHobbiesList(){

        //Use case 3 --- print all hobbies of all employees as a cumulative list.
        return supplier.get().stream(). //stream of employees
                map(Employee::getHobbies). //stream of list of hobbies (strings)
                flatMap(List::stream). //create a stream of strings -- flattened the stream
                collect(Collectors.toList());
    }


    //distinct() method application
    private static List<String> allHobbiesListUnique(){

        //Use case 4 --- print all hobbies of all employees as a cumulative list. remove duplicates
        return supplier.get().stream(). //stream of employees
                map(Employee::getHobbies). //stream of list of hobbies (strings)
                flatMap(List::stream). //create a stream of strings -- flattened the stream
                distinct(). //remove duplicates to get a list of unique elements --- order maintained
                collect(Collectors.toList());
    }

    //count() method application
    private static long allHobbiesListCount(){

        //Use case 5 --- print total hobbies of all employees  without considering duplicates
        return supplier.get().stream(). //stream of employees
                map(Employee::getHobbies). //stream of list of hobbies (strings)
                flatMap(List::stream). //create a stream of strings -- flattened the stream
                distinct(). //remove duplicates to get a list of unique elements --- order maintained
                count();
    }

    //sorted() method application
    private static List<String> allHobbiesListSorted(){

        //Use case 6 --- print total hobbies of all employees  without considering duplicates
        return supplier.get().stream(). //stream of employees
                map(Employee::getHobbies). //stream of list of hobbies (strings)
                flatMap(List::stream). //create a stream of strings -- flattened the stream
                distinct(). //remove duplicates to get a list of unique elements --- order maintained
                sorted().collect(Collectors.toList());
    }


    //comparator sorted( method application)
    private static List<Employee> allStudentsSortedSalary(){

        //Use case 7 --- sort all employees by their salaries in ascending order starting from lowest to highest
        return supplier.get().stream(). //stream of employees
                sorted(Comparator.comparing(Employee::getSalary)).
                collect(Collectors.toList());
    }




    public static void main(String[] args) {

        //7 use cases in this java class
        System.out.println(addressList());
        System.out.println(departmentList());
        System.out.println(allHobbiesList());
        System.out.println(allHobbiesListUnique());
        System.out.println(allHobbiesListCount());
        System.out.println(allHobbiesListSorted());
        System.out.println(allStudentsSortedSalary());
    }

}
