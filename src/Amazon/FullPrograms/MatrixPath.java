package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 28/05/17.
 Given a N X N  matrix Matrix[N][N] of positive integers. There are only three possible moves from a cell Matrix[r][c].

 1. Matrix[r+1][c]

 2. Matrix[r+1][c-1]

 3. Matrix[r+1][c+1]

 Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.

 Example:
 Input :
 mat[4][4] = { {4, 2, 3, 4},
             {2, 9, 1, 10},
             {15, 1, 3, 0},
             {16, 92, 41, 44} };
 Output :120
 path : 4 + 9 + 15 + 92 = 120
 */
public class MatrixPath {

    private static int [][] lookUpTable = new int [4][4];
    //Recursive Approach:
    public static int largestSumPath(int arr[][], int row, int col, int rowLength, int colLength) {

        if (row >= rowLength || col >= colLength || col < 0)
            return 0;

        return arr[row][col] + Math.max(Math.max(largestSumPath(arr, row + 1, col, rowLength, colLength),
                largestSumPath(arr, row + 1, col - 1, rowLength, colLength)),
                largestSumPath(arr, row + 1, col + 1, rowLength, colLength));

    }

    public static int wrapperLargestSumPath(int arr[][]) {
        int maxPathSum = Integer.MIN_VALUE, currPathSum = 0;
        for (int i = 0; i < arr[0].length; ++i) {
            currPathSum = largestSumPath(arr, 0, i, arr.length, arr[0].length);
            if (currPathSum > maxPathSum)
                maxPathSum = currPathSum;
        }
        return maxPathSum;
    }

    //DP
    //Memory Table Approach: O(n2)
    public static int largestSumPathMemTable(int arr[][], int row, int col, int rowLength, int colLength) {
        if (row >= rowLength || col >= colLength || col < 0)
            return 0;

        if (lookUpTable[row][col] != Integer.MIN_VALUE)
            return lookUpTable[row][col];

        return lookUpTable[row][col] = (arr[row][col] + Math.max(Math.max(largestSumPathMemTable(arr, row + 1, col, rowLength, colLength),
                largestSumPathMemTable(arr, row + 1, col - 1, rowLength, colLength)),
                largestSumPathMemTable(arr, row + 1, col + 1, rowLength, colLength)));

    }

    //Time complexity: O(n3} as for each column in first row we call largestSum method
    public static int wrapperLargestSumPathMemTable(int arr[][]) {
        for(int i=0; i < lookUpTable.length; ++i){
            for (int j=0; j < lookUpTable[i].length; ++j){
                lookUpTable[i][j] = Integer.MIN_VALUE;
            }
        }

        int maxPathSum = Integer.MIN_VALUE, currPathSum = 0;
        for (int i = 0; i < arr[0].length; ++i) {
            currPathSum = largestSumPathMemTable(arr, 0, i, arr.length, arr[0].length);
            if (currPathSum > maxPathSum)
                maxPathSum = currPathSum;
        }
        return maxPathSum;
    }

    //DP
    //BottomUp Approach : Time complexity:  O(n2)
    public static int largestSumDP(int arr[][]){
        int maxSumPath[][] = new int[arr.length][arr[0].length+2]; // +2 for column to accomodate for j+1 for all rows.
        //copy first row of input into dpMatrix
        for (int i = 0 ; i < arr.length ; i++)
            maxSumPath[0][i+1] = arr[0][i];

        for(int i=1; i < arr.length; ++i){
            for(int j=1; j <=arr[0].length; ++j){
                maxSumPath[i][j] =arr[i][j-1] +  Math.max(Math.max(maxSumPath[i-1][j-1],
                                                        maxSumPath[i-1][j]),
                                                        maxSumPath[i-1][j+1]);
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i=0; i<=arr.length; i++)
            // final row will contain sum of all paths from each column
            result = Math.max(result, maxSumPath[arr.length-1][i]);
        return result;
    }




    public static void main(String [] args){
        int arr [][]  = { {4, 2, 3, 4},
                        {2, 9, 1, 10},
                        {15, 1, 3, 0},
                        {16, 92, 41, 44} };
        System.out.println(wrapperLargestSumPath(arr));
        System.out.println(wrapperLargestSumPathMemTable(arr));
        System.out.println(largestSumDP(arr));
    }
}
