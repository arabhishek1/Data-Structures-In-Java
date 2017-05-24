package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 24/05/17.
 * Search in a Rotated Array
 * Given a sorted and rotated array (rotated at some point) A[ ], and given an element K,
 * the task is to find the index of the given element K in the array A[ ]. The array has no duplicate elements.
 * If the element does not exist in the array, print -1.

 */
public class SearchInRotatedArray {

    public static int searchInRotatedArray(int arr[], int key){
        int low=0;
        int high = arr.length -1;
        while(high - low >= 0){
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key >= arr[low]) {
                if (key <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (key >= arr[mid + 1]) {
                if (key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(searchInRotatedArray(arr, 6));
    }
}
