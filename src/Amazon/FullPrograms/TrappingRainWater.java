package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 28/05/17.
 Given n non-negative integers in array representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.
 Examples:

 Input: arr[]   = {2, 0, 2}
 Output: 2
 Structure is like below
 | |
 |_|
 We can trap 2 units of water in the middle gap.

 Input: arr[]   = {3, 0, 0, 2, 0, 4}
 Output: 10
 Structure is like below
      |
 |    |
 |  | |
 |__|_|
 We can trap "3*2 units" of water between 3 an 2,
 "1 unit" on top of bar 2 and "3 units" between 2
 and 4.  See below diagram also.

 Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 Output: 6
        |
    |   || |
 _|_||_||||||
 Trap "1 unit" between first 1 and 2, "4 units" between
 first 2 and 3 and "1 unit" between second last 1 and last 2
 */
public class TrappingRainWater {

    public static int calTrappedRainWater(int arr[]){
        // contains tallest bar to the left of the  ith element
        int left[] = new int [arr.length];

        //contains tallest bar to the right of the ith element
        int right[] = new int [arr.length];

        left[0] = arr[0];
        for(int i=1; i < left.length; ++i)
            left[i] = Math.max(left[i-1], arr[i]);

        right[arr.length-1] = arr[arr.length-1];
        for(int j=right.length -2 ; j >=0; --j){
            right[j] = Math.max(right[j+1],arr[j]);
        }

        int waterCollected =0;
        for(int i=0; i<arr.length; ++i){
            waterCollected += Math.min(left[i],right[i]) - arr[i];
        }

        return  waterCollected;
    }

/*
* A Simple Solution is to traverse every array element and find the highest bars on left and right sides.
 * Take the smaller of two heights. The difference between smaller height and height of current element
 * is the amount of water that can be stored in this array element. Time complexity of this solution is O(n2).

An Efficient Solution is to pre-compute highest bar on left and right of every bar in O(n) time.
Then use these pre-computed values to find the amount of water in every array element.

*/

    public static void main(String [] args){
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(calTrappedRainWater(arr));
    }
}
