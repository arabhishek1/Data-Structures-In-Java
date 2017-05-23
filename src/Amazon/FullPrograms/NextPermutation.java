package Amazon.FullPrograms;

import java.util.Arrays;

/**
 * Created by abhishek.ar on 23/05/17.
 *
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.
 If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending
 order.
 For example:
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 */

public class NextPermutation {
    public static void nextPermutation(int [] arr){
        int pos = arr.length-1, i;
        // I) Start from the right most digit and find the first digit that is
        // smaller than the digit next to it.
        for(i=arr.length-1; i > 0; --i){
            if (arr[i -1 ] < arr[i]){
                pos = i-1;
                break;
            }
        }
        // If no such digit is found, then all digits are in descending order
        // means there cannot be a greater number with same set of digits
        if (i == 0)
        {
            System.out.println("Next number is not possible");
            return;
        }
        // II) Find the smallest digit on right side of (i-1)'th digit that is
        // greater than number[i-1]
        int x = arr[i-1], smallestIndex = i;
        for(int j=i+1; j < arr.length; ++j){
            if (arr[j] > x && arr[j] < arr[smallestIndex])
                smallestIndex = j;
        }
        // III) Swap the above found smallest digit with number[i-1]
        swap(arr, pos, smallestIndex);
        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(arr, pos +1, arr.length);
    }

    private static void swap(int[] arr, int i, int smallestIndex) {
        int temp = arr[i];
        arr[i] = arr[smallestIndex];
        arr[smallestIndex] = temp;
    }
    public static void main(String[] args){
        int arr [] = {5,3,4,9,7,6};
        int arr1[] = {4,2,3,1};
        nextPermutation(arr);
        for(int i=0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }
}
