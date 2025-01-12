package java8.streams.problems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class FibonacciExample {

  @Test
  void printFibonacciSeries() {
    Stream.iterate(new int[] {0, 1}, operand -> new int[] {operand[1], operand[0] + operand[1]})
        .peek(each -> System.out.println(each[0] + "-" + each[1]))
        .limit(10)
        .mapToInt(value -> value[0])
        .forEach(System.out::println);
  }

  @Test
  void findSquareRoot() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> square = numbers.stream().map(n -> n * n).toList();
    square.forEach(System.out::println);
  }

  @Test
  void findEven() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> even = numbers.stream().filter(n -> n % 2 == 0).toList();
    even.forEach(System.out::println);
  }

  @Test
  void findOdd() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> odd = numbers.stream().filter(n -> n % 2 != 0).toList();
    odd.forEach(System.out::println);
  }

  /** sum of square of even mumbers */
  @Test
  void findSumOfSquareOfEven() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    var sumEven =
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println("peek n=" + n))
            .mapToInt(n -> n * n)
            .peek(n -> System.out.println("peek n1=" + n))
            .sum();

    System.out.println(sumEven);
  }

  /** Check if a List Contains a Specific Element */
  @Test
  void checkForSpecificWord() {
    List<String> words = Arrays.asList("Python", "JavaScript", "Java", "C++");
    String wordToSearch = "Java";
    boolean matched = words.stream().anyMatch(it -> it.contentEquals(wordToSearch));
    System.out.println("Matched = " + matched);
  }

  /**
   * Find frequency of each character in a string using Java 8 streams It gives result in any order
   */
  @Test
  void eachCharacterFrequency() {
    String inputString = "programming is fun";
    Map<Character, Long> collect =
        inputString
            .chars()
            .mapToObj(o -> (char) o)
            .filter(ch -> !Character.isSpaceChar(ch))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(collect);

    Map<Long, String> collect1 =
        collect.entrySet().stream()
            .collect(
                Collectors.groupingBy(
                    Map.Entry::getValue,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list ->
                            list.stream()
                                .map(m -> m.getKey().toString())
                                .collect(Collectors.joining(",")))));
    System.out.println("collect1 = "+collect1);

    var out= Arrays.asList(inputString.split(" "));
    System.out.println(out);
    Collections.reverse(out);
    System.out.println("Collections.reverse = "+String.join(" ",out));

    var out1= Arrays.asList(inputString.split(" "));
    String collect2 = out1.stream().sorted((a, b) -> -1).collect(Collectors.joining(" "));
    System.out.println("collect2 = "+collect2);

    String collect3 = out1.stream()
            .collect(
                    Collectors.collectingAndThen(
                            Collectors.toList(),
                            list -> {
                              Collections.reverse(list);
                              return list;
                            })).stream().collect(Collectors.joining(" "));
    System.out.println("collect3 = "+collect3);
  }

  /**
   * Find frequency of each character in a string using Java 8 streams It gives result in any sorted
   * order
   */
  @Test
  void eachCharacterFrequencySorted() {
    String inputString = "programming is fun";
    Map<Character, Long> collect =
        inputString
            .chars()
            .mapToObj(o -> (char) o)
            .collect(
                Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    System.out.println(collect);
  }

  /**
   * Find frequency of each character in a string using Java 8 streams It gives result in any sorted
   * order
   */
  @Test
  void eachCharacterFrequencyInsertionOrder() {
    String inputString = "programming is fun";
    Map<Character, Long> collect =
        inputString
            .chars()
            .mapToObj(o -> (char) o)
            .collect(
                Collectors.groupingBy(
                    Function.identity(), LinkedHashMap::new, Collectors.counting()));
    System.out.println(collect);
  }
}
