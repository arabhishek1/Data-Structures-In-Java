package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 23/05/17.
 * Given an array of integers, sort the array into a wave like array and return it.
 In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

 Example

 Given [1, 2, 3, 4]

 One possible answer : [2, 1, 4, 3]
 Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
 */
public class WaveArray {

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

/*
* Basically the logic goes something like this.
* if elements are a0, a1, a2, a3, a4, a5 then  a0 <= a1 >= a2 <= a3 >= a4
* i.e, the even indexed element should always be lesser than its previous and next element
* and the odd indexed element should always be greater than its previous and next element;
*
* To do this, compare the current element with next and prev number. If index is odd, the current element shld be
* lesser than prev and next number. if it isnt swap the elements.
*
* Similarly for even indexed the current element should be greater than the prev and next element. else swap.
*
* We are using a flag to change comparation operator < and > on every iteration  .
*/
    public static void waveArray(int arr[]){
        boolean flag = true;
        for (int i=1; i < arr.length-1; ++i){
            if (flag) {
                if (arr[i] > arr[i-1]) {
                    swap(arr, i, i-1);
                }

                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                }
                flag = !flag;
            } else {
                if (arr[i] < arr[i-1]) {
                    swap(arr, i, i-1);
                }

                if (arr[i] < arr[i+1]) {
                    swap(arr, i , i+1);
                }
                flag = !flag;
            }
        }
    }

/*
** Since here we are comparing for both even and odd placed elements , we can optimize in the following way.
* The idea is based on the fact that if we make sure that all even positioned (at index 0, 2, 4, ..)
* elements are greater than their adjacent odd elements, we don’t need to worry about odd positioned element.
* Following are simple steps.
* 1) Traverse all even positioned elements of input array, and do following./
* ….a) If current element is smaller than previous odd element, swap previous and current.//
  ….b) If current element is smaller than next odd element, swap next and current.
*/

    public static void waveArrayDiffImplmentation(int arr[]){
        for (int i=0; i < arr.length; i+=2){
            if (i >0 && arr[i] < arr[i-1]) {
                swap(arr, i, i-1);
            }

            if (i < arr.length -1 && arr[i] < arr[i+1]) {
                swap(arr, i, i + 1);
            }
        }
    }


    public static void main(String [] args){
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
//        waveArray(arr);
        waveArrayDiffImplmentation(arr);
        for(int i=0; i < arr.length; ++i){
            System.out.print( arr[i] + " ");
        }
    }
}













