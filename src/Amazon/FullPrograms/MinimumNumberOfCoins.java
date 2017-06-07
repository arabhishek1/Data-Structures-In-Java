package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 03/06/17.
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm}
 * valued coins, what is the minimum number of coins to make the change?

 * Examples:

 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents

 * Input: coins[] = {9, 6, 5, 1}, V = 11
 * Output: Minimum 2 coins required
 * We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class MinimumNumberOfCoins {

    private static int [][] lookUpTable = new int[1000][1000];
    /*
    If V == 0, then 0 coins required.
    If V > 0
       minCoin(coins[0..m-1], V) = min {1 + minCoins(V-coin[i])}
                                   where i varies from 0 to m-1
                                   and coin[i] <= V
    */
    public static int minimumNoOfCoins(int arr[], int end, int val) {
        if (val == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < end; ++i) {
            if (val - arr[i] >= 0) {
                // Here we are not decreasing the value of end as we can have 2 coins of 5 to give 10. If the statement
                // is otherwise meaning only one occurence of coin shld be used then decrement at each iteration
                int currentRes = minimumNoOfCoins(arr, end, val - arr[i]);
                if (currentRes != Integer.MAX_VALUE && currentRes + 1 < res)
                    res = currentRes + 1;
            }
        }
        return res;
    }

    public static int minimumNoOfCoinsMemTable(int arr[], int end, int val) {
        if (lookUpTable[val][end] != Integer.MAX_VALUE)
            return lookUpTable[val][end];
        if (val == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < end; ++i) {
            if (val - arr[i] >= 0) {
                // Here we are not decreasing the value of end as we can have 2 coins of 5 to give 10. If the statement
                // is otherwise meaning only one occurence of coin shld be used then decrement at each iteration
                int currentRes = minimumNoOfCoinsMemTable(arr, end, val - arr[i]);
                if (currentRes != Integer.MAX_VALUE && currentRes + 1 < res)
                    res = currentRes + 1;
            }
        }
        return lookUpTable[val][end] = res;
    }

    public static int minimumNoOfCoinsMemTableWrapper(int arr[], int val){
        for(int i=0; i <lookUpTable.length; ++i){
            for (int j=0; j < lookUpTable[0].length; ++j){
                lookUpTable[i][j] = Integer.MAX_VALUE;
            }
        }
        return minimumNoOfCoinsMemTable(arr, arr.length, val);
    }


    public static int minimumNoOfCoinsDP(int arr[], int val){
        int dp[] = new int[val+1];
        dp[0]=0;
        for(int i=1; i <=val; ++i){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i <= val; ++i){
            for(int j=0; j < arr.length; ++j){
                if (i - arr[j] >= 0){
                    int sub_res = dp[i-arr[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res +1 < dp[i])
                        dp[i] = sub_res +1;
                }
            }
        }
        return dp[val];
    }


    public static void main(String[] args) {
        int coins[] = {1, 2, 3, 4, 5};
        System.out.println(minimumNoOfCoins(coins, coins.length, 10));
        System.out.println(minimumNoOfCoinsMemTableWrapper(coins, 10));
        System.out.println(minimumNoOfCoinsDP(coins, 10));
    }
}
