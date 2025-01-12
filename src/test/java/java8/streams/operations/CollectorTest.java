package java8.streams.operations;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorTest {

  @Test
  void collect() {
    List<String> list = Arrays.asList("shubham", "kunal", "pankaj","shubham");
    String commaSeparatedNames = list.stream().collect(Collectors.joining(","));
    System.out.println(commaSeparatedNames);
  }

    @Test
    void collect1() {
        List<String> list = Arrays.asList("shubham", "kunal", "pankaj","shubham");
        LinkedList<String> ll = list.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(ll);
    }

    @Test
    void collect2() {
        List<String> list = Arrays.asList("shubham", "kunal", "pankaj","shubham");
        Set<String> set = list.stream().collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);
    }

    @Test
    void collect3() {
        List<String> list = Arrays.asList("shubham", "kunal", "pankaj","shubham");
        Set<String> set = list.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);
    }

  @Test
  void collect4() {
    List<String> list = Arrays.asList("shubham", "kunal", "pankaj", "shubham");
    Map<String, Integer> map =
            list.stream().collect(Collectors.toMap(Function.identity(), String::length, (a, b) -> b));
    System.out.println(map);
  }

    @Test
    void collect5() {
        List<String> list = Arrays.asList("shubham", "kunal", "pankaj", "shubham");
        Map<String, Integer> map =
                list.stream().collect(Collectors.toMap(str1->str1.toUpperCase(),str1->str1.length(),(a,b)->a));
        System.out.println(map);
    }

    @Test
    void collect6() {
        List<String> list = Arrays.asList("shubham", "kunal", "pankaj", "shubham");
        List<String> output =
                list.stream().collect(Collectors.mapping(String::toUpperCase,Collectors.toList()));
        System.out.println(output);
    }
}
