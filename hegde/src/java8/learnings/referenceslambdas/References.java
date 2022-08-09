package java8.learnings.referenceslambdas;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class References {

    static Function<String,String> toLowerCase = (input) -> input.toLowerCase();

    //the same thing above we can write using method reference
    static Function<String,String> toLowerCaseReference = String::toLowerCase;

    //method reference for Consumer functional interface ----
    static Consumer<Employee> consumer = System.out::println;

    //method reference for Consumer interface --- here we are using this concepts for the Employee class
    //ClassName :: instanceMethodName
    static Consumer<Employee> consumer2 = Employee::printHobbies;

    //Supplier for the employees in the database as a list -- using method reference
    static final Supplier<List<Employee>> supplierList = EmployeeDataBase::getAllEmployees;

    public static void main(String[] args) {

        System.out.println(toLowerCase.apply("JAVA KOTLIN"));
        System.out.println(toLowerCaseReference.apply("SQL PROGRAMMING"));

        supplierList.get().forEach(consumer2);


    }
}
