package Array;

/**
 * Created by abhishek.ar on 29/07/17.
 Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can be repeated multiple
 times and some other elements can be absent from the array. Count frequency of all elements that are present and print
 the missing elements.

 Examples:

 Input: arr[] = {2, 3, 3, 2, 5}
 Output: Below are frequencies of all elements
 1 -> 0
 2 -> 2
 3 -> 2
 4 -> 0
 5 -> 1

 Input: arr[] = {4, 4, 4, 4}
 Output: Below are frequencies of all elements
 1 -> 0
 2 -> 0
 3 -> 0
 4 -> 4
 */
public class FrequencyOfElements {

    public static void getCountOfElements(int arr[]){
        for(int i=0; i <arr.length; ++i)
            arr[i] -= 1;

        for(int i=0; i <arr.length; ++i){
            arr[arr[i] % arr.length] = arr.length + arr[arr[i]%arr.length];
        }

        for(int i=0; i <arr.length; ++i){
            System.out.println(i + 1 + "=> " +arr[i]/arr.length);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 2, 5};
        getCountOfElements(arr);
    }
}
