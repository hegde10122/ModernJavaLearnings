package java8.learnings.functionalinterface;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.List;
import java.util.function.Consumer;

//FI -- short form for Functional Interface
public class ConsumerFI {

    public static void main(String[] args) {

        //We are creating a consumer functional interface that accepts an integer input and prints twice of that integer
        Consumer<Integer> c1 = (num) -> System.out.println(num * 2);

        //pass an input to this consumer variable and run this program to see the output in the console--u will see 200 !!
        c1.accept(100);

        //use case 1
        displayNames();

        //use case 2
        displayNamesAndHobbies();

    }

    /*
      * Use case ---- print names and hobbies of all employees in the database using the Consumer Functional interface
    * */
    private static void displayNamesAndHobbies() {

        //Step 1: get names of employees
        Consumer<Employee> consumer = (employee -> {
            System.out.println(employee.getName());
        });

        //step 2: get hobbies of employees
        Consumer<Employee> consumer2 = (employee -> {
            System.out.println(employee.getHobbies());
        });

        //step 3: get the list of employees from database
        List employeeList = EmployeeDataBase.getAllEmployees();

        //step 4: get names and hobbies using consumer chaining concept --- andThen method defined in the consumer interface helps us to solve this use case
        employeeList.forEach(consumer.andThen(consumer2));

    }

    private static void displayNames(){
        //Use case ---- print names of all employees in the database using the Consumer Functional interface

        //step 1:
        List employeeList = EmployeeDataBase.getAllEmployees();

        //step 2: define a consumer variable
        Consumer<Employee> c1 = (emp) -> System.out.println(emp.getName());

        //forEach method accepts a consumer interface
        employeeList.forEach(c1);
    }
}
