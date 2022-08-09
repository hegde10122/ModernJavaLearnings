package java8.learnings.streamexamples;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MoreStreams2 {

    //supplier to get employees list
    static final Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;

    static final Predicate<Employee> genderPredicate = (employee) -> employee.getGender().equalsIgnoreCase("male");
    private static final List<String> cities = Arrays.asList("Chennai","Mumbai");
    static final Predicate<Employee> addressPredicate = (employee -> cities.contains(employee.getAddress()));

    public static void main(String[] args) {

        //System.out.println(reverseAddressStudents());
      //  System.out.println(filteredEmployees());

        System.out.println(meanSalary());
    }


    //Use case 3 ---- get the mean of all salaries
    private static Double  meanSalary(){

      Double initial = 0.0;

      //stream of values ---> mapped according to salary and then reduced to a single value by the sum function
      Double total = supplier.get().stream().
        map(Employee::getSalary).reduce(initial, Double::sum); //initial is the seed value for sum which is 0.0

      if(supplier.get().size() == 0)return initial;

      return total / supplier.get().size(); //mean is total salary divided by the total number of employees
    }

    //Use case 2 ---- get all male employees residing in Mumbai or Chennai
    private static List<Employee> filteredEmployees(){

        return supplier.get().stream().
                filter(genderPredicate).
                filter(addressPredicate)
                .collect(Collectors.toList());
    }


    //use case 1 ---- sort all employees in descending order of addresses
    private static List<Employee> reverseAddressStudents(){

        return supplier.get().stream().
                sorted(Comparator.comparing(Employee::getAddress).reversed()). //reversed() gives descending order
                collect(Collectors.toList());

    }

}
