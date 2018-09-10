package Matrix;

public class SpriralPrintingMatrix {

    public static void printSpiral(int [][] arr){

        int rowStart = 0, colStart =0, rowEnd = arr.length, colEnd = arr[0].length;

        while(rowStart < rowEnd && colStart < colEnd){

            for(int i=colStart; i < colEnd; ++i){
                System.out.print(arr[rowStart][i] + " ");
            }
            ++rowStart;


            for(int i=rowStart; i < rowEnd; ++i){
                System.out.print(arr[i][colEnd-1] + " ");
            }
            --colEnd;


            for(int i=colEnd-1; i >=colStart && rowStart < rowEnd; --i ){
                System.out.print(arr[rowEnd-1][i] + " ");
            }
            --rowEnd;


            for(int i=rowEnd-1; i >=rowStart && colStart < colEnd; --i){
                System.out.print(arr[i][colStart]+ " ");
            }
            ++colStart;

        }
    }

    public static void main(String[] args) {
        int arr[][] = {
                {1,  2,  3},
                {4,  5,  6},
                {7,  8,  9,},
                {10, 11, 12},
                {13, 14, 15},
                { 16, 17, 18}
        };
        printSpiral(arr);
    }
}
