package Graph;


/**
 * Created by abhishek.ar on 17/07/17.
 Consider a matrix with rows and columns (n,m), where each cell contains either a ‘0’ or a ‘1’ and any cell
 containing a 1 is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally,
 vertically, or diagonally .If one or more filled cells are connected, they form a region. Your task is to
 find the length of the largest region.

 Examples:

 Input : M[][5] =
 {
 0 0 1 1 0
 1 0 1 1 0
 0 1 0 0 0
 0 0 0 0 1
 }
 Output : 6
 Ex: in the following example, there are
 2 regions one with length 1 and the other as 6.
 so largest region : 6
 */
public class LargestRegion {

    public static int largestRegion(int arr[][]){
        boolean visited [][]= new boolean[arr.length][arr[0].length];
        int result = Integer.MIN_VALUE;
        for(int i=0; i < arr.length; ++i){
            for(int j=0; j < arr[0].length; ++j){
                if (arr[i][j] ==1 && !visited[i][j]){
                    int count = dfs(arr, i, j, visited, 1);
                    result = Math.max(count, result);
                }
            }
        }
        return result;
    }


    private static boolean isSafe(int row , int col, int arr[][], boolean[][] visited){
        if (row < arr.length && row >=0 && col < arr[0].length && col >=0 && arr[row][col] == 1 && !visited[row][col])
            return true;
        return false;
    }

    public static int dfs(int arr[][], int row, int col, boolean[][] visited, int count){
        int R[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int C[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int k=0; k <8; ++k){
            visited[row][col] = true;
            if (isSafe(row + R[k], col +C[k], arr, visited)){
                 count = dfs(arr, row + R[k], col +C[k], visited, ++count);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 1}
        };
      System.out.println(largestRegion(arr));
    }
}
