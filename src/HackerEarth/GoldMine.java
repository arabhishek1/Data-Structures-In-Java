package HackerEarth;

/**
 * Created by abhishek.ar on 11/06/17.
 * <p>
 * There is a rectangular grid of gold mine. The grid has R rows and C columns. So it has R*C cells in total.
 * The rows are numbered from 1 to R and the columns are numbered from 1 to C. The top most row has number 1,
 * the row next to it has number 2 and so on. Similarly, the left most column has number 1, the column next to it has
 * number 2 and so on. Each cell in the grid has a unique coordinate which is (x, y) where x is the row number and y
 * is the column number of that particular cell.
 * <p>
 * Each cell in the grid has certain amount of gold in it. Total gold in a sub rectangle of the grid is the sum of all
 * units of gold contained in the cells that are inside the rectangle. Your task is to find the total gold in the given
 * sub rectangle.
 * <p>
 * A sub rectangle of the grid is defined by four integers x1, y1, x2 and y2. A cell (x, y) belongs to the sub rectangle
 * if and only if x1 <= x <= x2 and y1 <= y <=y2
 * <p>
 * Input
 * First line of the input contains two space separated integers, R and C. It is followed by R lines, each line has C
 * space separated integers. Each integer denotes the units of gold present in that particular cell.
 * Next line has number Q, it is followed by Q queries each query in a single line. Each query is four space separated
 * integers x1, y1, x2 and y2.
 * <p>
 * Output
 * For each query, you have to print a single number the total gold contained in that sub rectangle.
 * <p>
 * Constraints
 * 1 <= R <= 1000
 * 1 <= C <= 1000
 * 1 <= x1 <= x2 <= R
 * 1 <= y1 <= y2 <= C
 * Amount of gold in each cell is an integer from 0 to 10^6
 * <p>
 * Sample Input
 * 4 4
 * 2 8 9 7
 * 5 8 1 7
 * 5 7 3 5
 * 4 8 7 4
 * 4
 * 1 2 4 2
 * 1 4 2 4
 * 1 1 4 2
 * 2 4 2 4
 * <p>
 * Sample Output
 * 31
 * 14
 * 47
 * 7
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;


class GoldMine {

    public static long computeGoldMines(long[][] arr, int x1, int y1, int x2, int y2) {
        long sum =0;
        for(int i=x1; i <=x2; ++i){
            for(int j=y1; j <=y2; ++j){
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int row = Integer.parseInt(line[0]);
        int col = Integer.parseInt(line[1]);
        long arr[][] = new long[row][col];
        int i=0, j=0;
        while(i < row){
            String[] input = br.readLine().split(" ");
            while(j < col){
                arr[i][j] = Integer.parseInt(input[j]);
                ++j;
            }
            ++i;
            j=0;
        }
        int noOfQueries = Integer.parseInt(br.readLine());
        int k=0;
        int x1, x2, y1, y2;
        while(k <noOfQueries){
            String [] query = br.readLine().split(" ");
            x1 = Integer.parseInt(query[0]);
            y1 = Integer.parseInt(query[1]);
            x2 = Integer.parseInt(query[2]);
            y2 = Integer.parseInt(query[3]);
            System.out.println(computeGoldMines(arr, x1-1, y1-1, x2-1, y2-1));
            ++k;
        }
    }

    private static void displayArr(int[][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length; ++j)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }

    }


}

