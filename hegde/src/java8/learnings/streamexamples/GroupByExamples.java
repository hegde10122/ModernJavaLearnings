package java8.learnings.streamexamples;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GroupByExamples {

   static final Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;

    public static void main(String[] args) {

        problem1();

    }

    private static void problem1() {

        //group employees by name
        Map<String,List<Employee>> employeeMap = supplier.get().stream().collect(Collectors.groupingBy(Employee::getName));

        System.out.println(employeeMap);
    }


}
