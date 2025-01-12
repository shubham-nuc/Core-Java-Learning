package array.creation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArrayCreationTest {

  @Test
  void testCreateAIntArray() {
    int[] intArr = new int[10];
    intArr[0] = 10;
    intArr[1] = 20;
    intArr[3] = 30;
    System.out.println(intArr.length);
    // It will print like [I
    System.out.println(intArr.getClass().getName());
  }

  @Test
  void testCreateDoubleArray() {
      double[] doubleArr = new double[5];
      doubleArr[0]=10.1;
      doubleArr[1]=20.2;
      doubleArr[3]=30.3;
    System.out.println("Array Length  = " + doubleArr.length);
    // It will print like [D
    System.out.println(doubleArr.getClass().getName());
  }

  @Test
  void createStringArray() {
      String[] stringArr = new String[8];
      stringArr[0]="shubham";
      stringArr[1]="kunal";
      stringArr[3]="pankaj";
    System.out.println("Array Length  = " + stringArr.length);
    // It will print like String Class (String is object)
    System.out.println(stringArr.getClass().getName());
  }

  @Test
  void create2DIntArray() {
      int[][] int2dArr = new int[2][];
      int2dArr[0]=new int[2];
      int2dArr[1]=new int[3];

      int2dArr[0][0]=1;
      int2dArr[0][1]=2;

      int2dArr[1][0]=3;
      int2dArr[1][1]=4;
      int2dArr[1][2]=5;

    System.out.println("Full Array Length  = " + int2dArr.length);
    // It will print like [[I
    System.out.println("2D int Array Class Name = " + int2dArr.getClass().getName());

    var firstIndex = int2dArr[0];
    System.out.println("First Index Class Name = " + firstIndex.getClass().getName());
    System.out.println("First Index Array Length  = " + firstIndex.length);
    System.out.println("[0][0] = " + firstIndex[0]);
    System.out.println("[0][1] = " + firstIndex[1]);

    var secondIndex = int2dArr[1];
    System.out.println("Second Index Class Name = " + secondIndex.getClass().getName());
    System.out.println("Second Index Array Length  = " + secondIndex.length);
    System.out.println("[1][0] = " + secondIndex[0]);
    System.out.println("[1][1] = " + secondIndex[1]);
    System.out.println("[1][2] = " + secondIndex[2]);
  }

  @Test
  void createAndInitializeIntArraySimpleWay() {
      int[] intArr = {10,20,30};
    System.out.println("Array Length  = " + intArr.length);
    // It will print like [I
    System.out.println(intArr.getClass().getName());
    System.out.println(Arrays.toString(intArr));
  }
}
