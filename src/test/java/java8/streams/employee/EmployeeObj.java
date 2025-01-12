package java8.streams.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeObj {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public EmployeeObj(int id, String name, int age, long salary, String gender,
                    String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }

    public static List<EmployeeObj> getEmployees(){
        List<EmployeeObj> empList = new ArrayList<>();
        empList.add(new EmployeeObj(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new EmployeeObj(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new EmployeeObj(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new EmployeeObj(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new EmployeeObj(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new EmployeeObj(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new EmployeeObj(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new EmployeeObj(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new EmployeeObj(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
        return empList;
    }

    @Override
    public String toString() {
        return "EmployeeObj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

}
