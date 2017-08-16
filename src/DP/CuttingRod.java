package DP;

/**
 * Created by abhishek.ar on 16/08/17.
 Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod
 is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in
 two pieces of lengths 2 and 6)


 length   | 1   2   3   4   5   6   7   8
 --------------------------------------------
 price    | 1   5   8   9  10  17  17  20
 And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

 length   | 1   2   3   4   5   6   7   8
 --------------------------------------------
 price    | 3   5   8   9  10  17  17  20
 */
public class CuttingRod {

    public static int cuttingRodRec(int price[], int n){
        if (n <=0)
            return 0;
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i < n; ++i){
            max_value = Math.max(max_value, price[i] + cuttingRodRec(price, n-i-1));
        }
        return  max_value;
    }

    public static int cuttingRodDP(int price[], int n){
        int DP[] = new int[n+1];
        for(int i=1; i < DP.length; ++i){
            int max_value = Integer.MIN_VALUE;
            for(int j=0; j <i; ++j){
                max_value = Math.max(max_value, price[j] + DP[i-j-1]);
            }
            DP[i] = max_value;
        }
        return DP[price.length];
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cuttingRodRec(arr, arr.length));
        System.out.println(cuttingRodDP(arr, arr.length));

    }
}
