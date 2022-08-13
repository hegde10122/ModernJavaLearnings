package java8.learnings.optional;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Optionals {

    //define a list of optional employees ----
    // we can have a table with null values with non-existent employees in real case scenarios

    static final Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;
    static final Optional<List<Employee>> employeeList = Optional.ofNullable(EmployeeDataBase.getAllEmployees());


    public static void main(String[] args) {

        employeeList.ifPresent(System.out::println);

        System.out.println(ofNullable("Java programming"));
        System.out.println(ofNullable(null)); //Optional.empty is returned for null input values

        System.out.println(of("Android programming"));
       // System.out.println(of(null)); //Crash due to null pointer exception

        System.out.println(orElse(EmployeeDataBase.employeeSupplier.get()));
        System.out.println(orElse(null));

        System.out.println(orElseGet(EmployeeDataBase.employeeSupplier.get()));
        System.out.println(orElseGet(null));

        System.out.println(orElseThrow(EmployeeDataBase.employeeSupplier.get()));
       // System.out.println(orElseThrow(null)); //throws runtimeexception here

         findFirst();
         findAny();
         filterInOptional();
         filterMapInOptional();


    }

    private static void filterMapInOptional() {
        Optional<Employee> findEmp =  Optional.ofNullable(EmployeeDataBase.employeeSupplier.get());

        //here we get the employee Object and then we again apply the filter and map operations to get the department of the employee found

        if(findEmp.isPresent()){
            Optional<String> stringOptional = findEmp.
                    filter(employee -> employee.getAddress().equalsIgnoreCase("bhopal")).
                    map(Employee::getDepartment);

            System.out.println(stringOptional.get());

        }
    }

    private static void filterInOptional() {

        Optional<Employee> find =  Optional.ofNullable(EmployeeDataBase.employeeSupplier.get());
        find.filter(employee -> employee.getHeightCms() > 150).ifPresent(System.out::println);
    }

    private static void findAny() {

        //findAny() --- returns the first encountered element in the stream
      Optional<Employee> find =  supplier.get().stream().filter(employee -> employee.getHeightCms() < 150).findAny();

         find.ifPresent(System.out::println);
    }

    private static void findFirst() {

        //findFirst() --- returns first element in the stream

        Optional<Employee> find =  supplier.get().stream().filter(employee -> employee.getHeightCms() > 150).findFirst();

        find.ifPresent(System.out::println);
        
    }


    private static String orElseThrow(Employee input){
        Optional<Employee> employee = Optional.ofNullable(input);

        return employee.map(Employee::getName).orElseThrow(() -> new RuntimeException("Nothing to show or throw!!"));
    }

    //just like orElse() but for null values it returns a supplier
    private static String orElseGet(Employee input){
        Optional<Employee> employee = Optional.ofNullable(input);

        return employee.map(Employee::getName).orElseGet(() -> "Value is null supplier");
    }

    //we use orElse for null values
    private static String orElse(Employee input){

        Optional<Employee> employee = Optional.ofNullable(input);

       return employee.map(Employee::getName).orElse("Value is null");

    }

    //we use ofNullable method when the input could be valid or null
    private static Optional<String> ofNullable(String input){
        return Optional.ofNullable(input);
    }

    //We use of() method when the input is never null. If by chance the input is null, then Optional.of() would cause a crash
    private static Optional<String> of(String input){
        return Optional.of(input);
    }


}
