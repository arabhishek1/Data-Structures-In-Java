package Array;

import java.util.Arrays;

/**
 * Created by abhishek.ar on 19/06/17.
 For each element in 1st array count elements less than or equal to it in 2nd array
 Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements
 less than or equal to it in array arr2[].

 Examples:

 Input : arr1[] = [1, 2, 3, 4, 7, 9]
 arr2[] = [0, 1, 2, 1, 1, 4]
 Output : [4, 5, 5, 6, 6, 6]

 Input : arr1[] = [5, 10, 2, 6, 1, 8, 6, 12]
 arr2[] = [6, 5, 11, 4, 2, 3, 7]
 Output : [4, 6, 1, 5, 0, 6, 5, 7]

 //Sort the elements of 2nd array, i.e., array arr2[]. Then perform a modified binary search on array arr2[].
 For each element x of array arr1[], find the last index of the largest element smaller than or equal to x
 in sorted array arr2[].

 */
public class CountLesserElements {

    public static int BinarySearch(int arr[], int key){
        int low =0;
        int high = arr.length-1;
        while(low <= high) {
            int mid = (low + high )/ 2;
            if (arr[mid] <= key){
                low = mid +1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }

    public static void findMinimum(int arr1[], int [] arr2){
        Arrays.sort(arr2);

        for(int i=0; i < arr1.length; ++i){
            System.out.print(BinarySearch(arr2, arr1[i]) + 1 + " ");
        }
    }

    public static void main(String[] args) {
        int arr1[]= {1, 2, 3, 4, 7, 9};
        int arr2[]= {0, 1, 2, 1, 1, 4};
        findMinimum(arr1, arr2);
    }

}
