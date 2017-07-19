package Graph;

/**
 * Created by abhishek.ar on 19/07/17.
 Find whether there is path between two cells in matrix
 Given N X N matrix filled with 1 , 0 , 2 , 3 . Find whether there is a path possible from source to destination,
 traversing through blank cells only. You can traverse up, down, right and left.

 A value of cell 1 means Source.
 A value of cell 2 means Destination.
 A value of cell 3 means Blank cell.
 A value of cell 0 means Blank Wall.
 Note : there is only single source and single destination(sink).

 Examples:

 Input : M[3][3] = {{ 0 , 3 , 2 },
 { 3 , 3 , 0 },
 { 1 , 3 , 0 }};
 Output : Yes

 Input : M[4][4] = {{ 0 , 3 , 1 , 0 },
 { 3 , 0 , 3 , 3 },
 { 2 , 3 , 0 , 3 },
 { 0 , 3 , 3 , 3 }};
 Output : Yes
 **
 */
public class FindpathBetweenTwoCells {

    public static boolean findPath(int arr[][]){
        boolean visited [][] = new boolean[arr.length][arr[0].length];
        for(int i=0; i < arr.length; ++i){
            for(int j=0; j < arr.length ; ++j) {
                if (arr[i][j] == 1) {
                    return dfs(arr, i, j, visited, false);
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int arr[][], int row, int col, boolean[][] visited){
        if (row>=0 && row < arr.length && col >=0 && col < arr[0].length && (arr[row][col] == 3 || arr[row][col] == 2) && !visited[row][col])
            return true;
        return false;
    }

    private static boolean dfs(int[][] arr, int row, int col, boolean[][] visited, boolean isPathExist) {
        visited[row][col] = true;
        int R[] = {-1, 0 , 0, 1};
        int C[] = {0, -1, 1, 0};
        for(int i=0; i < 4; ++i){
            if (arr[row][col] == 2) {
                isPathExist = true;
            } else{
                visited[row][col]=true;
                if (isSafe(arr, row + R[i], col + C[i], visited)){
                    isPathExist = dfs(arr,row + R[i], col + C[i], visited, isPathExist);
                }
            }
        }
        return isPathExist;
    }

    public static void main(String[] args) {
        int arr[][] =
            {{ 0 , 3 , 1 , 0 },
               { 3 , 0 , 3 , 0 },
               { 2 , 3 , 3 , 0 },
               { 0 , 0 , 0 , 3 }};
        System.out.println(findPath(arr));
    }
}
