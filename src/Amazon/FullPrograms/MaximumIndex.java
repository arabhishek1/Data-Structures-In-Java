package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 23/05/17.
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 * Example :

 A : [3 5 4 2]

 Output : 2
 for the pair (3, 4)
 */
public class MaximumIndex {

    public static int maximumIndex(int arr[]){
        int[] LMin = new int[arr.length];
        int[] RMax = new int[arr.length];
        LMin[0] = arr[0];
        for(int i=1; i <arr.length; ++i){
            LMin[i] = Math.min(arr[i], LMin[i-1]);
        }
        RMax[arr.length - 1] = arr[arr.length-1];
        for(int j=arr.length-2; j >=0; --j){
            RMax[j] = Math.max(arr[j], RMax[j+1]);
        }
        int i=0, j=0, maxDiff = -1;
        while (i < arr.length && j < arr.length){
            if (LMin[i] < RMax[j]){
                maxDiff = Math.max(maxDiff, j-i);
                ++j;
            } else{
                ++i;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args){
        int [] arr = {3,5,4,2};
        System.out.println(maximumIndex(arr));
    }

/*
*
* To solve this problem, we need to get two optimum indexes of arr[]: left index i and right index j.
* For an element arr[i], we do not need to consider arr[i] for left index if there is an element smaller
* than arr[i] on left side of arr[i]. Similarly, if there is a greater element on right side of arr[j]
* then we do not need to consider this j for right index. So we construct two auxiliary arrays LMin[] and RMax[]
* such that LMin[i] holds the smallest element on left side of arr[i] including arr[i], and RMax[j] holds
* the greatest element on right side of arr[j] including arr[j]. After constructing these two auxiliary arrays,
* we traverse both of these arrays from left to right. While traversing LMin[] and RMa[]
* if we see that LMin[i] is greater than RMax[j], then we must move ahead in LMin[] (or do i++)
* because all elements on left of LMin[i] are greater than or equal to LMin[i]. Otherwise we must move ahead in
* RMax[j] to look for a greater j – i value.*/

}
