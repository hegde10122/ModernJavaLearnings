package java8.learnings.streamexamples;

import java8.learnings.casestudy.Employee;
import java8.learnings.casestudy.EmployeeDataBase;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MapFilterReducePattern {

    public static void main(String[] args) {

        //use case 1 ---- find the highest salaried female employee
        //to create this  we require filter ---  all female employees
        //then we map their salaries
        //reduce to find highest salary

        System.out.println(salary());

    }

    private static Double salary() {

        return supplier.get().stream().filter(genderPredicate).
                map(Employee::getSalary).reduce(-1.0,(a,b) -> a > b ? a : b);
    }

    static final Supplier<List<Employee>> supplier = EmployeeDataBase::getAllEmployees;
    static final Predicate<Employee> genderPredicate = (employee) -> employee.getGender().equalsIgnoreCase("female");


}
