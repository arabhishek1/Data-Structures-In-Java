package Amazon.FullPrograms;

import java.util.Arrays;

/**
 * Created by abhishek.ar on 28/05/17.
 Given an array of integers, write a function that returns true
 if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 Example:

 Input: arr[] = {3, 1, 4, 6, 5}
 Output: True
 There is a Pythagorean triplet (3, 4, 5).

 Input: arr[] = {10, 4, 6, 12, 5}
 Output: False
 There is no Pythagorean triplet.
 */
public class PythogoreanTriplet {

/*

We can solve this in O(n2) time by sorting the array first.

1) Do square of every element in input array. This step takes O(n) time.

2) Sort the squared array in increasing order. This step takes O(nLogn) time.

3) To find a triplet (a, b, c) such that a = b + c, do following.

Fix ‘a’ as last element of sorted array.
Now search for pair (b, c) in subarray between first element and ‘a’. A pair (b, c) with given sum can be found
in O(n)
If no pair found for current ‘a’, then move ‘a’ one position back and repeat above step


Time complexity of below approach : O(n2)

*/
    public static boolean isPythogoreanTripletPresent(int arr[]){
        getSquare(arr);
        Arrays.sort(arr);
        for(int i=arr.length-1; i >= 2; --i){
            int l = 0;
            int r = i-1;
            while(l < r){
                if (arr[l] + arr[r] == arr[i])
                    return true;
                if (arr[l] + arr[r] < arr[i])
                    ++l;
                else
                    --r;
            }
        }
        return false;
    }

    private static void getSquare(int[] arr) {
        for(int i=0; i < arr.length; ++i)
            arr[i]= arr[i] * arr[i];
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 6, 5};
        System.out.println(isPythogoreanTripletPresent(arr));
    }
}
