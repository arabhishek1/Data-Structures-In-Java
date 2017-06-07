package Amazon.FullPrograms;

import java.util.Arrays;

/**
 * Created by abhishek.ar on 01/06/17.

 Two elements whose sum is closest to zero
 Question: An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to zero.

 For the below array, program should print -80 and 85.
 */
public class TwoNumbers {

    public static void minSumPair(int arr[]){
        Arrays.sort(arr);
        int min=0, max=arr.length-1, minSum =Integer.MAX_VALUE, sum;
        for(int i=0, j= arr.length-1; i <j;){
            sum = arr[i] +arr[j];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                min = i;
                max = j;
            }
            if (sum < 0)
                ++i;
            else
                --j;
        }
        System.out.println("minimum pair are " + arr[max] + " "+arr[min]);
    }

    public static void main(String[] args) {
        int arr[] = {1, 60, -10, 70, -80, 85};
        minSumPair(arr);
    }
}
