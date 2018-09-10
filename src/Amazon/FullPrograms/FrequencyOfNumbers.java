package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 28/03/18.
Given a Range of numbers, compute the frequency of each digit in the range in O(n) time and O(1) space complexity.

 Example:

 Input :{1,2,1,5,2}, and range 1..5 inclusive

 Output :
 {1->2, 2 ->2, 3->0, 4->0,5->1}

 */
public class FrequencyOfNumbers {

    public static int[] frequencyOfNumbers(int arr[], int size) {
        for(int i=0; i < arr.length; ++i){
            arr[(arr[i])/size + 1] += size;
        }

        for(int i=0; i< arr.length; ++i){
            arr[i] /= size;
        }
        for(int i=0; i < arr.length; ++i)
            System.out.printf(arr[i] + " ");
        return arr;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,1,5,2};
        frequencyOfNumbers(arr, arr.length);
    }
}
