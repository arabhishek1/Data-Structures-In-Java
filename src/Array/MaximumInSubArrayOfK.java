package Array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by abhishek.ar on 01/08/17.
 Sliding Window Maximum (Maximum of all subarrays of size k)
 Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

 Examples:

 Input :
 arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 k = 3
 Output :
 3 3 4 5 5 5 6

 Input :
 arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 k = 4
 Output :
 10 10 10 15 15 90 90
 */
public class MaximumInSubArrayOfK {

    public static void maxInSubArrayOfK(int arr[], int k){

        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();
        int i;
        for(i = 0; i < k; ++i)
        {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();   // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < arr.length; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();


            // Add current element at the rear of Qi
            Qi.addLast(i);

        }
        System.out.print(arr[Qi.peek()]);

    }

    public static void main(String[] args) {
        int arr[] = {10,8, 5,  7, 9, 4, 15, 12, 90, 13};
        maxInSubArrayOfK(arr, 4);
    }
}
