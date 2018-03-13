package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 12/03/18.
 Given a partially filled 9×9 2D array ‘grid[9][9]’, the goal is to assign digits (from 1 to 9) to the empty cells so
 that every row, column, and subgrid of size 3×3 contains exactly one instance of the digits from 1 to 9

 Backtracking Algorithm
 Like all other Backtracking problems, we can solve Sudoku by one by one assigning numbers to empty cells.
 Before assigning a number, we check whether it is safe to assign. We basically check that the same number is not
 present in current row, current column and current 3X3 subgrid. After checking for safety, we assign the number, and
 recursively check whether this assignment leads to a solution or not. If the assignment doesn’t lead to a solution,
 then we try next number for current empty cell. And if none of number (1 to 9) lead to solution, we return false.
 */
public class Sudoku {

    public static boolean solveSudoku(int arr[][]){

        int list[] = {0,0}; //list to maintain row and col values for iteration
        if (!isUnassignedPresent(arr, list))
            return true;
        int row = list[0];
        int col = list[1];
        for(int num=1; num <=9; ++num){
            if(isSafe(arr, row, col, num)){
                arr[row][col] = num;// Make tentative assignment
                if (solveSudoku(arr)) //Validate the assignment
                    return true;
                arr[row][col] =0;// Revert assignment in case of failure
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] arr, int row, int col, int num) {
        return isRowSafe(arr, row, num) && isColSafe(arr, col, num) && isGridSafe(arr, row-row%3, col-col%3, num);
    }

    private static boolean isGridSafe(int[][] arr, int rowStart, int colStart, int num) {
        for(int i=0; i <3; ++i){
            for(int j=0; j <3; ++j){
                if (arr[rowStart+i][colStart+j] == num)
                    return false;
            }
        }
        return true;
    }

    private static boolean isColSafe(int[][] arr, int col, int num) {
        for(int row=0; row <9; ++row)
            if(arr[row][col] == num)
                return false;
        return true;
    }

    private static boolean isRowSafe(int[][] arr, int row, int num) {
        for(int col=0; col <9; ++col)
            if (arr[row][col] == num)
                return false;
        return true;
    }


    private static boolean isUnassignedPresent(int[][] arr, int [] list) {
        for(int i=0; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length; ++j) {
                if (arr[i][j] == 0) {
                    list[0] = i;
                    list[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        if(solveSudoku(grid)){
            for(int i=0; i <grid.length; ++i){
                for(int j=0; j < grid[0].length; ++j){
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution");
        }
    }


}
