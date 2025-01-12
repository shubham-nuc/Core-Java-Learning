package array.problems.FindSecondLargestElement;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindSecondLargestElement {

    /**
     * Given an array of positive integers arr[] of size n, the task is to find second largest
     * distinct element in the array.
     *
     * <p>Input: arr[] = [12, 35, 1, 10, 34, 1] Output: 34 Explanation: The largest element of the
     * array is 35 and the second largest element is 34.
     *
     * <p>Input: arr[] = [10, 10, 10] Output: -1 Explanation: The largest element of the array is 10
     * there is no second largest element.
     */
    @Test
    void findSecondLargestElement() {
        int[] intArr = {10, 20, 50, 50, 99, 49, 7};
        Arrays.sort(intArr);
        int secondLargest = -1;

        for (int i = intArr.length - 2; i >= 0; i--) {
            if (intArr[i] == intArr[i + 1]) {
                continue;
            } else {
                secondLargest = intArr[i];
                break;
            }
        }

    /* another shorter way
    if(intArr[i]!=intArr[i+1]){
         secondLargest=intArr[i];
     }*/
        System.out.println(secondLargest);
    }

    @Test
    void findNthLargestElement() {
        int nthLargestPlace = 3;
        int[] intArr = {-1, 2, -3, 4, 5, 6};
        Arrays.sort(intArr);
        int nthLargestElement = -1;

        for (int i = intArr.length - nthLargestPlace; i >= 0; i--) {
            if (intArr[i] == intArr[i + 1]) {
                continue;
            } else {
                nthLargestElement = intArr[i];
                break;
            }
        }
        System.out.println(nthLargestElement);
    }

    /** Better than approach 1 Sorting performance(complexity) is lower */
    @Test
    void findSecondLargestApproach2() {
        int[] intArr = {-1, 2, -3, 4, 5, 6};
        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i <= intArr.length - 1; i++) {
            if (largest < intArr[i]) {
                largest = intArr[i];
            }
        }

        for (int i = 0; i <= intArr.length - 1; i++) {
            if (secondLargest < intArr[i] && intArr[i] < largest) {
                secondLargest = intArr[i];
            }
        }

        System.out.println("Largest = " + largest);
        System.out.println("Second Largest = " + secondLargest);
    }

    /** Best Approach Only one loop */

    @Test
    void findSecondLargestApproach3() {
        int[] intArr = {-1, 2, -3, 4, 5, 6};
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i <= intArr.length - 1; i++) {
            int eachIndexValue = intArr[i];
            if (largest < eachIndexValue) {
                secondLargest = largest;
                largest = eachIndexValue;
            }
            if (eachIndexValue > secondLargest && eachIndexValue < largest) {
                secondLargest = eachIndexValue;
            }
        }
        System.out.println("Largest = " + largest);
        System.out.println("Second Largest = " + secondLargest);
    }
}
