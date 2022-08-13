package java8.learnings.streamexamples;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GroupByExamples {

   static final Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;

    public static void main(String[] args) {

        problem1();
        problem2();
        problem3();
        problem4();
         problem5();
        problem6();

    }

    private static void problem1() {

        //group employees by name
        Map<String,List<Employee>> employeeMap = supplier.get().stream().collect(Collectors.groupingBy(Employee::getName));

        System.out.println(employeeMap);
    }

    private static void problem2() {

        //group employees by three categories --- SHORT --- height less than 150cm.
        // MEDIUM -- height between 150cm and 170cm. TALL - greater than 170cms.
        //this is customised groupingBy
        Map<String,List<Employee>> employeeMap = supplier.get().stream().collect(Collectors.groupingBy(employee -> {

            if (employee.getHeightCms() < 150) {
                return "SHORT";
            } else if(employee.getHeightCms() >= 150 && employee.getHeightCms() <=170){
                return "MEDIUM";
            }else {
                return "TALL";
            }
        }));

        System.out.println(employeeMap);
    }

    //two-level grouping
    private static void problem3() {

        //group employees by address and do another grouping by height as in problem2 --- tall,medium and short
        Map<String,Map<String,List<Employee>>> employeeMap = supplier.get().stream().

                collect(Collectors.groupingBy(Employee::getAddress, //first level grouping --- by address
                        Collectors.groupingBy(employee -> { //second level grouping --- by height
                    if (employee.getHeightCms() < 150) {
                        return "SHORT";
                    } else if(employee.getHeightCms() >= 150 && employee.getHeightCms() <=170){
                        return "MEDIUM";
                    }else {
                        return "TALL";
                    }
                })));

        System.out.println(employeeMap);
    }


    //three-argument grouping
    private static void problem4() {

        //group employees by address and do another grouping by height as in problem2 --- tall,medium and short
      LinkedHashMap<String, Set<Employee>>  employeeMap = supplier.get().stream().
                collect(Collectors.groupingBy(Employee::getName, //first level grouping --- by name (key)
                        LinkedHashMap::new,Collectors.
                                toSet())); //determines the type of output  -- LinkedHashMap
                                           //output returned as a set

        System.out.println(employeeMap);
    }

    private static void problem5() {

        //provide the highest salaried employee for each gender ---- key is the gender while value is the employee details with highest salary
        //collectingAndThen -- removes the Optional wrapper returned by maxBy
        Map<String, Employee> employee = supplier.get().stream().
                collect(Collectors.groupingBy(Employee::getGender, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),Optional::get)));

        System.out.println(employee);
    }

    private static void problem6() {

        //provide the partitioning of all employees as true --- for all employees residing in Delhi and false ---- non-Delhi employees

        final Predicate<Employee> metroPredicate = employee -> employee.getAddress().equalsIgnoreCase("delhi");

        Map<Boolean, List<Employee>> employeeMap = supplier.get().stream().
                collect(Collectors.partitioningBy(metroPredicate,Collectors.toList()));

        System.out.println(employeeMap);
    }

}
