package Directi;

/**
 * Created by abhishek.ar on 08/07/17.
 * Largest sum Zigzag sequence in a matrix
 * Given a matrix of size n x n, find sum of the Zigzag sequence with the largest sum.
 * A zigzag sequence starts from the top and ends at the bottom. Two consecutive elements of sequence
 * cannot belong to same column.
 * Examples:
 * <p>
 * Input : mat[][] = 3  1  2
 * 4  8  5
 * 6  9  7
 * Output : 18
 * Zigzag sequence is: 3->8->7
 * Another such sequence is 2->4->7
 * <p>
 * Input : mat[][] =  4  2  1
 * 3  9  6
 * 11  3 15
 * Output : 28
 */
public class LargestSumZigzagMatrix {

    public static int[][] dp = new int[100][100];

    public static int largestZigZagSumRec(int arr[][], int i, int j, int end) {
        if (i == end - 1) {
            return arr[i][j];
        }

        int res = 0;
        for (int k = 0; k < end; ++k) {
            if (k != j)
                res = Math.max(res, largestZigZagSumRec(arr, i + 1, k, end));
        }
        return res + arr[i][j];
    }

    public static int largestZigZag(int arr[][]) {
        int res = 0;
        for (int j = 0; j < arr[0].length; ++j)
            res = Math.max(res, largestZigZagSumRec(arr, 0, j, arr.length));
        return res;
    }

    public static int largestZigZagSumMemDP(int arr[][], int i, int j, int end) {

        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        if (i == end - 1) {
            return dp[i][j] = arr[i][j];
        }

        int res = 0;
        for (int k = 0; k < end; ++k) {
            if (k != j)
                res = Math.max(res, largestZigZagSumMemDP(arr, i + 1, k, end));
        }
        return dp[i][j] = res + arr[i][j];
    }

    public static int largestZigZagMemDP(int arr[][]) {
        int res = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length; ++j) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        for (int j = 0; j < arr[0].length; ++j)
            res = Math.max(res, largestZigZagSumMemDP(arr, 0, j, arr.length));
        return res;
    }

    public static void main(String[] args) {
        int arr[][] = {{4, 2, 1},
                {3, 9, 6},
                {11, 3, 15}};

        System.out.println(largestZigZag(arr));
        System.out.println(largestZigZagMemDP(arr));
    }
}
