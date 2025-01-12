package java8.streams.operations;

import com.google.common.collect.ImmutableList;
import java8.mockdata.MockData;
import java8.mockdata.model.car.Car;
import java8.mockdata.model.employee.Employee;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FilterTest {

    @Test
    void filter1() throws IOException {
        List<Employee> employees = MockData.getEmployees();
        System.out.println("Total = "+employees.size());
        Stream<Employee> filteredEmployee = employees.stream().filter(Employee::isMale);
        System.out.println("Male = "+filteredEmployee.count());
    }

    @Test
    void filter2() throws IOException {
        List<Employee> employees = MockData.getEmployees();
        System.out.println("Total = "+employees.size());
    Stream<Employee> filteredEmployee =
        employees.stream()
            .filter(Employee::isMale)
            .filter(employee -> Objects.equals(employee.department(), "Human Resources"));
        System.out.println("Male in HR = "+filteredEmployee.count());
    }

    @Test
    void filterUsingInstanceMethod() throws IOException {
        ImmutableList<Car> cars = MockData.getCars();
        Stream<Car> carStream = cars.stream().filter(Car::instanceMethodMaker);
        System.out.println("Filtered Car = "+carStream.count());

    }

    @Test
    void filterUsingIStaticMethod() throws IOException {
        ImmutableList<Car> cars = MockData.getCars();
        Stream<Car> carStream = cars.stream().filter(Car::staticMethodMaker);
        System.out.println("Filtered Car = "+carStream.count());
    }
}
