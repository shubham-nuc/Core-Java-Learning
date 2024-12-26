package array;

public class ArrayBeginner {



    public static void main(String[] args) {


    }

    public int[] createIntArray(int arrayLength){
        int[] intArr = new int[arrayLength];
        intArr[0]=10;
        intArr[1]=20;
        intArr[3]=30;
        return intArr;
    }

    public double[] createDoubleArray(int arrayLength){
        double[] doubleArr = new double[arrayLength];
        doubleArr[0]=10.1;
        doubleArr[1]=20.2;
        doubleArr[3]=30.3;
        return doubleArr;
    }

    public String[] createStringArray(int arrayLength){
        String[] doubleArr = new String[arrayLength];
        doubleArr[0]="shubham";
        doubleArr[1]="kunal";
        doubleArr[3]="pankaj";
        return doubleArr;
    }

    public int[][] create2DIntArray(){
        int[][] int2dArr = new int[2][];
        int2dArr[0]=new int[2];
        int2dArr[1]=new int[3];

        int2dArr[0][0]=1;
        int2dArr[0][1]=2;

        int2dArr[1][0]=3;
        int2dArr[1][1]=4;
        int2dArr[1][2]=5;

        return int2dArr;
    }

    public int[] createAndInitializeIntArraySimpleWay(){
        int[] intArr = {10,20,30};
        return intArr;
    }

}
