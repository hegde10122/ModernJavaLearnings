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

        //define a hashmap to satisfy the use -- names and addresses are both of string types
        HashMap<String,String> nameAddressMap = new HashMap<>();

        //employees --- list which as the input of the function
        employees.forEach((employee -> {
            //For each employee from the list we create the output which is the hashmap
            nameAddressMap.put(employee.getName(),employee.getAddress());
        }));

        //function accepts input --- list of employess in this use case and returns hashmap in this use case as the output.
        return nameAddressMap;
    });

    public static void main(String[] args) {

        //apply method of the function accepts the list of employees as the input
        System.out.println(function.apply(EmployeeDataBase.getAllEmployees()));

    }
}
