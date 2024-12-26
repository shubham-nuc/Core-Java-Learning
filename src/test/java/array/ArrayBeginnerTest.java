package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArrayBeginnerTest {
    ArrayBeginner testClass=new ArrayBeginner();

    @Test
    void testCreateAIntArray() {
        var intArr=testClass.createIntArray(10);
        System.out.println("Array Length  = "+intArr.length);
        // It will print like [I
        System.out.println(intArr.getClass().getName());
    }

    @Test
    void testCreateDoubleArray() {
        var doubleArr=testClass.createDoubleArray(10);
        System.out.println("Array Length  = "+doubleArr.length);
        // It will print like [D
        System.out.println(doubleArr.getClass().getName());
    }


    @Test
    void createStringArray() {
        var stringArr=testClass.createStringArray(10);
        System.out.println("Array Length  = "+stringArr.length);
        // It will print like String Class (String is object)
        System.out.println(stringArr.getClass().getName());
    }

    @Test
    void create2DIntArray() {
        var int2DArr=testClass.create2DIntArray();
        System.out.println("Full Array Length  = "+int2DArr.length);
        // It will print like [[I
        System.out.println("2D int Array Class Name = "+int2DArr.getClass().getName());

        var firstIndex = int2DArr[0];
        System.out.println("First Index Class Name = "+firstIndex.getClass().getName());
        System.out.println("First Index Array Length  = "+firstIndex.length);
        System.out.println("[0][0] = "+firstIndex[0]);
        System.out.println("[0][1] = "+firstIndex[1]);

        var secondIndex = int2DArr[1];
        System.out.println("Second Index Class Name = "+secondIndex.getClass().getName());
        System.out.println("Second Index Array Length  = "+secondIndex.length);
        System.out.println("[1][0] = "+secondIndex[0]);
        System.out.println("[1][1] = "+secondIndex[1]);
        System.out.println("[1][2] = "+secondIndex[2]);

    }

    @Test
    void createAndInitializeIntArraySimpleWay() {
        var intArr=testClass.createAndInitializeIntArraySimpleWay();
        System.out.println("Array Length  = "+intArr.length);
        // It will print like [I
        System.out.println(intArr.getClass().getName());
        System.out.println(Arrays.toString(intArr));
    }
}