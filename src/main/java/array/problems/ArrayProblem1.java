package array.problems;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayProblem1 {


    /**
     * Given an array of positive integers arr[] of size n,
     * the task is to find second largest distinct element in the array.
     *
     * Input: arr[] = [12, 35, 1, 10, 34, 1]
     * Output: 34
     * Explanation: The largest element of the array is 35 and the second largest element is 34.
     *
     * Input: arr[] = [10, 10, 10]
     * Output: -1
     * Explanation: The largest element of the array is 10 there is no second largest element.
     */
    public static void findSecondLargestElement(){
        int[] intArr= {10,20,50,50,99,49,7};
        Arrays.sort(intArr);
        int secondLargest=-1;

        for (int i=intArr.length-2;i>=0;i--){
            if(intArr[i]==intArr[i+1]){
                continue;
            }else{
                secondLargest=intArr[i];
                break;
            }
        }

       /* another shorter way
       if(intArr[i]!=intArr[i+1]){
            secondLargest=intArr[i];
        }*/
        System.out.println(secondLargest);
    }

    public static void findNthLargestElement(){
        int nthLargestPlace = 3;
        int[] intArr= {-1,2,-3,4,5,6};
        Arrays.sort(intArr);
        int nthLargestElement=-1;

        for (int i=intArr.length-nthLargestPlace;i>=0;i--){
            if(intArr[i]==intArr[i+1]){
                continue;
            }else{
                nthLargestElement=intArr[i];
                break;
            }
        }
        System.out.println(nthLargestElement);
    }

    /**
     * Better than approach 1
     * Sorting performance(complexity) is lower
     */
    public static void findSecondLargestApproach2(){
        int[] intArr= {-1,2,-3,4,5,6};
        int largest=-1;
        int secondLargest=-1;
        for (int i = 0; i <= intArr.length-1; i++) {
            if(largest<intArr[i]){
                largest=intArr[i];
            }
        }

        for (int i = 0; i <= intArr.length-1; i++) {
            if(secondLargest<intArr[i] && intArr[i]<largest){
                secondLargest=intArr[i];
            }
        }

        System.out.println("Largest = "+largest);
        System.out.println("Second Largest = "+secondLargest);
    }


    /**
     * Best Approach
     * Only one loop
     */
    public static void findSecondLargestApproach3(){
        int[] intArr= {-1,2,-3,4,5,6};
        int largest=-1;
        int secondLargest=-1;

        for (int i = 0; i <= intArr.length-1; i++) {
            int eachIndexValue = intArr[i];
            if(largest<eachIndexValue){
                secondLargest=largest;
                largest= eachIndexValue;
            }
            if (eachIndexValue >secondLargest && eachIndexValue <largest){
                secondLargest=eachIndexValue;
            }
        }
        System.out.println("Largest = "+largest);
        System.out.println("Second Largest = "+secondLargest);
    }

    public static void main(String[] args) {
        useScanner();
    }

    private static void useScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a test function to run:");
        System.out.println("1. Find Second Largest Element Approach 1");
        System.out.println("2. Find Nth Largest Element Approach 1");
        System.out.println("3. Find Second Largest Element Approach 2");
        System.out.println("4. Find Second Largest Element Approach 3");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                findSecondLargestElement();
                break;
            case 2:
                findNthLargestElement();
                break;
            case 3:
                findSecondLargestApproach2();
                break;
            case 4:
                findSecondLargestApproach3();
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
        }
        scanner.close();
    }

}
