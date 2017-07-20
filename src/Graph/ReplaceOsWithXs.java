package Graph;

/**
 * Created by abhishek.ar on 20/07/17.
 Given a matrix of size NxM where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’.
 A ‘O’ (or a set of ‘O’) is considered to be by surrounded by ‘X’ if there are ‘X’ at locations just below, just above,
 just left and just right of it.


 Examples:

 Input: mat[N][M] =
 {{'X', 'O', 'X', 'X', 'X', 'X'},
 {'X', 'O', 'X', 'X', 'O', 'X'},
 {'X', 'X', 'X', 'O', 'O', 'X'},
 {'O', 'X', 'X', 'X', 'X', 'X'},
 {'X', 'X', 'X', 'O', 'X', 'O'},
 {'O', 'O', 'X', 'O', 'O', 'O'},
 };
 Output: mat[N][M] =
 {{'X', 'O', 'X', 'X', 'X', 'X'},
 {'X', 'O', 'X', 'X', 'X', 'X'},
 {'X', 'X', 'X', 'X', 'X', 'X'},
 {'O', 'X', 'X', 'X', 'X', 'X'},
 {'X', 'X', 'X', 'O', 'X', 'O'},
 {'O', 'O', 'X', 'O', 'O', 'O'},
 };

 */
public class ReplaceOsWithXs {

    public static void replaceOswithXs(char arr[][]){
        boolean visited[][] = new boolean[arr.length][arr.length];
        for(int i=0 ; i <arr.length; ++i){
            for(int j=0; j < arr[0].length; ++j)
                if (!visited[i][j])
                    dfs(arr, visited, i,j);
        }

    }

    private static void dfs(char[][] arr, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        // moving from current cell in all 8 directions
        int R[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int C[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i=0; i < 8; ++i){
            int currentRow= row+R[i], currentCol =col + C[i];
            if (isSafe(arr, visited, currentRow, currentCol )){
                //Iterate till we get the surrounding as X skipping all O in between in all directions

                int topRow = currentRow-1, topCol =currentCol, top = arr[topRow][topCol];
                while(topRow > 0 && topRow < arr.length-1 && top == 'O'){
                    topRow -= 1;
                    top = arr[topRow][topCol];
                }

                int bottomRow = currentRow+1, bottomCol =currentCol, bottom = arr[bottomRow][bottomCol];
                while(bottomRow > 0 && bottomRow < arr.length-1 && bottom == 'O'){
                    bottomRow += 1;
                    bottom = arr[bottomRow][bottomCol];
                }

                int leftRow= currentRow, leftCol = currentCol -1, left = arr[leftRow][leftCol];
                while(leftCol > 0 && leftCol < arr.length-1 && left == 'O'){
                    leftCol -= 1;
                    left = arr[leftRow][leftCol];
                }

                int rightRow = currentRow, rightCol = currentCol+1, right = arr[rightRow][rightCol];
                while(rightCol > 0 && rightCol < arr.length-1 && right == 'O'){
                    rightCol += 1;
                    right = arr[rightRow][rightCol];
                }

                if (top == 'X' && bottom == 'X' && left == 'X' && right == 'X'){
                    arr[currentRow][currentCol] = 'X';
                    dfs(arr, visited, currentRow, currentCol);
                }
            }
        }
    }

    //Check only for 'O' charcater
    private static boolean isSafe(char[][] arr, boolean[][] visited, int row, int col) {
        if (row >0 && row < arr.length-1 && col >0 && col < arr[0].length-1 && arr[row][col] == 'O' && !visited[row][col])
            return true;
        return false;
    }

    public static void main(String[] args) {
        char mat[][] = {{'X', 'O', 'X', 'X', 'X', 'X'},
                        {'X', 'O', 'X', 'X', 'O', 'X'},
                        {'X', 'X', 'X', 'O', 'O', 'X'},
                        {'O', 'X', 'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'O', 'X', 'O'},
                        {'O', 'O', 'X', 'O', 'O', 'O'}};

        replaceOswithXs(mat);
        for(int i=0; i < mat.length; ++i){
            for(int j=0; j < mat[0].length; ++j)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}
