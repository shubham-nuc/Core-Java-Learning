package java8.mockdata.model.employee;

import java.util.Objects;
import java.util.StringJoiner;

public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final String salary;
    private final String department;


    public Employee(int id, String firstName, String lastName, String email, String gender, String salary, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
        this.department = department;
    }

    public int id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }

    public String gender() {
        return gender;
    }

    public Double salary() {
        if (salary != null) return Double.valueOf(salary.replace("$", ""));
        return null;
    }

    public String department() {
        return department;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("email='" + email + "'")
                .add("gender='" + gender + "'")
                .add("salary='" + salary + "'")
                .add("department='" + department + "'")
                .toString();
    }

    public static boolean isMale(Employee emp){
        return emp.gender()!=null && Objects.equals(emp.gender(), "Male");
    }
}
