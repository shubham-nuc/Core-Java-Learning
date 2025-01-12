package java8.fi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import java8.mockdata.MockData;
import java8.mockdata.model.Fruit;
import org.junit.jupiter.api.Test;

public class FunctionFITest {

  @Test
  void createFunction() {
    var output =
        new Function<Integer, Integer>() {
          @Override
          public Integer apply(Integer integer) {
            return integer * 2;
          }
        }.apply(10);
    System.out.println("output=" + output);
  }

  @Test
  void createFunctionSimplified() {
    Function<Integer, Integer> func =
        new Function<Integer, Integer>() {
          @Override
          public Integer apply(Integer integer) {
            return integer * 2;
          }
        };
    var output = func.apply(10);
    System.out.println("output=" + output);
  }

  @Test
  void createFunctionSimplified1() {
    var output = ((Function<Integer, Integer>) i -> i * 2).apply(10);
    System.out.println("output=" + output);
  }

  /** Anonymous Function can be replaced with Lambda */
  @Test
  void createFunctionSimplified2() {
    Function<Integer, Integer> func = i -> i * 2;
    var output = func.apply(10);
    System.out.println("output=" + output);
  }

    /**
     * Input = Map <String,Integer>
     * Output = List <Integer> (Gives Values of Map as List)
     *
     */
  @Test
  void mapToList() {
      Map<String, Integer> input = Map.of("one", 1, "two", 2);
      Function<Map<String, Integer>, List<Integer>> func = i -> new ArrayList<>(i.values());
      List<Integer> output = func.apply(input);
      System.out.println(output);
  }

    /**
     * Input = List<Fruits>
     * Output  = Map<Fruit Name, Fruit Obj>
      */
  @Test
    void listToMapWithObjects() {
        var fruits = MockData.getFruits();
        Function<List<Fruit>, Map<String,Fruit>> func1 = fruitList -> {
            Map<String,Fruit> outputMap=new HashMap<>();
            for(Fruit eachFruit:fruitList){
                outputMap.put(eachFruit.name(),eachFruit);
            }
            return outputMap;
        };
        Map<String, Fruit> output = func1.apply(fruits);
        System.out.println("func1="+output);

        // .collect(Collectors.toMap(eachFruit->eachFruit.name(), eachFruit->eachFruit) - giving error
        //This is giving error if there are duplicate keys. To solve this we need to define merger function
        //.collect(Collectors.toMap(eachFruit->eachFruit.name(), eachFruit->eachFruit,(a,b)->b) - no error
        // third argument is merger function which resolve the duplicate key error,
        // out of a and b which one to take if both a and b have same key.

      //Duplicate key error code
      /*Function<List<Fruit>, Map<String,Fruit>> func2 = fruitList -> {
          Map<String,Fruit> outputMap= fruitList.stream()
                  .collect(Collectors.toMap(eachFruit->eachFruit.name(), eachFruit->eachFruit));
          return outputMap;
      };*/

      //error resolved using merger argument
      Function<List<Fruit>, Map<String,Fruit>> func2 = fruitList -> {
          Map<String,Fruit> outputMap= fruitList.stream()
                  .collect(Collectors.toMap(eachFruit->eachFruit.name(), eachFruit->eachFruit,(a,b)->b));
          return outputMap;
      };
      System.out.println("func2="+func2.apply(fruits));

      Function<List<Fruit>, Map<String,Fruit>> func3 = fruitList -> {
          Map<String,Fruit> outputMap= fruitList.stream()
                  .collect(Collectors.toMap(Fruit::name, eachFruit->eachFruit, (Fruit a, Fruit b) ->a));
          return outputMap;
      };
      System.out.println("func3="+func3.apply(fruits));
    }
}
