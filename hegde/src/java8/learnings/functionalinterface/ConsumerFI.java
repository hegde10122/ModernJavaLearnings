package java8.learnings.functionalinterface;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.List;
import java.util.function.Consumer;

//FI -- short form for Functional Interface
public class ConsumerFI {

    // get names of employees --- consumer defined
   private static final Consumer<Employee> consumer = (employee -> {
        System.out.println(employee.getName());
    });

    // get hobbies of employees --- consumer defined
   private static final Consumer<Employee> consumer2 = (employee -> {
        System.out.println(employee.getHobbies());
    });

    // get the list of employees from database
  private static final List<Employee> employeeList = EmployeeDataBase.getAllEmployees();


    public static void main(String[] args) {

        //We are creating a consumer functional interface that accepts an integer input and prints twice of that integer
        Consumer<Integer> c1 = (num) -> System.out.println(num * 2);

        //pass an input to this consumer variable and run this program to see the output in the console--u will see 200 !!
        c1.accept(100);

        //use case 1
        displayNames();

        //use case 2
        displayNamesAndHobbies();

        //use case 3
        displayNamesFemalesSalary();

    }


/*
* Display names and activities of all female employees whose salary exceeds 45000
* */
    private static void displayNamesFemalesSalary() {

        System.out.println("displayNamesFemalesSalary() method use case");

        employeeList.forEach( (emp) -> {
            if( emp.getGender().equals("Female") && emp.getSalary()>45000.0) {
                consumer.andThen(consumer2).accept((Employee) emp);
            }
        });


    }

    /*
      * Use case ---- print names and hobbies of all employees in the database using the Consumer Functional interface
    * */
    private static void displayNamesAndHobbies() {

        System.out.println("displayNamesAndHobbies() method use case");

        //step 1: get names and hobbies using consumer chaining concept --- andThen method defined in the consumer interface helps us to solve this use case
        employeeList.forEach(consumer.andThen(consumer2));

    }

    private static void displayNames(){
        //Use case ---- print names of all employees in the database using the Consumer Functional interface

        System.out.println("displayNames() method use case");

        //step 2: forEach method accepts a consumer interface
        employeeList.forEach(consumer);
    }
}
