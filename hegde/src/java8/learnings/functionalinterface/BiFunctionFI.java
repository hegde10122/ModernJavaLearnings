package java8.learnings.functionalinterface;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionFI {

    //Bifunction functional interface accepts two inputs and produces an output
    // in this use case we accept a list of employees and a predicate to produce a hashmap of employe names as keys
    // and their salaries as values.
   private static final BiFunction<List<Employee>, Predicate<Employee>, Map<String,Double>>
            bifunction = ((employees, employeePredicate) -> {

            Map<String,Double> nameSalaryMap = new HashMap<>();

            employees.forEach(employee -> {
                if(employeePredicate.test(employee)) //test the employee as per the predicate
                    nameSalaryMap.put(employee.getName(),employee.getSalary());
            });

        return nameSalaryMap;
    });

    public static void main(String[] args) {

        List<Employee> list = EmployeeDataBase.getAllEmployees();

        //Predicate --- only consider employees whose salary is more than 400,000
        final Predicate<Employee> salaryPred = (employee ->  employee.getSalary()> 400000.0);

        //So we pass a list of employees and salary predicate as inputs to the bifunction which produces the hashmap as the result
        System.out.println(bifunction.apply(list,salaryPred));

    }
}
