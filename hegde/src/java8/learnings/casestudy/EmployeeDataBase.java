package java8.learnings.casestudy;

import java.util.Arrays;
import java.util.List;

public class EmployeeDataBase {

public static List getAllEmployees(){

Employee e1 = new Employee("Anant","Male",120000.55,
        Arrays.asList("swimming","cooking","movies"),123,"Mumbai","Accounts", 163);
Employee e2 = new Employee("Chand","Male",340000.89,
        Arrays.asList("jogging","cricket","reading","tennis"),53,"Delhi","IT",185);

    Employee e3 = new Employee("Geeta","Female",535670.5, Arrays.asList("podcasting","television",
            "cooking","snorkelling"),67,"Chennai","Food & Catering", 156);
    Employee e4 = new Employee("Devi","Female",780000.0, Arrays.asList("soccer","cooking","painting","singing"),
            89,"Faridabad","Telecom", 149);

    Employee e5 = new Employee("Zarina","Female",423568.93, Arrays.asList("reading","cooking","movies"),
            168,"Mumbai","Telecom", 171);
    Employee e6 = new Employee("Xavier","Male",740000.34,
            Arrays.asList("running","cricket","pilates","soccer"),5436,"Chennai","IT", 191);

    Employee e7 = new Employee("Pradeep","Male",671289.9,
            Arrays.asList("running","reading","cycling"),1839,"Bangalore","Security", 170);
    Employee e8 = new Employee("Tina","Female",33249.2,
            Arrays.asList("cooking","basketball","reading"),632,"Delhi","Medical", 142);

    Employee e9 = new Employee("Modde","LGBTQ",374567.0,
            Arrays.asList("dancing","singing","reading"),904,"Hyderabad","Marketing", 189);

    return Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9);

}
}
