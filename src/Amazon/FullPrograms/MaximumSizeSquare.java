package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 26/03/18.
 Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

 For example, consider the below binary matrix.
 0  1  1  0  1
 1  1  0  1  0
 0  1  1  1  0
 1  1  1  1  0
 1  1  1  1  1
 0  0  0  0  0


 */
public class MaximumSizeSquare {

    public static int maxSizeSquare(int arr[][]){
        int res[][] = new int[arr.length][arr[0].length];
        for(int i=0; i < arr.length; ++i){
            res[i][0] = arr[i][0];
        }

        for(int i=0; i < arr[0].length; ++i){
            res[0][i] = arr[0][i];
        }

        for(int i=1; i < arr.length; ++i){
            for(int j=1; j < arr[0].length; ++j){
                if (arr[i][j] == 1)
                    res[i][j] = Math.min(Math.min(res[i-1][j], res[i][j-1]),res[i-1][j-1]) + 1;
                else
                    res[i][j] = 0;
            }
        }

        int maxSize = Integer.MIN_VALUE;
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                if(maxSize < res[i][j]) {
                    maxSize = res[i][j];
                }
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(maxSizeSquare(arr));
    }
}
