package java8.learnings.functionalinterface;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MoreFunctions {

    //define a function that takes a list of employees as input and produces a hashmap containing names as keys
    // and addresses as values
    private static final Function<List<Employee>, Map<String,String>> function = (employees -> {

        HashMap<String,String> nameAddressMap = new HashMap<>();

        employees.forEach((employee -> {
            nameAddressMap.put(employee.getName(),employee.getAddress());
        }));

        return nameAddressMap;
    });

    public static void main(String[] args) {

        System.out.println(function.apply(EmployeeDataBase.getAllEmployees()));

    }
}
