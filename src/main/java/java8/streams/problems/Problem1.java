package java8.streams.problems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem1 {

    public static void main(String[] args) {
        List<Integer> intList = List.of(1,2,3,4,5,6,7,8,99,100);
        findOddAndEvenUsingGroupBy(intList);
        findOddAndEvenUsingPartionBy(intList);
    }

     public static void findOddAndEvenUsingGroupBy(List<Integer> intList){
         var output=intList.stream().collect(Collectors.groupingBy(i->i%2==0));
         System.out.println("-------Grouping By-----");
         System.out.println(output);
         output.forEach(Problem1::print);
    }


    public static void findOddAndEvenUsingPartionBy(List<Integer> intList){
        var output=intList.stream().collect(Collectors.partitioningBy(i->i%2==0));
        System.out.println("-------Partioning By-----");
        System.out.println(output);
        output.forEach(Problem1::print);
    }

    private static void print(Boolean k,List<Integer> v){
        String even = "Even Numbers = ";
        String odd = "Odd Numbers = ";
        if (k) {System.out.print(even); } else {
            System.out.print(odd);
        }
        System.out.println(v);

    }


}
