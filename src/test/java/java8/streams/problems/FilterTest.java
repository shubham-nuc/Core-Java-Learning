package java8.streams.problems;

import java8.mockdata.MockData;
import java8.mockdata.model.person.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Intermediate Operations
 * 1. Filter -
 * 2. Peek -
 */
class FilterTest {

    /**
     *
     * Find Persons with age greater than 18
     */
    @DisplayName("Find Persons with age greater than 18")
    @Test
    void personAgeGreaterThan18() throws IOException {
        var persons=MockData.getPersons();
        List<Person> youngPerson = persons.stream().filter(it -> it.getAge() >= 18).toList();
        youngPerson.forEach(System.out::println);
    }

    /**
     *
     * Find 10 Persons with age greater than 18
     */
    @DisplayName("Find Persons with age greater than 18")
    @Test
    void TenPersonAgeGreaterThan18() throws IOException {
        var persons=MockData.getPersons();
        List<Person> youngPerson = persons.stream().filter(it -> it.getAge() >= 18).limit(10).toList();
        youngPerson.forEach(System.out::println);
    }

    @Test
    void testPeek(){
        List<String> fruits = Arrays.asList("Apple", "Banana", "Bherry", "Date", "Fig");
        fruits.stream().filter(it->it.startsWith("B"))
                .peek(fruit -> System.out.println("Filtered Fruit: " + fruit))
                .map(String::toUpperCase)
                .peek(uppercasedFruit -> System.out.println("Uppercased Fruit: " + uppercasedFruit))
                .forEach(each->System.out.println("For Each Fruit: " + each));
    }
}