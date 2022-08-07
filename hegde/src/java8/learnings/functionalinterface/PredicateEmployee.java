package java8.learnings.functionalinterface;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateEmployee {

    //employees who are females
   private static final Predicate<Employee> genderPred = (employee -> employee.getGender().equals("Female"));

   //employees whose salary is not more than 300,000
  private static final Predicate<Employee> salaryPred = (employee ->  employee.getSalary()<=300000.0);

    //List of employees
  private static final List<Employee> employeeList = EmployeeDataBase.getAllEmployees();


    public static void main(String[] args) {

       displayFemaleSalaryEmployees();
        displayMaleSalaryEmployees();
    }

    /*
    * Use case --- display all female employees whose salary is not more than 300,000.
    *
    * */

    private static void displayFemaleSalaryEmployees(){

        System.out.println("displayFemaleSalaryEmployees ::");

        employeeList.forEach(employee -> {

            if(genderPred.and(salaryPred).test(employee))
            System.out.println(employee.getName());
        });
    }

    /*
     * Use case --- display all male employees whose salary is more than 300,000.
     *
     * */

    private static void displayMaleSalaryEmployees(){

        System.out.println("displayMaleSalaryEmployees ::");

        //negate of genderPred gives males
        //negate of salaryPred gives employees whose salary is more than 300,000.
        //We take the and condition for testing each employee in the Database

        employeeList.forEach(employee -> {
            if(genderPred.negate().and(salaryPred.negate()).test(employee))
                System.out.println(employee.getName());
        });

    }


}
