package java8.learnings.functionalinterface;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerCombo {

    //using combination of consumer and predicate
    //Use case below ---
    // We want to find names of all male employees and list their hobbies who stay in any of these four Metro cities ---
    // Chennai,Mumbai,Delhi or Kolkata

    //Step 1: predicate for male employees
    private static final Predicate<Employee> predGender = (employee -> employee.getGender().equals("Male"));

    //Step 2 : predicate for employees who stay in the four aforementioned metro cities

    private static final List<String> metroCities = Arrays.asList("Chennai","Mumbai","Delhi","Kolkata");
    private static final Predicate<Employee> metroPred = (employee -> metroCities.contains(employee.getAddress()));

    //step 3 : Biconsumer to display employee names and hobbies who satisfy step 1 and step 2 predicates
    private  static final BiConsumer<String,List<String>> biConsumer = (name,hobbies) -> System.out.println(name +" :: " +hobbies);

    private static final List<Employee> employeeList = EmployeeDataBase.getAllEmployees();

    // Another use case --- We want to display names and salaries of all employees who are fond of cricket or cooking but do not stay in Mumbai.
    //Here we use BiPredicate
    private static final BiPredicate<List<String>,String> hobbiesMumbaiPred = (hobby, address) -> (hobby.contains("cricket") || hobby.contains("cooking")) && !address.equals("Mumbai");


    private static final BiConsumer<String,Double> salNamesConsumer = (name,salary) -> System.out.println(name +" :: "+salary);

    public static void main(String[] args) {
        displayMaleHobbiesMetros();
        displayCricketCookingLovers();
    }

    //method for the use case
    private static void displayMaleHobbiesMetros() {

        System.out.println(" :: displayMaleHobbiesMetros");

        //we define the consumer which filter all male employees based on the two predicates and passes the employees to the
        //bi consumer variable
        Consumer<Employee>  males = (employee -> {

            if(predGender.and(metroPred).test(employee))
                biConsumer.accept(employee.getName(),employee.getHobbies());
        });

        employeeList.forEach(males);

        System.out.println();
    }

    private static void displayCricketCookingLovers(){
        System.out.println(" :: displayCricketCookingLovers() ");

        //We define the consumer that filters all employees who are fond or cricket or cooking but do not saty in Mumbai using the bi predicate
        //Such employees which pass the bi predicate filter are consumed by the biconsumer that displays their names and salaries

        Consumer<Employee> employeeConsumer = (employee ->  {

            if(hobbiesMumbaiPred.test(employee.getHobbies(),employee.getAddress()))
                salNamesConsumer.accept(employee.getName(),employee.getSalary());

        });

        employeeList.forEach(employeeConsumer);
    }




}
