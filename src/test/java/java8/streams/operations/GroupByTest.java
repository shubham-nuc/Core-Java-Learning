package java8.streams.operations;

import java8.mockdata.MockData;
import java8.mockdata.model.Fruit;
import java8.mockdata.model.employee.Employee;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupByTest {

    /**
     * Normal Group by (accept only a Function)
     * select department,* from employee group by department
     */
    @Test
    void groupEmployeesBySalary() throws IOException {
        List<Employee> employees = MockData.getEmployees();
        Map<Double, List<Employee>> groupedEmployees = employees.stream()
                .filter(emp->emp.salary()!=null)
                .collect(Collectors.groupingBy(Employee::salary));
        System.out.println(groupedEmployees);
    }

    /**
     * Normal Group by (accept only a Function)
     *
     */
    @Test
    void groupEmployeesByDepartment() throws IOException {
        List<Employee> employees = MockData.getEmployees();
        Map<String, List<Employee>> groupedEmployees = employees.stream()
                .collect(Collectors.groupingBy(emp->emp.department()==null?"No Department":emp.department()));
        System.out.println(groupedEmployees);
    }

    /**
     * Level 1 Group By (accepting a Function and a Collector )
     * Perform aggregate function on group by
     * select department,count(*) from employee group by department
     */
    @Test
    void countEmployeesByGender() throws IOException {
        List<Employee> employees = MockData.getEmployees();
        var groupedEmployees= employees.stream()
                .collect(Collectors.groupingBy(emp->emp.gender()==null?"No Gender":emp.gender(),Collectors.counting()));
        System.out.println(groupedEmployees);
    }

    /**
     * Level 1 Group By (accepting a Function and a Collector )
     * Perform count aggregate function on group by
     * select department,count(*) from employee group by department
     */
    @Test
    void countEmployeesByDepartment() throws IOException {
        List<Employee> employees = MockData.getEmployees();
        var groupedEmployees= employees.stream()
                .collect(Collectors.groupingBy(emp->emp.department()==null?"No Department":emp.department(),Collectors.counting()));
        System.out.println(groupedEmployees);
    }

    /**
     * Level 1 Group By (accepting a Function and a Collector )
     * Perform sum aggregate function on group by
     * select name,sum(quantity) from fruits group by name
     */
    @Test
    void countAndSum(){
        List<Fruit> fruits=MockData.getFruits();
        Map<String, Integer> groupedFruits = fruits.stream()
                .collect(Collectors.groupingBy(Fruit::name, Collectors.summingInt(Fruit::qty)));
        System.out.println(groupedFruits);
    }

    /**
     * Level 1 Group By (accepting a Function and a Collector )
     * select name from employee group by department
     * It will group by employee and give comma seperated names
     */
    @Test
    void groupEmployeeByAge() throws IOException {
        List<Employee> employees = MockData.getEmployees();
        var groupedEmployees=employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department() == null ? "No Department" : emp.department(), Collectors.mapping(Employee::firstName, Collectors.toList())));
        System.out.println(groupedEmployees);
    }

    /**
     * Level 2 Group By (accepting a Function, a supplier and a Collector )
     * select name from employee group by department
     * It will group by department and put in tree map which maintain sorting
     */
    @Test
    void groupEmployeeByDepartmentSorted() throws IOException {
        List<Employee> employees = MockData.getEmployees();
        var groupedEmployees=employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department() == null ? "No Department" : emp.department(),TreeMap::new, Collectors.mapping(Employee::firstName, Collectors.toList())));
        System.out.println(groupedEmployees);
    }

}
