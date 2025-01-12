package array.problems.MoveAllZeroAtEnd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MoveAllZeroAtEnd {

    @Test
    void approach1(){
        int[] intArr= {-1,2,0,-3,4,5,0,6};
        for (int i = 0; i < intArr.length-1; i++) {
            if (intArr[i]==0){
                for (int j = i; j < intArr.length-1; j++) {
                    intArr[j]=intArr[j+1];
                }
                intArr[intArr.length-1]=0;
            }
        }
        System.out.println(Arrays.toString(intArr));
    }

    /**
     * Not Working
     * Because when two zero come together, it swap each other
     * causes one zero in middle
     */
    @Test
    void approach2(){
        int[] intArr= {-1,2,0,-3,4,5,0,6};
        int count=0;
        for (int i = 0; i < intArr.length-1; i++) {
            if(intArr[i]==0){
                //swap 0 with next index and move forward
                intArr[i]=intArr[i+1];
                intArr[i+1]=0;
            }
        }
        System.out.println(Arrays.toString(intArr));
    }

    @Test
    void approach3(){
        int[] intArr= {-1,2,0,-3,4,5,0,6};
        int nonZeroElementPlaceHolder=0;
        for (int i = 0; i < intArr.length; i++) {
            if(intArr[i]!=0){
                int temp=intArr[i];
                intArr[i]=intArr[nonZeroElementPlaceHolder];
                intArr[nonZeroElementPlaceHolder]=temp;
                nonZeroElementPlaceHolder++;

            }
        }
        System.out.println(Arrays.toString(intArr));
    }

}
