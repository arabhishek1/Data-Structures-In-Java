package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 23/05/17.
 * Given a sequence, find the length of the longest increasing subsequence from a given sequence .
 The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's
 elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible.
 This subsequence is not necessarily contiguous, or unique.


 Note: Duplicate numbers are not counted as increasing subsequence.

 For example:
 length of LIS for
 { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncreasingSubsequence {

    public static int LIS(int arr[], int n){
        int [] LIS = new int[n];
        for(int i=0;i<n;++i){
            LIS[i] = 1;
        }
        for(int i=1; i <n ; ++i){
            for(int j=0; j <i; ++j){
                if (arr[i] > arr[j] && LIS[i] < LIS[j] +1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        int max =0;
        for(int i=0; i< LIS.length; ++i){
            if (LIS[i] > max)
                max = LIS[i];
        }
        return max;
    }

/*nlogn approach:

It will be clear with an example, let us take example from wiki {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}.

1. If A[i] is smallest among all end
   candidates of active lists, we will start
   new active list of length 1.
2. If A[i] is largest among all end candidates of
  active lists, we will clone the largest active
  list, and extend it by A[i].

3. If A[i] is in between, we will find a list with
  largest end element that is smaller than A[i].
  Clone and extend this list by A[i]. We will discard all
  other lists of same length as that of this modified list.

A[0] = 0. Case 1. There are no active lists, create one.
0.
-----------------------------------------------------------------------------
A[1] = 8. Case 2. Clone and extend.
0.
0, 8.
-----------------------------------------------------------------------------
A[2] = 4. Case 3. Clone, extend and discard.
0.
0, 4.
0, 8. Discarded
-----------------------------------------------------------------------------
A[3] = 12. Case 2. Clone and extend.
0.
0, 4.
0, 4, 12.
-----------------------------------------------------------------------------
A[4] = 2. Case 3. Clone, extend and discard.
0.
0, 2.
0, 4. Discarded.
0, 4, 12.
-----------------------------------------------------------------------------
A[5] = 10. Case 3. Clone, extend and discard.
0.
0, 2.
0, 2, 10.
0, 4, 12. Discarded.
-----------------------------------------------------------------------------
A[6] = 6. Case 3. Clone, extend and discard.
0.
0, 2.
0, 2, 6.
0, 2, 10. Discarded.
-----------------------------------------------------------------------------
A[7] = 14. Case 2. Clone and extend.
0.
0, 2.
0, 2, 6.
0, 2, 6, 14.
-----------------------------------------------------------------------------
A[8] = 1. Case 3. Clone, extend and discard.
0.
0, 1.
0, 2. Discarded.
0, 2, 6.
0, 2, 6, 14.
-----------------------------------------------------------------------------
A[9] = 9. Case 3. Clone, extend and discard.
0.
0, 1.
0, 2, 6.
0, 2, 6, 9.
0, 2, 6, 14. Discarded.
-----------------------------------------------------------------------------
A[10] = 5. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 5.
0, 2, 6. Discarded.
0, 2, 6, 9.
-----------------------------------------------------------------------------
A[11] = 13. Case 2. Clone and extend.
0.
0, 1.
0, 1, 5.
0, 2, 6, 9.
0, 2, 6, 9, 13.
-----------------------------------------------------------------------------
A[12] = 3. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 1, 5. Discarded.
0, 2, 6, 9.
0, 2, 6, 9, 13.
-----------------------------------------------------------------------------
A[13] = 11. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 2, 6, 9.
0, 2, 6, 9, 11.
0, 2, 6, 9, 13. Discarded.
-----------------------------------------------------------------------------
A[14] = 7. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 1, 3, 7.
0, 2, 6, 9. Discarded.
0, 2, 6, 9, 11.
----------------------------------------------------------------------------
A[15] = 15. Case 2. Clone and extend.
0.
0, 1.
0, 1, 3.
0, 1, 3, 7.
0, 2, 6, 9, 11.
0, 2, 6, 9, 11, 15. <-- LIS List
------------------------------------------------------------------------



  “end element of smaller list is smaller than end elements of larger lists”.

  Querying length of longest is fairly easy. Note that we are dealing with end elements only.
  We need not to maintain all the lists. We can store the end elements in an array. Discarding operation
  can be simulated with replacement, and extending a list is analogous to adding more elements to array.

We will use an auxiliary array to keep end elements. The maximum length of this array is that of input.
In the worst case the array divided into N lists of size one (note that it does’t lead to worst case complexity).
 To discard an element, we will trace ceil value of A[i] in auxiliary array (again observe the end elements in your
 rough work), and replace ceil value with A[i]. We extend a list by adding element to auxiliary array.
 We also maintain a counter to keep track of auxiliary array length.
*
*
* */

    private static int CeilValue(int arr[], int low, int high, int key){
        while(high - low > 1) {
            int mid = low + (high-low)/2;
            if (arr[mid] >= key) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    public static int LISlogn(int arr[]){
        int tail [] = new int[arr.length];
        tail[0] = arr[0];
        int len = 1; // always points empty slot
        for (int i=1; i < arr.length; ++i){
            if (arr[i] < tail[0]){
                // new smallest value
                tail[0] = arr[i];
            } else if (arr[i] > tail[len-1]){
                // A[i] wants to extend largest subsequence
                tail[len++]= arr[i];
            } else {
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tail[CeilValue(arr, 0, arr.length-1, arr[i])] = arr[i];
            }
        }
        return len;
    }

    public static void main(String [] args){
        int arr[] ={ 10, 22, 9, 33, 21, 50, 41, 60, 80 };
//        System.out.println(LIS(arr, arr.length));
        System.out.println(LISlogn(arr));
    }
}
