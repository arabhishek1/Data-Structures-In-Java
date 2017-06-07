package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 01/06/17.
 Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements in both
 subsets is same or not.
 Examples

 arr[] = {1, 5, 11, 5}
 Output: true
 The array can be partitioned as {1, 5, 5} and {11}

 arr[] = {1, 5, 3}
 Output: false
 The array cannot be partitioned into equal sum sets.
 */
public class SubsetSum {

    private static Boolean[][] lookupTable = new Boolean [1000][1000];

    //Slight Deviation of Minimum subset sum problem. Instead of Math.min check for zero directly.
    public static boolean isSubSetSumPossible(int arr[],  int end, int currentSum, int totalSum){
        if (totalSum - currentSum == 0)
            return true;
        if (end <= 0 && Math.abs(totalSum - currentSum) != 0)
            return false;
        return isSubSetSumPossible(arr, end-1, currentSum, totalSum) || isSubSetSumPossible(arr, end-1, currentSum+ arr[end-1], totalSum-arr[end-1]);
    }


    public static boolean isSubsetSumPossibleMemoryTable(int arr[], int end, int currentSum, int totalSum){

        if (lookupTable[end][totalSum] != null)
            return lookupTable[end][totalSum];

        if (totalSum - currentSum == 0)
            return true;

        if (end <= 0 && Math.abs(totalSum - currentSum) != 0)
            return false;

        return lookupTable[end][totalSum] = isSubsetSumPossibleMemoryTable(arr, end-1, currentSum, totalSum) || isSubsetSumPossibleMemoryTable(arr, end-1, currentSum+ arr[end-1], totalSum-arr[end-1]);
    }

    public static boolean isSubsetSumDP(int arr[], int sum){
        boolean [][] dp = new boolean[sum+1][arr.length+1];

        // If sum is 0, then answer is true
        for(int i=0; i <=arr.length; ++i)
            dp[0][i] = true;

        // If sum is not 0 and set is empty, then answer is false
        for(int i=0; i <=sum ;++i)
            dp[i][0] = false;

        for(int i=1; i <=sum; ++i){
            for(int j=1; j <=arr.length; ++j){
                if (i >= arr[j-1] ){
                    dp[i][j] = dp [i][j-1] || dp[i-arr[j-1]][j];
                } else {
                    dp[i][j] = dp [i][j-1];
                }
            }
        }
        return dp[sum][arr.length];
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 9, 12};
        int sum =0;
        for(int i=0; i <arr.length; ++i)
            sum += arr[i];
        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum%2 != 0)
            System.out.println("false");
        else {
            System.out.println(isSubSetSumPossible(arr, arr.length, 0, sum));
            System.out.println(isSubsetSumPossibleMemoryTable(arr, arr.length, 0, sum));
            System.out.println(isSubsetSumDP(arr, sum/2));
        }
    }
}
