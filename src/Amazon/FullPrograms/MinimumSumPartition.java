package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 26/05/17.
 * Given an array, the task is to divide it into two sets S1 and S2
 * such that the absolute difference between their sums is minimum.
 */
public class MinimumSumPartition {

    private static int lookup[][] = new int[1000][1000];

    //Recursive Approach

    public static int minimumSumPartition(int arr[], int end, int currentSum, int totalSum ) {

        if (end == 0)
            return Math.abs(totalSum - currentSum);

        return Math.min(minimumSumPartition(arr, end - 1, currentSum + arr[end - 1], totalSum - arr[end - 1]),
                minimumSumPartition(arr, end - 1, currentSum, totalSum));
    }

    public static int minSumWrapper(int arr[]) {
        int sum = getSum(arr);
        return minimumSumPartition(arr, arr.length, 0, sum);
    }





    //Memory Table DP

    public static int minimumSumPartitionMemory(int arr[], int end, int currentSum, int totalSum) {

        if (end == 0)
            return Math.abs(totalSum - currentSum);

        if (lookup[end][totalSum] != Integer.MAX_VALUE)
            return lookup[end][totalSum];

        return lookup[end][totalSum] = Math.min(
                minimumSumPartitionMemory(arr, end - 1, currentSum + arr[end - 1], totalSum - arr[end - 1]),
                minimumSumPartitionMemory(arr, end - 1, currentSum, totalSum));
    }


    public static int minimumSumPartitionMemoryWrapper(int arr[]){
        int sum = getSum(arr);
        for(int i=0; i <1000; ++i){
            for (int j=0; j <1000; ++j)
                lookup[i][j] = Integer.MAX_VALUE;
        }
        return minimumSumPartitionMemory(arr, arr.length, 0, sum);
    }



    private static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; ++i)
            sum += arr[i];
        return sum;
    }

/*

Bottom up : DP

* The task is to divide the set into two parts.
We will consider the following factors for dividing it.
Let
  dp[n+1][sum+1] = {1 if some subset from 1st to i'th has a sum
                      equal to j
                   0 otherwise}

    i ranges from {1..n}
    j ranges from {0..(sum of all elements)}

So
    dp[n+1][sum+1]  will be 1 if
    1) The sum j is achieved including i'th item
    2) The sum j is achieved excluding i'th item.

Let sum of all the elements be S.

To find Minimum sum difference, w have to find j such
that Min{sum - j*2  : dp[n][j]  == 1 }
    where j varies from 0 to sum/2

The idea is, sum of S1 is j and it should be closest
to sum/2, i.e., 2*j should be closest to sum.*/


    public static int minimumSumPartitionDP(int arr[], int sum){
        boolean res[][] = new boolean[arr.length+1][sum+1];
        // Initialize first column as true. 0 sum is possible
        // with all elements.
        for(int i=0; i <= arr.length; ++i){
            res[i][0] = true;
        }

        // Initialize top row, except res[0][0], as false. With
        // 0 elements, no other sum except 0 is possible
        for(int i=1; i <= sum; ++i){
            res[0][i] = false;
        }
        for(int i=1; i <= arr.length; ++i){
            for(int j=1; j <= sum; ++j){
                // If i'th element is excluded
                res[i][j] = res[i-1][j];

                // If i'th element is included
                if (j - arr[i-1] >= 0) {
                    res[i][j] |= res[i - 1][j - arr[i - 1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        for(int j= sum/2; j >=0; --j){
            if (res[arr.length][j] == true){
                diff = sum - 2*j;
                break;
            }
        }
        return diff;
    }


    public static void main(String[] args) {
        int arr[] = {16,5,2};
        System.out.println(minSumWrapper(arr));
        System.out.println(minimumSumPartitionDP(arr, getSum(arr)));
        System.out.println(minimumSumPartitionMemoryWrapper(arr));
    }
}
