package java8.mockdata;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.gson.reflect.TypeToken;
import java8.mockdata.model.Fruit;
import java8.mockdata.model.car.Car;
import java8.mockdata.model.employee.Employee;
import java8.mockdata.model.person.Person;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;

public class MockData {

    public static List<Person> getPersons() throws IOException {
        InputStream inputStream = Resources.getResource("people.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Person>>() {}.getType();
        List<Person> people = new Gson().fromJson(json, listType);
        var personList= List.copyOf(people);
        return personList;
        //return ImmutableList.copyOf(people);
    }

    public static ImmutableList<Car> getCars() throws IOException {
        InputStream inputStream = Resources.getResource("cars.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Car>>() {
        }.getType();
        List<Car> cars = new Gson().fromJson(json, listType);
        return ImmutableList.copyOf(cars);
    }

    public static List<Employee> getEmployees() throws IOException {
        InputStream inputStream = Resources.getResource("employee.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Employee>>() {
        }.getType();
        List<Employee> employees = new Gson().fromJson(json,listType);
        return List.copyOf(employees);
    }

    public static List<Fruit> getFruits(){
        return Arrays.asList(
                new Fruit("apple", 10, new BigDecimal("9.99")),
                new Fruit("banana", 20, new BigDecimal("19.99")),
                new Fruit("orange", 10, new BigDecimal("29.99")),
                new Fruit("watermelon", 10, new BigDecimal("29.99")),
                new Fruit("papaya", 20, new BigDecimal("9.99")),
                new Fruit("apple", 10, new BigDecimal("9.99")),
                new Fruit("banana", 10, new BigDecimal("19.99")),
                new Fruit("apple", 20, new BigDecimal("9.99"))
        );
    }
}
