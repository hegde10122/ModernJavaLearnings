package java8.learnings.functionalinterface;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierFI {

    public static void main(String[] args) {

        //Supplier is just opposite to the Consumer. Supplier returns some output but does not take any output.
        Supplier<Employee> supplier =  () -> new Employee("Bhavani","Female",140000.9, Arrays.asList("golf","scuba diving","knitting"),
             834,"Jammu","Chemicals", 146);

        System.out.println("Employee is "+supplier.get());

        //Supplier
        Supplier<List<Employee>> supplier1 = () -> EmployeeDataBase.getAllEmployees();

        System.out.println("List is "+supplier1.get());

    }
}
