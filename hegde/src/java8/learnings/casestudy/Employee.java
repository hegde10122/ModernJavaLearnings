package java8.learnings.casestudy;

import java.util.List;

public class Employee {

    private String name;
    private String gender;
    private Double salary;
    private List<String> hobbies;
    private int employeeID;
    private String address;
    private String department;

    public Employee(String name, String gender, Double salary,
                    List<String> hobbies, int employeeID,
                    String address, String department) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.hobbies = hobbies;
        this.employeeID = employeeID;
        this.address = address;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", hobbies=" + hobbies +
                ", employeeID=" + employeeID +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

/*
* Employee class containing various attributes defined for each employee.
* We have the constructor and the individual getter and setter methods.
* We will use this class as a part of a dummy database created for this case study.
*
* */

