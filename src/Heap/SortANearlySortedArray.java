package Heap;


/**
 * Created by abhishek.ar on 24/07/17.
 Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that
 sorts in O(n log k) time.

 For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes
 5, 6, 7, 8, 9 in the given array.
 */
public class SortANearlySortedArray {

    public static void sortArrayKAway(int arr[], int k){
        MinHeap<Integer> minHeap = new MinHeap(k);
        for (int i = 0; i< k && i<arr.length; i++) // i < n condition is needed when k > n
            minHeap.insert(arr[i]);
        for(int i=k, ti=0; ti < arr.length; ++i, ++ti){
            arr[ti] = minHeap.delMin();
            if (i < arr.length) {
                minHeap.insert(arr[i]);
            }
        }
    }

/* The idea is first create a mi heap of given k. Then start populating actual arrya using delete function and simultaneously
    Keep on adding the remaining elements to heap. The delete function always works in this case by giving the minimum element
    in the right order because of the constraint that all elements will be k away from actual position.

     Since we are adding all the remaining elements to heap within this k, the delete function always returns the right
     order of the element
 * */

    public static void main(String[] args) {
        int arr[] = {2, 6, 3, 12, 56, 8};
        sortArrayKAway(arr, 3);
        for(int i=0; i < arr.length; ++i)
            System.out.println(arr[i]);
    }
}
