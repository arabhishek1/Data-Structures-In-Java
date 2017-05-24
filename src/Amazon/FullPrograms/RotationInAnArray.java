package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 24/05/17.
 * Given a sorted array which is rotated 'N' times. Find the value of 'N'.
 *
 */
public class RotationInAnArray {
    public static int findNoOfTimesOfRotation(int arr[]){
        int low= 0;
        int high = arr.length -1;
        while(high - low > 1){
            int mid = low + (high-low)/2;
            if (arr[mid] >= arr[high]){
                low = mid;
            } else {
                high = mid;
            }
        }
        if (low == 0) // important for cases where the list is completely sorted wihtout any rotation.
            return 0;
        return high;
    }

    public static void main(String [] args){
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(findNoOfTimesOfRotation(arr));
    }
}
