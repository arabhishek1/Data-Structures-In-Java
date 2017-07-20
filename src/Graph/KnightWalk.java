package Graph;

import java.util.*;

/**
 * Created by abhishek.ar on 20/07/17.
 Given a chess board of order NxM and source points (s1,s2) and destination points (d1,d2), Your task to find min number
 of moves required by the Knight(Horse) to go to the destination cell.

 The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.

 If yes, then what would be the minimum number of steps for the knight to move to the said point.
 If knight can not move from the source point to the destination point, then return -1
 */
public class KnightWalk {

    //Class to track Knights movement as well as distance travelled till now.
    static class Cell {
        int row;
        int col;
        int distance;

        public Cell(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

    }

    public static int GetKnightWalk(int arr[][], int srcRow, int srcCol, int destRow, int destCol){
        boolean visited [][] = new boolean[arr.length][arr[0].length];
        return bfs(arr, visited, srcRow, srcCol, destRow, destCol);
    }

    private static int bfs(int[][] arr, boolean[][] visited, int srcRow, int srcCol, int destRow, int destCol) {
        Queue<Cell> queue = new LinkedList<>();
        Cell c = new Cell(srcRow, srcCol, 0);
        queue.add(c);
        visited[srcRow][srcCol] = true;

        //knights movement
        int R[] = {-2, -2, -1, 1, -1, 1, 2, 2};
        int C[] = {-1, 1, -2, -2, 2, 2, -1, 1};
        while(!queue.isEmpty()){
            Cell currentCell = queue.poll();
            if (currentCell.row == destRow && currentCell.col == destCol){
                return currentCell.distance;
            }
            for(int i=0; i < 8; ++i){
                if (isSafe(arr, visited, currentCell.row+R[i], currentCell.col+C[i])){
                    visited[currentCell.row+R[i]][ currentCell.col+C[i]]= true;
                    Cell newCell = new Cell(currentCell.row+R[i], currentCell.col+C[i], currentCell.distance+1);
                    queue.add(newCell);
                }
            }
        }
        return -1;
    }

    private static boolean isSafe(int[][] arr, boolean[][] visited, int row, int col) {
        if (row>=0 && row < arr.length && col >=0 && col < arr[0].length &&  !visited[row][col])
            return true;
        return false;
    }

    public static void main(String[] args) {
        int [][] arr = new int[8][8];
        System.out.println(GetKnightWalk(arr,0,0,7,7));
    }
}
