package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 25/05/17.
 * Count ways to N'th Stair(Order does not matter)
 * There are n stairs, a person standing at the bottom wants to reach the top.
 * The person can climb either 1 stair or 2 stairs at a time.
 * Count the number of ways, the person can reach the top (order does not matter).
 * Order does not matter means for n=4 {1 2 1},{2 1 1},{1 1 2} are considered same
 */
public class CountWaysToReachNthStairWithoutOrder {
    private static final int coinValues[] = {1,2};

    //This is nothing but variation of Coin Change problem.
    public static int countWays(int n){
       return coinChange(coinValues, coinValues.length, n);
    }

    private static int coinChange(int[] coinValues, int length, int n) {
        if (n == 0)
            return 1;
        if (n <0)
            return 0;
        if (length <=0 && n >=1)
            return 0;
        else
            return coinChange(coinValues, length, n-coinValues[length-1]) +  coinChange(coinValues,length-1, n);
    }


    public static void main(String args[]){
        System.out.println(countWays(4));
    }
}
