package Matrix;

/**
 * Created by abhishek.ar on 20/06/17.
 Inplace rotate square matrix by 90 degrees
 Given an square matrix, turn it by 90 degrees in anti-clockwise direction without using any extra space.

 Examples:

 Input
 1  2  3
 4  5  6
 7  8  9

 Output:
 3  6  9
 2  5  8
 1  4  7

 Input:
 1  2  3  4
 5  6  7  8
 9 10 11 12
 13 14 15 16

 Output:
 4  8 12 16
 3  7 11 15
 2  6 10 14
 1  5  9 13
 */
public class Rotateby90 {

    public static void rototeBY90AntiClockwise(int arr[][]){
        for(int i=0; i <arr.length; ++i){
            for(int j= i+1; j <arr[0].length; ++j) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }

        for(int k=0; k <arr.length; ++k){
            int i=0,  j= arr.length-1;
            while(i < j) {
                int temp = arr[i][k];
                arr[i][k] = arr[j][k];
                arr[j][k] = temp;
                ++i;
                --j;
            }
        }
        display(arr);
    }



    public static void display(int arr[][]){
        for (int i=0; i < arr.length; ++i){
            for(int j=0; j <arr[0].length; ++j){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] ={
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        display(arr);
        rototeBY90AntiClockwise(arr);
    }
}
